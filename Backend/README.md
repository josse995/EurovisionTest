# Backend
Backend is made with Spring Boot and Spring JPA.

The database is MariaDB running in a docker.
## Steps to run backend and DB

### Backend

1.- Open the project on IntelliJ and run BackendApplication -> main

### Docker
1.- From backend folder, execute the following command:
```
docker-compose up -d
```
*Argument -d is for running the container in the background

1.2.- For logging to the DB, execute the following command:
```
mysql -h 127.0.0.1 -uadmin -p
```
*The password is on the Interview Exercise PDF

