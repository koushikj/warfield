#!/bin/bash
#
# Copyright (c) 2010 Cisco Systems, Inc.  This program contains
# proprietary and confidential information.  All rights reserved
# except as may be permitted by prior written consent.
#
# used by Debug Wizard to get the file size of each individual files
# along with the total file size of all the rotated files.

location=$1
prefix=$2

if [ "$prefix" = "journal" ]; then
        prefix="system"
fi
echo `du -ach $location/$prefix*`

