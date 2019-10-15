SUMMARY = "Touch calibrate and test"
LICENSE = "CLOSED"

SRC_URI = "file://tscalibrate"

DEPENDS = "qtbase tslib"

do_package_qa[noexec] = "1"

do_install () {
	install -m 0755 -d ${D}${bindir}
	install -m 0755 ${WORKDIR}/tscalibrate ${D}${bindir}
}
