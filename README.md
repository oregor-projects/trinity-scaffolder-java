# trinity-scaffolder-java

[![Javadocs](http://javadoc.io/badge/com.oregor.trinity.scaffolder.java/trinity-scaffolder-java-core.svg?color=brightgreen)](http://javadoc.io/doc/com.oregor.trinity.scaffolder.java/trinity-scaffolder-java-core)
[![Build Status](https://travis-ci.org/oregor-projects/trinity-scaffolder-java.svg?branch=master)](https://travis-ci.org/oregor-projects/trinity-scaffolder-java)
[![Maven](https://img.shields.io/maven-central/v/com.oregor.trinity.scaffolder.java/trinity-scaffolder-java.svg?label=Maven)](https://search.maven.org/search?q=g:com.oregor.trinity.scaffolder.java)
[![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=oregor-projects_trinity-scaffolder-java&metric=alert_status)](https://sonarcloud.io/dashboard?id=oregor-projects_trinity-scaffolder-java)

Scaffolder for Java applications based on the Trinity Architecture.

To learn more about the Trinity Architecture go to: https://medium.com/oregor/the-trinity-architecture-c89ed5743c1e

To browse an existing scaffolded Java project go to: https://github.com/oregor-projects/trinity-demo-java


## Get started

### Download Binary

You can directly download the CLI from maven central:  

[https://search.maven.org/search?q=a:trinity-scaffolder-java-cli](https://search.maven.org/search?q=a:trinity-scaffolder-java-cli)

And then execute:

```bash
java -jar trinity-scaffolder-java-cli-{latest-version}.jar 
```

Make sure to replace the **{latest-version}** with the actual version. 
For example:

```bash
java -jar trinity-scaffolder-java-cli-0.0.6.jar 
```


### Build Binary

Alternatively, you can clone and build the master branch.

```bash
git clone https://github.com/oregor-projects/trinity-scaffolder-java.git
cd trinity-scaffolder-java
chmod +x mvnw
./mvnw package
java -jar trinity-scaffolder-java-cli/target/trinity-scaffolder-java-cli.jar 
```

And then execute:

```bash
java -jar trinity-scaffolder-java-cli/target/trinity-scaffolder-java-cli.jar 
```
