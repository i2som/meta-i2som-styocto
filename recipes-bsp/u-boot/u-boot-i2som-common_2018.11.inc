# Adaptation from u-boot-common_${PV}.inc

HOMEPAGE = "http://www.denx.de/wiki/U-Boot/WebHome"
SECTION = "bootloaders"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=30503fd321432fc713238f582193b78e"

DEPENDS += "dtc-native bc-native"
DEPENDS += "flex-native bison-native"

COMPATIBLE_MACHINE = "(stm32mpcommon)"

SRC_URI = "git:///${HOME}/PanGu/u-boot-st;protocol=file"
SRCREV = ""

U_BOOT_VERSION = "2018.11"
PV = "${U_BOOT_VERSION}"

S = "${WORKDIR}/u-boot-${PV}"

# ---------------------------------
# Configure devupstream class usage
# ---------------------------------
BBCLASSEXTEND = "devupstream:target"

#SRC_URI_class-devupstream = "git://github.com/STMicroelectronics/u-boot.git;name=uboot;protocol=https;branch=v2018.11-stm32mp"
SRC_URI_class-devupstream = "git:///${HOME}/PanGu/u-boot-st;name=uboot;protocol=file;branch=v2018.11-r2.2-pangu"
SRCREV_class-devupstream = "656fae510f3759be3bcc2f0f7938951855592832"
SRCREV_FORMAT_class-devupstream = "uboot"
PV_class-devupstream = "${U_BOOT_VERSION}+github+${SRCPV}"

# ---------------------------------
# Configure default preference to manage dynamic selection between tarball and github
# ---------------------------------
STM32MP_SOURCE_SELECTION ?= "github"

DEFAULT_PREFERENCE = "${@bb.utils.contains('STM32MP_SOURCE_SELECTION', 'github', '-1', '1', d)}"
