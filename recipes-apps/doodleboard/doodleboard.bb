SUMMARY = "Doodleboard for touch test"
LICENSE = "CLOSED"

SRC_URI = "file://touch-doodleboard file://doodleboard.ini"

DEPENDS = "qtbase tslib"

do_package_qa[noexec] = "1"

do_install () {
	install -d ${D}${bindir}
	install -d ${D}${prefix}/local/i2som/appentry

	install -m 0755 ${WORKDIR}/touch-doodleboard ${D}${bindir}
	install -m 0755 ${WORKDIR}/doodleboard.ini ${D}${STM32MP_USERFS_MOUNTPOINT_IMAGE}/i2som/appentry
}

FILES_${PN} = "${prefix}/local ${prefix}/bin"
