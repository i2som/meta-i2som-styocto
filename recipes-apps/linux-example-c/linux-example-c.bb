DESCRIPTION = "c-lang example for linux system"
LICENSE = "MIT"
LIC_FILES_CHKSUM ="file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
PR = "r0"

SRC_URI = "git://github.com/i2som/Linux-example.git;protocol=https;branch=master"
SRCREV="${AUTOREV}"
S = "${WORKDIR}/git"

DEPENDS = "libgpiod alsa-lib"

EXTRA_OECMAKE=" -DCMAKE_INSTALL_PREFIX=${prefix}/local/Linux-A7-examples/ "

inherit pkgconfig cmake

FILES_${PN} = " \
	${prefix}/local/Linux-A7-examples/rs485-send \
	${prefix}/local/Linux-A7-examples/uart-test \
	${prefix}/local/Linux-A7-examples/libgpiod-input \
	${prefix}/local/Linux-A7-examples/gpio-key \
	${prefix}/local/Linux-A7-examples/rtc-test \
	${prefix}/local/Linux-A7-examples/alsa_play \
	${prefix}/local/Linux-A7-examples/can-receive \
	${prefix}/local/Linux-A7-examples/spidev_test \
	${prefix}/local/Linux-A7-examples/libgpiod-led \
	${prefix}/local/Linux-A7-examples/watchdog-test \
	${prefix}/local/Linux-A7-examples/can-send \
	${prefix}/local/Linux-A7-examples/alsa_capture \
	${prefix}/local/Linux-A7-examples/libgpiod-event \
	${prefix}/local/Linux-A7-examples/rs485-receive \
	${prefix}/local/Linux-A7-examples/uart-select \
"

