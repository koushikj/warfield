#!/bin/bash
#set -x

collect_log_info() {
  location=$1
  prefix=$2
  file_type=$2
  if [ "$prefix" = "journal" ]; then
    prefix="system"
  fi
  echo $file_type $(du -ach "$location"/$prefix*) >>$output_file
}

output_file=/tmp/mnt_log_file_info
>$output_file
for curArg in "${@:1}"; do
  IFS=':' read -ra ADDR <<<"$curArg"
  collect_log_info "${ADDR[0]}" "${ADDR[1]}"
done
cat $output_file
