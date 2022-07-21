# EstacionaAqui

This is app was created to smooth the user on parking systems. The parking owner is able to register his parking lot and the user is able to make reservations on in.

The application is a Java Spring Boot rest API that connects to a PostgreSQL database.
It is a CRUD backend, using MVC architecture

It has 2 entities
  * Parking
  * Scheduling

It is hosted in a Heroku application.

The develop branch it is the local/test environment, while the master its the production env that is hosted on Heroku.

## To run the app

First you need to build the docker image, go to the root folder of the project and run:

`docker build -t estaciona-aqui:latest .`

then you can run the application using:

`docker run -p 8080:8080 estaciona-aqui`

the base url will be http://localhost:8080/
