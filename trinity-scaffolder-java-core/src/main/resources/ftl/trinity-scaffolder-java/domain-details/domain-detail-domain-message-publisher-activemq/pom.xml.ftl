<?xml version="1.0" encoding="UTF-8"?>
<project xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns="http://maven.apache.org/POM/4.0.0"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <parent>
    <groupId>${ contextDescription.groupId }</groupId>
    <artifactId>${ contextDescription.modulePrefix }domain-details</artifactId>
    <version>${ projectDescription.version }</version>
  </parent>
  <modelVersion>4.0.0</modelVersion>

  <groupId>${ contextDescription.groupId }.${ contextDescription.modulePrefix }domain-details</groupId>
  <artifactId>${ contextDescription.modulePrefix }domain-detail-domain-message-publisher-activemq</artifactId>

  <dependencies>
    <!--CAMEL ACTIVEMQ STARTER-->
    <dependency>
      <groupId>org.apache.camel</groupId>
      <artifactId>camel-activemq-starter</artifactId>
    </dependency>

    <!--JAVA EE-->
    <dependency>
      <groupId>javax.xml.bind</groupId>
      <artifactId>jaxb-api</artifactId>
    </dependency>

    <!--TRINITY4J SHARED CAMEL-->
    <dependency>
      <groupId>com.oregor.trinity4j.trinity4j-shared</groupId>
      <artifactId>trinity4j-shared-camel</artifactId>
    </dependency>

    <!--TRINITY-->
    <dependency>
      <groupId>com.oregor.trinity4j.trinity4j-domain-details</groupId>
      <artifactId>trinity4j-domain-detail-domain-message-publisher</artifactId>
    </dependency>

    <!--DOMAIN-->
    <dependency>
      <groupId>${ contextDescription.groupId }</groupId>
      <artifactId>${ contextDescription.modulePrefix }domain</artifactId>
    </dependency>
  </dependencies>
</project>
