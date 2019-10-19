# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Launch qtsmarthome application"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " file://qtdemo.service \
            file://qtdemo.sh"

inherit systemd

SYSTEMD_PACKAGES = "${@bb.utils.contains('DISTRO_FEATURES','systemd','${PN}','',d)}"
SYSTEMD_SERVICE_${PN} = "${@bb.utils.contains('DISTRO_FEATURES','systemd','qtdemo.service','',d)}"
SYSTEMD_AUTO_ENABLE_${PN} = "enable"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${prefix}/local
    install -m 0755 ${WORKDIR}/qtdemo.sh ${D}${prefix}/local/

    if ${@bb.utils.contains('DISTRO_FEATURES','systemd','true','false',d)}; then
        install -d ${D}${systemd_unitdir}/system
        install -m 644 ${WORKDIR}/*.service ${D}/${systemd_unitdir}/system
    fi
}
FILES_${PN} = "${prefix}/local "
