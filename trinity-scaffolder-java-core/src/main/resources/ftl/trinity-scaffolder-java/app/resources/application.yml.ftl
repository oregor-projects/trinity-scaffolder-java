# ==================================================================================================
# SPRING BOOT CONFIGURATION
# ==================================================================================================

<#noparse>
server:
  port: ${server-config.port}
  servlet:
    context-path: /api

spring:
  datasource:
    url: ${spring-config.datasource.url}
    driver-class-name: ${spring-config.datasource.driver-class-name}
    username: ${spring-config.datasource.username}
    password: ${spring-config.datasource.password}
  flyway:
    baseline-on-migrate: true
    check-location: false
    out-of-order: true
  jpa:
    hibernate.ddl-auto: validate
    properties:
      hibernate:
        show_sql: false
        format_sql: true
        dialect: ${spring-config.jpa.properties.hibernate.dialect}
        jdbc:
          time_zone: UTC
  profiles:
    active: native

management:
  endpoints:
    web:
      exposure:
        include: health,info,metrics
</#noparse>

# ==================================================================================================
# CONTEXT CONFIGURATION
# ==================================================================================================

context:
<#if projectDescription.contextDescriptions?size gt 1>
  <#list projectDescription.contextDescriptions as contextDescription>
  ${ contextDescription.contextName }:
    api-client:
      batch-process:
        subscriber: <#noparse>${</#noparse>context-config.${ contextDescription.contextName }.api-client.batch-process.subscriber}
        publisher: <#noparse>${</#noparse>context-config.${ contextDescription.contextName }.api-client.batch-process.publisher}
      domain-message:
        subscriber: <#noparse>${</#noparse>context-config.${ contextDescription.contextName }.api-client.domain-message.subscriber}
        publisher: <#noparse>${</#noparse>context-config.${ contextDescription.contextName }.api-client.domain-message.publisher}
    domain-detail:
      domain-message:
        publisher: <#noparse>${</#noparse>context-config.${ contextDescription.contextName }.domain-detail.domain-message.publisher}
  </#list>
<#else>
  ${ projectDescription.context }:
    api-client:
      batch-process:
        subscriber: <#noparse>${</#noparse>context-config.${ projectDescription.context }.api-client.batch-process.subscriber}
        publisher: <#noparse>${</#noparse>context-config.${ projectDescription.context }.api-client.batch-process.publisher}
      domain-message:
        subscriber: <#noparse>${</#noparse>context-config.${ projectDescription.context }.api-client.domain-message.subscriber}
        publisher: <#noparse>${</#noparse>context-config.${ projectDescription.context }.api-client.domain-message.publisher}
    domain-detail:
      domain-message:
        publisher: <#noparse>${</#noparse>context-config.${ projectDescription.context }.domain-detail.domain-message.publisher}
</#if>
