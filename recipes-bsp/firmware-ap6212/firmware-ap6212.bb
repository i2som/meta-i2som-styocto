SUMMARY = "These firemware for AP6212 WiFi & BT module"
LICENSE = "GPLv2"
PV = "0.1"
LIC_FILES_CHKSUM = "file://LICENCE;md5=4ca23a1ee9203873546234d28d356ba7"

SRC_URI = " \
    file://BCM43430A1.hcd \
    file://brcmfmac43430-sdio.bin \
    file://brcmfmac43430-sdio.clm_blob \
    file://brcmfmac43430-sdio.txt \
    file://brcmfmac43430a0-sdio.bin \
    file://brcmfmac43430a0-sdio.txt \
    file://LICENCE \
"

S = "${WORKDIR}"

do_install (){
	install -d ${D}${nonarch_base_libdir}/firmware/brcm/
	# Install calibration file
	install -m 0644 ${WORKDIR}/brcmfmac43430-sdio.txt ${D}${nonarch_base_libdir}/firmware/brcm/

	#take newest murata firmware
	install -m 0644 ${WORKDIR}/brcmfmac43430-sdio.bin ${D}${nonarch_base_libdir}/firmware/brcm/
	install -m 0644 ${WORKDIR}/brcmfmac43430-sdio.clm_blob ${D}${nonarch_base_libdir}/firmware/brcm/brcmfmac43430-sdio.clm_blob

	install -m 644 ${WORKDIR}/BCM43430A1.hcd ${D}${nonarch_base_libdir}/firmware/brcm/BCM43430A1.hcd

	install -m 0644 ${WORKDIR}/brcmfmac43430a0-sdio.bin ${D}${nonarch_base_libdir}/firmware/brcm/
	install -m 0644 ${WORKDIR}/brcmfmac43430a0-sdio.txt ${D}${nonarch_base_libdir}/firmware/brcm/
}


FILES_${PN} = " \
    ${base_libdir}/firmware/brcm \
"
