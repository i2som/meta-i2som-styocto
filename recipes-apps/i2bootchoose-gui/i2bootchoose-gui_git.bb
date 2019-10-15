# Copyright (C) 2019 i2SOM Team Steve Chen
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "This program used to switch boot menu with Qt"
HOMEPAGE = "http://i2som.com"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS = "qtbase"

PACKAGE_ARCH = "${MACHINE_ARCH}"
PR = "r0"

SRC_URI = "git://github.com/i2som/i2bootchoose_gui.git;protocol=git;"
SRCREV = "b8277b59f1be06bcf80a86a08c2407f8703843e2"
PV = "0.1+git${SRCPV}"

S = "${WORKDIR}/git"

inherit qmake5

do_install_append() {
    install -d ${D}${prefix}/local/i2som/bin/

    install -m 0755 ${B}/i2bootchoose_gui ${D}${STM32MP_USERFS_MOUNTPOINT_IMAGE}/i2som/bin
}

FILES_${PN} = "${prefix}/local"
