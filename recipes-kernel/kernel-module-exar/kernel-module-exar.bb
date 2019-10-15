# Copyright (C) 2017 i2SOM Team.

SUMMARY = "Exar's USB to Serial driver for XR21V1414IM"
DESCRIPTION = "xr21v1414 module"
LICENSE = "GPLv2"
PV = "v2017.01.11"
LIC_FILES_CHKSUM = "file://COPYING;md5=e3965efe975a36fd83b89d0c5ae38d49"

inherit module

SRCBRANCH = "master"
SRCREV = "d82bef3fa876be65c26a4b9b6171d7139341f5c7"

GIT_URI = "git://github.com/i2som/Exar-XR21V1414.git;protocol=git"

SRC_URI = " \
    ${GIT_URI};branch=${SRCBRANCH} \
"

S = "${WORKDIR}/git"

EXTRA_OEMAKE += "KERNELDIR=${STAGING_KERNEL_DIR}"
