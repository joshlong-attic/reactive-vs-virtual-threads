#!/usr/bin/env bash

function test(){
    D=$1
    echo "gonna go into $D "
    cd $D
    ./mvnw spring-boot:run &
    PID=$!
    sleep 5
    hey -n 10000 http://localhost:8080 > ../${D}-results.txt
    echo "finished testing."
    pkill java
    cd ..

}

pkill java
test blocking
test reactive
