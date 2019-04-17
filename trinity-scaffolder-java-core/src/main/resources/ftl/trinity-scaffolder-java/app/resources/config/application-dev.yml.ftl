# CREATE SCHEMA `${ projectDescription.context }-dev`;
# CREATE USER '${ projectDescription.context }-dev'@'%' IDENTIFIED BY '${ projectDescription.context }-dev';
# GRANT ALL ON *.* TO '${ projectDescription.context }-dev'@'%';

spring-config:
  activemq:
    broker-url: tcp://localhost:61616
    user: admin
    password: admin
    in-memory: false
    pool:
      enabled: true
      max-connections: 10
  datasource:
    url: jdbc:mysql://localhost:3306/${ projectDescription.context }-dev?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&characterEncoding=utf8
    driver-class-name: com.mysql.cj.jdbc.Driver
    username: ${ projectDescription.context }-dev
    password: ${ projectDescription.context }-dev
  jpa:
    hibernate.ddl-auto: validate
    properties:
      hibernate:
        dialect: org.hibernate.dialect.MySQLDialect
        jdbc:
          time_zone: UTC
