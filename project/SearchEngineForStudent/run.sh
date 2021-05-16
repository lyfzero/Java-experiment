#!/bin/bash
cur_dir = $(SearchEngineForStudent)
echo $cur_dir

function compile() {
    searchengine = $cur_dir/src
    searchengine_src = $cur_dir/src
    searchengine_class = $cur_dir/class

    rm -rf $searchengine_src/sources.list
    find $searchengine_src -name "*.java" > $searchengine_src/sources.list
    cat $searchengine_src/sources.list

    rm -rf $searchengine_class
    mkdir $searchengine_class

    javac -d $searchengine_class -g -sourcepath $searchengine_src @$searchengine_src/sources.list

}
compile
exit 0

