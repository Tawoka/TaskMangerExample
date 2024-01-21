# Task Manger

This project uses Spring Boot 3 with a servlet based web approach. It has been built with an postgres database run
inside a docker container.

## How to run this project

### Build the project

TBD

### Database

Inside the docker folder the *docker-compose.yml* can be used to quickly spin up a postgres database. This is not bound
to the spring project. It has to be done separately.

### Configuration

Inside *main/resources/application.properties*, update the URL to your docker container. If it is locally, use localhost.
If you have changed any value inside the docker-compose, adjust it here too (i.e. port, username or password).

### Starting the server

TBD

### Open the web page

TBD

## Decisions Made

### Standalone Docker

Despite spring enabling a docker database to be bound to the project, enabling the application to spin up the database,
when it is needed, the standalone approach remains here. Binding the database to this application could be a valid 
strategy. It was not chosen due to development infrastructure, where the databases have there own Docker-Environment on
an VM separated from the localhost, and a question of priority (time vs necessity).

### Simple JS UI

Since the project is focused on the Spring-Setup, UI was an afterthought. It is needed to showcase the features, and as
such speed and simplicity was chosen. TS and Python could have worked just as well, or more exotic UI technology like 
Dart or Kotlin.

### Bootstrapping Data

As this is a showcase project, it is important to always have some data available. To ensure that, we bootstrap two
example records, when the database is empty. This also simplified the test cases.

### Testing

There are several decisions regarding testing that are worth mentioning.

#### Blackbox Testing

We have one Unit-Test and one Integration-Test. The Unit-Test runs against the Service-Class. The service is our
functional contract. If the tests are successful, the contract is validated. Tests further down are redundant. The 
integration test adds the REST-Component. On top of the service, it ensures that the rest controller is implemented 
properly, and that the API works as intended.

#### Using an H2 Database

Since there isn't much logic happening in this project, the correct handling of data in the database is the main focus
of our tests. The test environment switches to an H2-Database for its increased performance, and to throw it away after
the tests completed. It removes the need to rollback data after the tests.

#### Limited Test Cases

The test cases in both tests aren't exhaustive. This was purely done due to time restrictions, and because testing isn't
the focus in this project.