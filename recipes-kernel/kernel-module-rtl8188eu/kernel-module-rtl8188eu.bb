# Copyright (C) 2017 i2SOM Team.

SUMMARY = "The driver for RTL8188EU USB WiFi"
DESCRIPTION = "rtl8188eu USB WiFi"
LICENSE = "GPLv2"
#PV = "v2017.01.11"
LIC_FILES_CHKSUM = "file://Makefile;md5=65a96941beb12ed1b5c774a46751740d"

inherit module

SRCBRANCH = "master"
SRCREV = "604bc3569321d29401719c9077d0f1af44d2740c"

GIT_URI = "git://github.com/i2som/RTL8188EU.git;protocol=https"

SRC_URI = " \
    ${GIT_URI};branch=${SRCBRANCH} \
"

S = "${WORKDIR}/git"

EXTRA_OEMAKE += "KERNELDIR=${STAGING_KERNEL_DIR}"
