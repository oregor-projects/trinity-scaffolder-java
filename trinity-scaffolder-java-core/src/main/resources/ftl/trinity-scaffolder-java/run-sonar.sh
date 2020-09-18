#!/usr/bin/env bash

# https://github.com/okorach/sonar-jacoco-lombok-example

#export SONAR_TOKEN=ecacf08bcfb9271609de3a13d5acb6daf6c4a7f5
#
#./mvnw clean org.jacoco:jacoco-maven-plugin:prepare-agent install org.jacoco:jacoco-maven-plugin:report sonar:sonar \
#  -Dsonar.projectKey=somg \
#  -Dsonar.host.url=http://localhost:9000 \
#  -Dsonar.login=$SONAR_TOKEN

./mvnw clean org.jacoco:jacoco-maven-plugin:prepare-agent install org.jacoco:jacoco-maven-plugin:report sonar:sonar -Dsonar.host.url=http://localhost:7000