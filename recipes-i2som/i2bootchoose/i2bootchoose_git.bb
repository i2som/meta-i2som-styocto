# Copyright (C) 2019 i2SOM Team Steve Chen 
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "This program used to switch boot menu"
HOMEPAGE = "http://i2som.com"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

# The resutling packages are machine dependent, because the phytec-qtdemo.service
# unit is different for ti33x machines.
PACKAGE_ARCH = "${MACHINE_ARCH}"
PR = "r0"

SRC_URI = "git://github.com/i2som/i2bootchoose-cli.git;protocol=git;"
SRCREV = "18fbb41a81f86d305f2814c99326f4730b16097c"
PV = "0.1+git${SRCPV}"

S = "${WORKDIR}/git"

inherit cmake
