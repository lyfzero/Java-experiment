#!/bin/bash
#
JAVA_HOME=/home/lyf/jdk/currentjdk
#
LIB_DIR=./lib
#
# TO_BE_TEST_CLASSPATH=/home/lyf/Desktop/Java-experiment/homework/ch11_13/p3
TO_BE_TEST_CLASSPATH=./betest
#
TEST_SUITE_CLASSPATH=./test
#
DEP_JAR=
for jarfile in $(find $LIB_DIR | grep '\.jar$')
do  if [ ! -n "$DEP_JAR" ];then
        DEP_JAR=$jarfile
    else
        DEP_JAR=$DEP_JAR:$jarfile
    fi
done
CLASSPATH=$CLASSPATH:$TO_BE_TEST_CLASSPATH:$TEST_SUITE_CLASSPATH:$DEP_JAR
export JAVA_HOME
export CLASSPATH
PATH=$JAVA_HOME/bin:$PATH
export PATH
java org.testng.TestNG testng.xml -d test-output