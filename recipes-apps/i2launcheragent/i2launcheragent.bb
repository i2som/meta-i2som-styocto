SUMMARY = "Launcher application"
LICENSE = "CLOSED"

SRC_URI = "file://i2LauncherAgent"

DEPENDS = "qtbase"

do_package_qa[noexec] = "1"

do_install () {
    install -d ${D}${prefix}/local/i2som
    install -m 0755 ${WORKDIR}/i2LauncherAgent ${D}${STM32MP_USERFS_MOUNTPOINT_IMAGE}/i2som
}

FILES_${PN} = "${prefix}/local"
