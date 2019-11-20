# ==================================================================================================
# SPRING BOOT CONFIGURATION
# ==================================================================================================

server-config:
  port: 8080

spring-config:
  datasource:
    url: jdbc:h2:mem:test;MODE=MySQL;DB_CLOSE_DELAY=-1;DATABASE_TO_UPPER=true;DB_CLOSE_ON_EXIT=FALSE;INIT=CREATE SCHEMA IF NOT EXISTS \"public\";
    driver-class-name: org.h2.Driver
    username: sa
    password:
  flyway:
    placeholders:
      sql-safe-updates-off: ''
      sql-safe-updates-on: ''
      max-statement-time: ''
  jpa:
    properties:
      hibernate:
        dialect: com.oregor.trinity4j.domain.hibernate.CustomH2Dialect

camel-config:
  component:
    activemq:
      broker-u-r-l: tcp://localhost:61616
      username: admin
      password: admin

# ==================================================================================================
# CONTEXT CONFIGURATION
# ==================================================================================================

context-config:
<#if projectDescription.contextDescriptions?size gt 1>
    <#list projectDescription.contextDescriptions as contextDescription>
  ${ contextDescription.contextName }:
    api-client:
      batch-process:
        subscriber: activemq:queue:${ contextDescription.contextName }.api-client.batch-process.subscriber
        publisher: activemq:topic:${ contextDescription.contextName }.api-client.batch-process.publisher
      domain-message:
        subscriber: activemq:queue:${ contextDescription.contextName }.api-client.domain-message.subscriber
        publisher: activemq:topic:${ contextDescription.contextName }.api-client.domain-message.publisher
        forwarder: activemq:topic:${ contextDescription.contextName }.api-client.domain-message.forwarder
    domain-detail:
      domain-message:
        publisher: activemq:topic:${ contextDescription.contextName }.domain-detail.domain-message.publisher
    </#list>
<#else>
  ${ projectDescription.context }:
    api-client:
      batch-process:
        subscriber: activemq:queue:${ projectDescription.context }.api-client.batch-process.subscriber
        publisher: activemq:topic:${ projectDescription.context }.api-client.batch-process.publisher
      domain-message:
        subscriber: activemq:queue:${ projectDescription.context }.api-client.domain-message.subscriber
        publisher: activemq:topic:${ projectDescription.context }.api-client.domain-message.publisher
        forwarder: activemq:topic:${ projectDescription.context }.api-client.domain-message.forwarder
    domain-detail:
      domain-message:
        publisher: activemq:topic:${ projectDescription.context }.domain-detail.domain-message.publisher
</#if>
