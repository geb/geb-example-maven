#!/usr/bin/env bash

export WORKING_DIRECTORY=`pwd`
export HOME_DIRECTORY=`echo ~`
docker run -v ${WORKING_DIRECTORY}:${WORKING_DIRECTORY} -v ${HOME_DIRECTORY}/.m2:/.m2 -w ${WORKING_DIRECTORY} gebish/ci:v7 /bin/bash -c "Xvfb :99 -screen 1 1280x1024x16 -nolisten tcp -fbdir /var/run > /dev/null 2>&1 & export DISPLAY=:99 ; MAVEN_USER_HOME=/.m2 ./mvnw -Dmaven.repo.local=/.m2/repository test"