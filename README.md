# EClassroom

EClassroom is an e-learning platform that allows its users to watch video lectures and 
make a discussion threads that are releated to lecture's video timeline.

## Requirements

* In order to run this, you need to have [Docker](https://www.docker.com) on your machine.
* Make sure that port `8080`, `4200` and `5432` is available on your machine.
* You need to set environment variable `HOST_UPLOAD_DIR` on your machine in order
  to provide folder where uploaded videos and images will be stored.

## Database Schema
![schema](./gitimg/schema.png)

## Consuming the API

1. Execute shell script `run-backend.sh`. It will start the API.
2. Base url for API calls is `localhost:8080/eclassroom/api`.
3. Swagger documentation is available on `localhost:8080/eclassroom/swagger-ui/index.html`.

## Technology Stack

| *TECHNOLOGY* | _DESCRIPTION_ |
|------------|-------------|
| [Docker](https://www.docker.com/) | Platform that allows virtualization on application level by packaging pieces of software into containers |
| [Postgres](https://www.postgresql.org/) | Our Relational Database Management System of choice |
| [Jersey](https://eclipse-ee4j.github.io/jersey/) | Java framework for building REST API, based on JAX-RS |
| [Jetty](https://www.eclipse.org/jetty/) | HTTP Servlet Container for Java Web Applications |
| [Angular](https://angular.io/) | Framework for building rich UI web applications |
| [Nginx](https://www.nginx.com/) | HTTP server that serves the web client application |