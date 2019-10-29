SUMMARY = "A console-only image that fully supports the target device \
hardware."

IMAGE_FEATURES += "splash"

LICENSE = "MIT"

inherit core-image

CORE_IMAGE_EXTRA_INSTALL += "openssh"
CORE_IMAGE_EXTRA_INSTALL += "sm1cpp"
CORE_IMAGE_EXTRA_INSTALL += "jsoncpp"

BBCLASSEXTEND += "native nativesdk"

