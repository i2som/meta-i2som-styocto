#
# Copyright (C) 2020 i2SOM Team.
#

SUMMARY = "Core packagegroup for i2SOM Yocto image"

PACKAGE_ARCH = "${MACHINE_ARCH}"
inherit packagegroup

#
# Set by the machine configuration with packages essential for device bootup
#
MACHINE_ESSENTIAL_EXTRA_RDEPENDS ?= ""
MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS ?= ""

RDEPENDS_${PN} = "\
    u-boot-fw-utils \
    tzdata \
    i2bootchoose \
    iperf3 \
    htop \
    netbase \
    hostapd \
    i2c-tools \
    phytool \
    mmc-utils \
    usbutils \
    e2fsprogs-mke2fs \
    e2fsprogs-resize2fs \
"

RRECOMMENDS_${PN} = "\
    ${MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS} \
    ${MACHINE_EXTRA_RRECOMMENDS} \
"
