#!/bin/bash

DOCKER_IMAGE=markhobson/maven-chrome

docker pull $DOCKER_IMAGE
docker run -it -v "$PWD":/usr/src -w /usr/src $DOCKER_IMAGE mvn test "-Dbrowser=chrome" -X -s settings.xml -l log
