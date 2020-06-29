#!/bin/bash

function compilejavafiles() {

 javac -d ./classes/ -cp ./classes/ $1
 
 echo "Compile file successfully"
}

for Javafiles in `find . -type f -name "*.java"`
	do
	echo $Javafiles
	compilejavafiles $Javafiles
	done
