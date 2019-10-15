# Copyright (C) 2019 i2SOM Team Steve Chen 
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "This program used to switch boot menu"
HOMEPAGE = "http://i2som.com"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS = "qtbase"

# The resutling packages are machine dependent, because the phytec-qtdemo.service
# unit is different for ti33x machines.
PACKAGE_ARCH = "${MACHINE_ARCH}"
PR = "r0"

SRC_URI = "git://github.com/i2som/i2bootchoose.git;protocol=git;"
SRCREV = "0f3b0aa010d409bb8542014701794391c6f3682f"
PV = "0.1+git${SRCPV}"

S = "${WORKDIR}/git"

inherit qmake5

do_install_append() {
    install -d ${D}${bindir}
    install -m 0777 i2bootchoose ${D}${bindir}/i2bootchoose
}
