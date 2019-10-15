SUMMARY = "DEY sound card detection app"
LICENSE = "MIT"
LIC_FILES_CHKSUM ="file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRCBRANCH = "master"
SRCREV = "74f6c7e0ad587067d3b2efb4c4ee53d2191eaf0a"
SRC_URI = "git://github.com/i2som/Quectel-CM.git;protocol=git;branch=${SRCBRANCH}"

S = "${WORKDIR}/git"

inherit pkgconfig

export CFLAGS += "`pkg-config --cflags alsa`"
export LDLIBS += "`pkg-config --libs alsa`"

do_configure[noexec] = "1"

do_compile() {
	oe_runmake
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 quectel-CM ${D}${bindir}
}
