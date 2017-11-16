FROM docker-common.namics.com/namics_java/tomcat:8.5.23

ADD ./conf $CATALINA_HOME/conf
ADD maven/ $CATALINA_HOME/webapps/

EXPOSE 8009
EXPOSE 8080
EXPOSE 9080
EXPOSE 9443
CMD ["catalina.sh", "run"]

