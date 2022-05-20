# Parking Management System

Simple Parking Management System where Cars can be parked in certain slots depending on the availability

## Features

- New Parking slots can be added
- A Car can be parked at a certain slot or it can be unparked from a certain slot
- Slot information can be retreived from either Car number or Slot number 
- Parking History can be retreived for a Car, Slot or for certain time interval

## Technologies Used

- Spring Boot
- Spring Data JPA
- H2 In-Memory Database

## Sample API Endpoints

- Signup

```
curl --location --request POST 'localhost:8080/userApi/v1/signup' \
--header 'Content-Type: application/json' \
--data-raw '{
    "username": "Username 4",
    "password": "Password 4"
}'
```

- Login

```
curl --location --request POST 'localhost:8080/userApi/v1/login' \
--header 'Content-Type: application/json' \
--data-raw '{
    "username": "Username 3",
    "password": "Password 3"
}'
```

#### Both the requests will respond with a JSON Web Token that has to be provided in every other request's header 

<br>

Project API

<b>Assumption</b>: The Username provided in any requests' params belongs to the same User whose JSON Web Token is being used

- Add new Project

```
curl --location --request POST 'localhost:8080/projectApi/v1/project/new?user=Username 3' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJVc2VybmFtZSAzIiwiZXhwIjoxNjUxODUyNjg0LCJpYXQiOjE2NTE4MTY2ODR9.-nyhq3cHRS5xqu6raMu9UdAn5FtjiyalKrVbXZxMMPE' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name" : "Project 6",
    "description" : "Project description 6",
    "visibility" : "PUBLIC",
    "user" : {
        "id" : 3,
        "username" : "Username 3",
        "password" : "Password 3"
    }
}'
```
- Remove Project by Id

```
curl --location --request DELETE 'localhost:8080/projectApi/v1/project/remove?projectId=5&user=Username 3' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJVc2VybmFtZSAzIiwiZXhwIjoxNjUxODUyNjg0LCJpYXQiOjE2NTE4MTY2ODR9.-nyhq3cHRS5xqu6raMu9UdAn5FtjiyalKrVbXZxMMPE'
```

- Modify Project

```
curl --location --request PUT 'localhost:8080/projectApi/v1/project/modify?user=Username 3' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJVc2VybmFtZSAzIiwiZXhwIjoxNjUxODUyNjg0LCJpYXQiOjE2NTE4MTY2ODR9.-nyhq3cHRS5xqu6raMu9UdAn5FtjiyalKrVbXZxMMPE' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id" : "5",
    "name" : "Project 5 - Modified",
    "description" : "Project description 5 - Modified",
    "visibility" : "PUBLIC",
    "user" : {
        "id" : 3,
        "username" : "Username 3",
        "password" : "Password 3"
    }
}'
```

- Get Project of Requested User

```
curl --location --request GET 'localhost:8080/projectApi/v1/projects/all?currentUser=Username 3&requestedUser=Username 3' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJVc2VybmFtZSAzIiwiZXhwIjoxNjUxODUyNjg0LCJpYXQiOjE2NTE4MTY2ODR9.-nyhq3cHRS5xqu6raMu9UdAn5FtjiyalKrVbXZxMMPE'
```

- Get Project by Id

```
curl --location --request GET 'localhost:8080/projectApi/v1/project?currentUser=Username 3&projectId=6' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJVc2VybmFtZSAzIiwiZXhwIjoxNjUxODUyNjg0LCJpYXQiOjE2NTE4MTY2ODR9.-nyhq3cHRS5xqu6raMu9UdAn5FtjiyalKrVbXZxMMPE'
```

- Get Public Projects of All Other Users

```
curl --location --request GET 'localhost:8080/projectApi/v1/other-projects/all?currentUser=Username 3' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJVc2VybmFtZSAzIiwiZXhwIjoxNjUxODUyNjg0LCJpYXQiOjE2NTE4MTY2ODR9.-nyhq3cHRS5xqu6raMu9UdAn5FtjiyalKrVbXZxMMPE' \
--data-raw ''
```
