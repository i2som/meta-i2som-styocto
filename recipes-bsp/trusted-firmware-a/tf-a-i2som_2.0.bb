SUMMARY = "Trusted Firmware-A for STM32MP1"
SECTION = "bootloaders"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://license.rst;md5=e927e02bca647e14efd87e9e914b2443"

TF_VERSION = "2.0"
PV = "${TF_VERSION}"

#S = "${WORKDIR}/arm-trusted-firmware-${PV}"
S = "${WORKDIR}/git"

require tf-a-i2som-common.inc

# ---------------------------------
# Configure devupstream class usage
# ---------------------------------
BBCLASSEXTEND = "devupstream:target"

SRC_URI = "git://${HOME}/i2SOM-STM32MP1/arm-trusted-firmware;protocol=file;name=tfa;branch=panguboard"
SRCREV = "3b82231f54ace6b2392e756772e7d94943ed6814"
SRCREV_FORMAT = "tfa"
PV = "${TF_VERSION}+github+${SRCPV}"
# ---------------------------------
# Configure default preference to manage dynamic selection between tarball and github
# ---------------------------------
#STM32MP_SOURCE_SELECTION ?= "tarball"

#DEFAULT_PREFERENCE = "${@bb.utils.contains('STM32MP_SOURCE_SELECTION', 'github', '-1', '1', d)}"
