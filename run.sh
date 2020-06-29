#!/bin/bash


for javafiles in `find . -type f -name "*.class"`
	do
	echo $javafiles
	done
java -cp ./classes/ com/addressbook/$1
