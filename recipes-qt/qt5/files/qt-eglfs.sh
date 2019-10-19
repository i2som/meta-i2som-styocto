#!/bin/sh -

export QT_QPA_PLATFORM=eglfs
if [ -e /usr/share/qt5/cursor.json ];
then
	export QT_QPA_EGLFS_KMS_CONFIG=/usr/share/qt5/cursor.json
	export QT_QPA_EGLFS_ALWAYS_SET_MODE=1
	export QT_QPA_PLATFORM=eglfs
	export QT_QPA_EGLFS_INTEGRATION=eglfs_kms
	export TSLIB_CALIBFILE=/etc/pointercal
	export TSLIB_CONSOLEDEVICE=none
	export TSLIB_CONFFLLE=/etc/ts.conf
	export TSLIB_TSDEVICE=/dev/input/event1
	export TSLIB_TSEVENTTYPE=INPUT

	export QT_QPA_EGLFS_TSLIB=1
	export QT_QPA_EVDEV_MOUSE_PARAMETERS=
	export QT_QPA_EGLFS_KMS_CONFIG=/usr/share/qt5/cursor.json
	export QT_QPA_GENERIC_PLUGINS=tslib:/dev/input/event1,evdevmouse:/dev/input/event1
	export QT_QPA_EGLFS_DISABLE_INPUT=1
fi

