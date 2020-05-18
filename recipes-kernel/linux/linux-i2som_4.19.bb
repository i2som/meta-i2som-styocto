SUMMARY = "Linux STM32MP Kernel"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

include linux-i2som.inc

LINUX_VERSION = "4.19"

S = "${WORKDIR}/git"

# ---------------------------------
# Configure devupstream class usage
# ---------------------------------
BBCLASSEXTEND = "devupstream:target"

SRC_URI = "git:///${HOME}/i2SOM-STM32MP1/linux-st;protocol=file;branch=v${LINUX_VERSION}-r1.4-pangu;name=linux"
SRCREV = "44c0cc69d56774aec6628be08ae9dab9e14be97d"
SRCREV_FORMAT = "linux"
PV = "${LINUX_VERSION}+github+${SRCPV}"

# ---------------------------------
# Configure default preference to manage dynamic selection between tarball and github
# ---------------------------------
#STM32MP_SOURCE_SELECTION ?= "github"

#DEFAULT_PREFERENCE = "${@bb.utils.contains('STM32MP_SOURCE_SELECTION', 'github', '-1', '1', d)}"

# -------------------------------------------------------------
# Defconfig
#
KERNEL_DEFCONFIG        = "i2som_panguboard_defconfig"
KERNEL_CONFIG_FRAGMENTS = "${@bb.utils.contains('KERNEL_DEFCONFIG', 'i2som_panguboard_defconfig', '${S}/arch/arm/configs/fragment-01-multiv7_cleanup.config', '', d)}"
#KERNEL_CONFIG_FRAGMENTS += "${@bb.utils.contains('KERNEL_DEFCONFIG', 'i2som_panguboard_defconfig', '${S}/arch/arm/configs/fragment-02-multiv7_addons.config', '', d)}"
#KERNEL_CONFIG_FRAGMENTS += "${@bb.utils.contains('DISTRO_FEATURES', 'systemd', '${WORKDIR}/fragments/4.19/fragment-03-systemd.config', '', d)} "
#KERNEL_CONFIG_FRAGMENTS += "${@bb.utils.contains('COMBINED_FEATURES', 'optee', '${WORKDIR}/fragments/4.19/fragment-04-optee.config', '', d)}"
#KERNEL_CONFIG_FRAGMENTS += "${WORKDIR}/fragments/4.19/fragment-05-modules.config"

# Don't forget to add/del for devupstream
#SRC_URI_class-devupstream += " file://4.19/fragment-03-systemd.config;subdir=fragments "
#SRC_URI_class-devupstream += " file://4.19/fragment-04-optee.config;subdir=fragments "
#SRC_URI_class-devupstream += " file://4.19/fragment-05-modules.config;subdir=fragments "

# -------------------------------------------------------------
# Kernel Args
#
KERNEL_EXTRA_ARGS += "LOADADDR=${ST_KERNEL_LOADADDR}"

# -------------------------------------------------------------
# Archiver
#
#inherit archiver
#ARCHIVER_MODE[src] = "${@'original' if d.getVar('ST_ARCHIVER_ENABLE') == '1' else ''}"
#SRC_URI =+ "file://README.HOW_TO.txt"

#inherit archiver_stm32mp_clean
