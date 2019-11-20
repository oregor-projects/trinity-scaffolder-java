# ==================================================================================================
# SPRING BOOT CONFIGURATION
# ==================================================================================================

# CREATE SCHEMA `${ projectDescription.context }-dev`;
# CREATE USER '${ projectDescription.context }-dev'@'%' IDENTIFIED BY '${ projectDescription.context }-dev';
# GRANT ALL ON *.* TO '${ projectDescription.context }-dev'@'%';

server-config:
  port: 8080

spring-config:
  datasource:
    url: jdbc:mysql://localhost:3306/${ projectDescription.context }-dev?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&characterEncoding=utf8
    driver-class-name: com.mysql.cj.jdbc.Driver
    username: ${ projectDescription.context }-dev
    password: ${ projectDescription.context }-dev
  flyway:
    placeholders:
      sql-safe-updates-off: SET SQL_SAFE_UPDATES=0;
      sql-safe-updates-on: SET SQL_SAFE_UPDATES=1;
      max-statement-time: SET STATEMENT max_statement_time=0 FOR
  jpa:
    hibernate.ddl-auto: validate
    properties:
      hibernate:
        dialect: org.hibernate.dialect.MySQLDialect
        jdbc:
          time_zone: UTC

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
