FROM jboss/wildfly:10.1.0.Final

MAINTAINER Henrik Akesson <henrik.akesson@heig-vd.ch>

ADD ../../app/WildflyApp/target/WildflyApp-1.0-SNAPSHOT.war /opt/jboss/wildfly/standalone/deployments/
RUN /opt/jboss/wildfly/bin/add-user.sh admin admin --silent
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]