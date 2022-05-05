SUMMARY = "The core image for console-only device."
LICENSE = "MIT"

include recipes-i2som/images/i2som-image.inc

inherit core-image distro_features_check


#CONFLICT_DISTRO_FEATURES = "x11 wayland"

IMAGE_LINGUAS = "en-us"

IMAGE_FEATURES += "\
    package-management \
    ssh-server-openssh \
    "

#
# Optee part addons
#
IMAGE_OPTEE_PART = " \
    ${@bb.utils.contains('COMBINED_FEATURES', 'optee', 'packagegroup-optee-core', '', d)} \
    ${@bb.utils.contains('COMBINED_FEATURES', 'optee', 'packagegroup-optee-test', '', d)} \
    "

#
# INSTALL addons
#
CORE_IMAGE_EXTRA_INSTALL += " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'systemd-networkd-configuration', '', d)} \
    \
    packagegroup-framework-tools-core-base      \
    packagegroup-framework-tools-kernel-base    \
    packagegroup-framework-tools-network-base   \
    packagegroup-framework-tools-audio-base     \
    packagegroup-framework-tools-python2-base   \
    packagegroup-framework-tools-python3-base   \
    \
    ${IMAGE_OPTEE_PART}                         \
    packagegroup-i2som-core \
	hostapd \
    packagegroup-core-ssh-openssh \
    packagegroup-core-eclipse-debug \
    openssh-sshd \
    openssh \
    openssh-sftp \
    openssh-sftp-server \
	ntp \
	ntp-utils \
    "
