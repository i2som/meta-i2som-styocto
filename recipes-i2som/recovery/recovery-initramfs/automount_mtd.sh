#!/bin/sh
#
# Copyright (c) 2017 i2SOM Team.
#

UPDATE_MOUNTPOINT="/mnt/update"
PARTITION_NAME="update"

# This will detect if the block device has a update partition
is_update_device() {
	grep -qs update /proc/mtd
}

# This will verify that the requested partition is the update partition
is_update_partition() {
	grep -qs "^${MDEV}:.*\<update\>.*" /proc/mtd
}

if is_update_device; then
	if is_update_partition; then
		# Attach and get UBI device number
		dev_number="$(ubiattach -p /dev/${MDEV} 2>/dev/null | sed -ne 's,.*device number \([0-9]\).*,\1,g;T;p' 2>/dev/null)"
		# Check if volume exists.
		if ubinfo "/dev/ubi${dev_number}" -N "${PARTITION_NAME}" >/dev/null 2>&1; then
			if mkdir -p ${UPDATE_MOUNTPOINT} && ! mountpoint -q ${UPDATE_MOUNTPOINT}; then
				# Mount the volume.
				if ! mount -t ubifs "ubi${dev_number}:${PARTITION_NAME}" "${UPDATE_MOUNTPOINT}"; then
					echo "ERROR: Could not mount '${PARTITION_NAME}' partition"
					rmdir --ignore-fail-on-non-empty ${UPDATE_MOUNTPOINT}
				fi
			fi
		else
			echo "ERROR: Could not mount '${PARTITION_NAME}' partition, volume not found"
			ubidetach -p "/dev/${MDEV}" >/dev/null 2>&1
			rmdir --ignore-fail-on-non-empty ${UPDATE_MOUNTPOINT}
		fi
	fi
	# If it's 'update' device but not partition, just exit
	exit 0
fi
