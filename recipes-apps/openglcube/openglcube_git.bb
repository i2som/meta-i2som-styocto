# Copyright (C) 2019 i2SOM Team Steve Chen
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "This program use OpenGL to show a cube"
HOMEPAGE = "http://i2som.com"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS = "qtbase"

PACKAGE_ARCH = "${MACHINE_ARCH}"
PR = "r0"

SRC_URI = "git://github.com/i2som/openglcube.git;protocol=git;"
SRCREV = "56c7cf9e68105be979916d318af09a1a90968989"
PV = "0.1+git${SRCPV}"

SRC_URI_append = " file://openglcube.ini"

S = "${WORKDIR}/git"

inherit qmake5

do_install_append() {
    install -d ${D}${prefix}/local/i2som/bin/
    install -d ${D}${prefix}/local/i2som/appentry

    install -m 0755 ${B}/openglcube ${D}${STM32MP_USERFS_MOUNTPOINT_IMAGE}/i2som/bin
    install -m 0755 ${WORKDIR}/openglcube.ini ${D}${STM32MP_USERFS_MOUNTPOINT_IMAGE}/i2som/appentry
}

FILES_${PN} = "${prefix}/local/i2som"
