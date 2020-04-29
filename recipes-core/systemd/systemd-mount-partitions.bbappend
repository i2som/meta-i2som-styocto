FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI_append = " \
	file://mount-partitions.sh \
	"
