SUMMARY = "Launcher application"
LICENSE = "CLOSED"

SRC_URI = "file://i2Launcher \
	   file://Launcher.ini \
	   file://ThemeKind.ini \
	   file://i2launcher.service \
	   file://i2launcher.sh"

DEPENDS = "qtbase"

do_package_qa[noexec] = "1"

inherit systemd

SYSTEMD_PACKAGES = "${@bb.utils.contains('DISTRO_FEATURES','systemd','${PN}','',d)}"
SYSTEMD_SERVICE_${PN} = "${@bb.utils.contains('DISTRO_FEATURES','systemd','i2launcher.service','',d)}"

do_install () {
    install -d ${D}${prefix}/local/i2som/
    install -m 0755 ${WORKDIR}/i2Launcher ${D}${STM32MP_USERFS_MOUNTPOINT_IMAGE}/i2som/
    install -m 0755 ${WORKDIR}/i2launcher.sh ${D}${STM32MP_USERFS_MOUNTPOINT_IMAGE}/i2som/
    install -m 0755 ${WORKDIR}/Launcher.ini ${D}${STM32MP_USERFS_MOUNTPOINT_IMAGE}/i2som/
    
    install -d ${D}${prefix}/local/i2som/theme
    install -m 0555 ${WORKDIR}/ThemeKind.ini ${D}${STM32MP_USERFS_MOUNTPOINT_IMAGE}/i2som/theme/

    if ${@bb.utils.contains('DISTRO_FEATURES','systemd','true','false',d)}; then
        install -d ${D}${systemd_unitdir}/system
        install -m 644 ${WORKDIR}/*.service ${D}/${systemd_unitdir}/system
    fi
}

FILES_${PN} = "${prefix}/local"
