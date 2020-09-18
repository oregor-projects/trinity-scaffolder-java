#!/usr/bin/env bash

# https://github.com/springdoc/springdoc-openapi-maven-plugin

####################################################################################################
# We should not need the docker compose up for this operation. TODO FIX
####################################################################################################
cd .dev
./docker-start.sh
cd ..

####################################################################################################
# Unfortunately the following does not work!
# The maven plugin for openapi generation accepts only one configuration at the time.
####################################################################################################
#./mvnw clean verify -Dspring.application.admin.enabled=true -Popenapi-all-generated,openapi-user-generated,openapi-admin-generated

####################################################################################################
# So, at least for now, we have to repeat the verification process three times
####################################################################################################
#./mvnw clean verify -Dspring.application.admin.enabled=true -Popenapi-all-generated
./mvnw clean verify -Dspring.application.admin.enabled=true -Popenapi-user-generated
./mvnw clean verify -Dspring.application.admin.enabled=true -Popenapi-admin-generated
