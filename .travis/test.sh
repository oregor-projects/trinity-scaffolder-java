#!/usr/bin/env bash
if [ "$TRAVIS_BRANCH" = 'master' ] && [ "$TRAVIS_PULL_REQUEST" == 'false' ]; then
    ./mvnw clean org.jacoco:jacoco-maven-plugin:prepare-agent package sonar:sonar \
      -Dsonar.projectKey=oregor-projects_trinity-scaffolder-java \
      -Dsonar.organization=oregor-projects \
      -Dsonar.host.url=https://sonarcloud.io \
      -Dsonar.login=$SONAR_TOKEN
else
    ./mvnw test -B
fi
