FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " \
        file://Makefile \
        file://logo.png \
        file://image_header.h \
    "
