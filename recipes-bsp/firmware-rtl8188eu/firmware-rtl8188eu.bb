SUMMARY = "The firemware for i2M-WiFi-USB module"
LICENSE = "GPLv2"
PV = "0.1"
LIC_FILES_CHKSUM = "file://LICENCE;md5=3578920d6ebbe512b039a334114b29a5"

SRC_URI = " \
    file://rtl8188eufw.bin \
    file://LICENCE \
"

S = "${WORKDIR}"

do_install (){
    install -d ${D}${base_libdir}/firmware/rtlwifi
    cp -rfv rtl8188eufw.bin ${D}${base_libdir}/firmware/rtlwifi/
}


FILES_${PN} = " \
    ${base_libdir}/firmware/rtlwifi \
"
