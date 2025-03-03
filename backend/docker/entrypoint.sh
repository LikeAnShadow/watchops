#!/bin/bash

if [ -v DEVENV ]; then
    echo "Running in development mode"
    java -jar /app.jar
else    
    echo "Running in production mode"
    export SPRING_JPA_GENREATE_DDL=false
    export SPRING_JPA_HIBERNATE_DDL_AUTO=none
    export SPRING_JPA_SHOW_SQL=false
    export SPRING_JPA_PROPERTIES_HIBERNATE_FORMAT_SQL=false
    export SPRING_JPA_PROPERTIES_HIBERNATE_USE_SQL_COMMENTS=false
    java -jar /app.jar
fi
then
