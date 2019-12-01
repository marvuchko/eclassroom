FROM maven:3.5-jdk-8-alpine as build
WORKDIR /app
COPY . /app
RUN mvn install

FROM jetty:9.4.18-alpine
COPY --from=build /app/target/*.war /var/lib/jetty/webapps/eclassroom.war