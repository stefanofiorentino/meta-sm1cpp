#
# This file was derived from the 'Hello World!' example recipe in the
# Yocto Project Development Manual.
#

DESCRIPTION = "sm1/cpp - UDP lib to send data to sm1pro"
SECTION = "examples"
DEPENDS = ""
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

# Use local tarball
SRC_URI = "file://sm1cpp-${PV}.tar.gz"
S = "${WORKDIR}/sm1cpp-${PV}"

PACKAGES = "${PN} ${PN}-dev ${PN}-dbg ${PN}-staticdev"

COMPATIBLE_MACHINE = "nanopi-neo"

inherit cmake

FILES_${PN} += "${libdir}/*.a"
FILES_SOLIBSDEV = ""
INSANE_SKIP_${PN} += "staticdev"


do_install_append() {
        install -d ${D}${includedir}/udp/include
        install -m 0644 ${S}/udp/include/udpclient.h ${D}${includedir}/udp/include/udpclient.h
        install -d ${D}${includedir}/termios/include
        install -m 0644 ${S}/termios/include/termios.h ${D}${includedir}/termios/include/termios.h
}

PARALLEL_MAKE = ""

BBCLASSEXTEND += "native nativesdk"

