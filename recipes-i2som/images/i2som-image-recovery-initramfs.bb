#
# Copyright (C) 2017 i2SOM Team.
#

DESCRIPTION = "Recovery system image"
LICENSE = "MIT"

# reset default install packages
PACKAGE_INSTALL = ""

IMAGE_FEATURES = ""
IMAGE_LINGUAS = ""

inherit core-image

PACKAGE_INSTALL += " \
	busybox \
	parted \
	psplash \
	gptfdisk \
	recovery-initramfs \
	wipe \
	mmc-utils \
	util-linux-sfdisk \
	e2fsprogs-mke2fs \
	e2fsprogs-resize2fs \
	mtd-utils-ubifs \
	rauc \
	dbus \
	swupdate \
	u-boot-fw-utils \
"

IMAGE_ROOTFS_SIZE = "8192"

IMAGE_FSTYPES = "cpio.gz.u-boot ext2.gz"
