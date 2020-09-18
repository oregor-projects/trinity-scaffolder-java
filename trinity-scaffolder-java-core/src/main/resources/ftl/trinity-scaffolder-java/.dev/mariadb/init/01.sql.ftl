CREATE DATABASE IF NOT EXISTS `${ projectDescription.context }-dev`;
GRANT ALL ON `${ projectDescription.context }-dev`.* TO '${ projectDescription.context }-dev'@'%';

CREATE DATABASE IF NOT EXISTS `keycloak`;
GRANT ALL ON `keycloak`.* TO '${ projectDescription.context }-dev'@'%';
