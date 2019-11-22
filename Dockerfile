FROM jetty:9.4.7
COPY /target/*.war /var/lib/jetty/webapps/api.war