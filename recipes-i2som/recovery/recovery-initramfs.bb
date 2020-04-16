#
# Copyright (C) 2017 i2SOM Team.
#

SUMMARY = "Recovery system files"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = " \
	file://recovery-initramfs-init \
	file://swupdate.cfg \
	file://automount_block.sh \
	file://automount_mtd.sh \
	file://mdev.conf \
"

S = "${WORKDIR}"

do_install() {
	install -d ${D}${sysconfdir}
	install -d ${D}${base_sbindir}
	install -m 0755 ${WORKDIR}/recovery-initramfs-init ${D}${base_sbindir}/init
	install -m 0644 ${WORKDIR}/swupdate.cfg ${D}${sysconfdir}
	install -d ${D}${base_libdir}/mdev
	install -m 0755 ${WORKDIR}/automount_block.sh ${D}${base_libdir}/mdev/automount_block.sh
	install -m 0755 ${WORKDIR}/automount_mtd.sh ${D}${base_libdir}/mdev/automount_mtd.sh
	install -m 0644 ${WORKDIR}/mdev.conf ${D}${sysconfdir}

	rm -rf ${D}${localstatedir}/lock
}

# Do not create debug/devel packages
PACKAGES = "${PN}"

FILES_${PN} = "/ "

RDEPENDS_${PN} = " \
	cryptsetup \
	rng-tools \
"
