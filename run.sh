#!/usr/bin/env bash


all_java_files() {
    find . -name '*.java'
}


fatal() {
    local error_msg=$1
    echo >/dev/stderr "ERROR: $error_msg"
    exit 1
}


main() {
    local out_dir=$1

    if [ -z "$out_dir" ]
    then
        out_dir="./classes"
    fi

    rm -rf $out_dir
    mkdir -p $out_dir
    all_java_files | xargs javac -d $out_dir

    if [ $? != 0 ]
    then
        fatal "Couldn't compile files"
    fi

    local jar_name=mainproduct.jar
    jar cfm $jar_name ./META-INF/MANIFEST.MF -C $out_dir .
}


main $1
