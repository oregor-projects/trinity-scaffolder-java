#!/usr/bin/env bash

# Stop the docker containers of compose
cd .dev
./docker-stop.sh
cd ..

./mvnw clean verify -PintegrationTests
