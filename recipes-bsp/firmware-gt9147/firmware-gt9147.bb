SUMMARY = "The firemware for touch panel"
LICENSE = "GPLv2"
PV = "0.1"
LIC_FILES_CHKSUM = "file://LICENCE;md5=c904ece62d4946884fb1089e643dcbfc"

SRC_URI = " \
    file://goodix_9147_cfg.bin \
    file://LICENCE \
"

S = "${WORKDIR}"

do_install (){
    install -d ${D}${base_libdir}/firmware
    cp -rfv goodix_9147_cfg.bin ${D}${base_libdir}/firmware
}


FILES_${PN} = " \
    ${base_libdir}/firmware \
"
