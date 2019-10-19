SUMMARY = "Touch calibrate and test"
LICENSE = "CLOSED"

SRC_URI = "file://tscalibrate file://calibrate.ini"

DEPENDS = "qtbase tslib"

do_package_qa[noexec] = "1"

do_install () {
	install -d ${D}${bindir}
	install -d ${D}${prefix}/local/i2som/appentry

	install -m 0755 ${WORKDIR}/tscalibrate ${D}${bindir}
	install -m 0755 ${WORKDIR}/calibrate.ini ${D}${STM32MP_USERFS_MOUNTPOINT_IMAGE}/i2som/appentry
}

FILES_${PN} = "${prefix}/local ${prefix}/bin"
