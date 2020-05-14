<settings xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xmlns="http://maven.apache.org/SETTINGS/1.0.0"
          xsi:schemalocation="http://maven.apache.org/SETTINGS/1.0.0
                      http://maven.apache.org/xsd/settings-1.0.0.xsd">
  <servers>
    <server>
      <id>${ projectDescription.distributionProfile }</id>
      <#noparse>
      <username>${env.SONATYPE_USERNAME}</username>
      <password>${env.SONATYPE_PASSWORD}</password>
      </#noparse>
    </server>
  </servers>

  <profiles>
    <profile>
      <id>${ projectDescription.distributionProfile }</id>
      <activation>
        <activeByDefault>true</activeByDefault>
      </activation>
      <properties>
        <#noparse>
        <gpg.passphrase>${env.GPG_PASSPHRASE}</gpg.passphrase>
        </#noparse>
      </properties>
    </profile>
  </profiles>
</settings>
