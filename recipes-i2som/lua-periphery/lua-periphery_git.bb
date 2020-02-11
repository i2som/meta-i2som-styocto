SUMMARY = "Periphery device operation API for Lua language"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS = "lua"
SRCBRANCH = "master"
SRCREV = "d7df4d759c467edbbe1048a42c7f6d9ae39568aa"

SRC_URI = "gitsm://github.com/vsergeev/lua-periphery.git;protocol=git;branch=${SRCBRANCH}"

S = "${WORKDIR}/git"
luadir = "/lua/5.3"

do_install() {
    install -d ${D}${libdir}${luadir}
    install -m 755 periphery.so ${D}${libdir}${luadir}
}

FILES_${PN} = "${libdir}${luadir}/periphery.so"
