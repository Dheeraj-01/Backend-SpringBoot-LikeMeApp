# Backend-SpringBoot-LikeMeApp

[![Java CI](https://github.com/andrei-punko/articles-backend-app/actions/workflows/maven.yml/badge.svg)](https://github.com/andrei-punko/articles-backend-app/actions/workflows/maven.yml)

This should be purely a REST endpoints backend application with Swagger UI.

_Build tool_: Maven

_DB_: MYSQL

_Source Control:_ Git Hub (public)

_Application name:_ Backend SpringBoot LikeMeApp

Application must be implemented using Spring Data (JPA/Hibernate) layer for communication with DB.

SQL queries should not be used, JPA Repositories and Entities should be used instead.

Application should have authentication.

## Features

- User registration and authentication
- User profile management
- Creating and editing posts
- Like and comment functionality
- Friend requests and acceptance
- News feed displaying posts from friends
- Search functionality to find posts and users 
- Apply role-based security restrictions using basic authorization (encrypted credentials stored in DB): two roles - ADMIN and USER, and USER has only read permissions
- Notifications for new friend requests, likes, and comments - TODO


## Swagger UI
<img width="1339" alt="Screenshot 2023-07-05 at 11 14 43 PM" src="https://github.com/Dheeraj-01/Backend-SpringBoot-LikeMeApp/assets/54698983/7907ac4a-19ac-47b0-b44a-45bdf3a29e11">


## Prerequisites
- Maven 3
- JDK 11

## Build instructions

#### Build application:
    mvn clean install

#### Build Docker image with application inside:
    docker build -t likemeapi .

## How to start application

#### Start application using Docker container:
    docker-compose up


#### Start application using Maven (via production DB):
    mvn spring-boot:run -Dspring-boot.run.arguments=--spring.profiles.active=prod

Or next way, using `dev` spring profile (change Active profile to **dev**):

    mvn spring-boot:run -Dspring-boot.run.arguments=--spring.profiles.active=dev

#### Swagger URL:
    http://localhost:8080/swagger-ui/index.html


#### Create User:
    curl --location 'http://localhost:8080/api/v1/auth/register' \
    --header 'Content-Type: application/json' \
    --header 'Cookie: JSESSIONID=A82DCD2F3646996E0C8BC8DA80975294' \
    --data-raw '{
    "about": "Hi I'\''m Testing Application",
    "email": "test@gmail.com",
    "imageLink": "https://ssl.gstatic.com/ui/v1/icons/mail/rfr/logo_gmail_lockup_default_2x_r5.png",
    "name": "tester",
    "password": "test"
    }'

#### Login User:
    curl -X POST "http://localhost:8080/api/v1/auth/login" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"password\": \"test\", \"username\": \"test@gmail.com\"}"

#### Get Current Login User:
    http://localhost:8080/api/v1/auth/current-user

#### Create Category:
    curl -X POST "http://localhost:8080/api/v1/categories/" -H "accept: */*" -H "Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmNvbSIsImV4cCI6MTY4ODYwMjA2MCwiaWF0IjoxNjg4NTg0MDYwfQ.7Ped4lQms46i3pUBTbL8mcOqzeWYmvJ7OrdvC8aeBcc1GRDXcOtGvuVhxldlKwYreFoeZLmdxC6Fu_-0YqsYHA" -H "Content-Type: application/json" -d "{ \"categoryDescription\": \"Sports Content is here\", \"categoryTitle\": \"Sports\"}"

#### Get Category:
    curl -X GET "http://localhost:8080/api/v1/categories/" -H "accept: */*" -H "Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmNvbSIsImV4cCI6MTY4ODYwMjA2MCwiaWF0IjoxNjg4NTg0MDYwfQ.7Ped4lQms46i3pUBTbL8mcOqzeWYmvJ7OrdvC8aeBcc1GRDXcOtGvuVhxldlKwYreFoeZLmdxC6Fu_-0YqsYHA"

#### Add Friend:
    curl -X GET "http://localhost:8080/api/v1/friend/9/add" -H "accept: */*" -H "Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmNvbSIsImV4cCI6MTY4ODYwMjA2MCwiaWF0IjoxNjg4NTg0MDYwfQ.7Ped4lQms46i3pUBTbL8mcOqzeWYmvJ7OrdvC8aeBcc1GRDXcOtGvuVhxldlKwYreFoeZLmdxC6Fu_-0YqsYHA"

#### Get Profile:
    curl -X GET "http://localhost:8080/api/v1/profile/9" -H "accept: */*" -H "Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmNvbSIsImV4cCI6MTY4ODYwMjA2MCwiaWF0IjoxNjg4NTg0MDYwfQ.7Ped4lQms46i3pUBTbL8mcOqzeWYmvJ7OrdvC8aeBcc1GRDXcOtGvuVhxldlKwYreFoeZLmdxC6Fu_-0YqsYHA"

#### Create Post:
    curl -X POST "http://localhost:8080/api/v1/user/14/category/4/posts" -H "accept: */*" -H "Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmNvbSIsImV4cCI6MTY4ODYwMjA2MCwiaWF0IjoxNjg4NTg0MDYwfQ.7Ped4lQms46i3pUBTbL8mcOqzeWYmvJ7OrdvC8aeBcc1GRDXcOtGvuVhxldlKwYreFoeZLmdxC6Fu_-0YqsYHA" -H "Content-Type: application/json" -d "{\"title\": \"Test Spring Boot Application\",\"content\": \"Random Content here\",\"imageName\": \"imageLinkHere\"}"

#### Get All Posts:
    curl -X GET "http://localhost:8080/api/v1/posts?pageNumber=0&pageSize=10&sortBy=postId&sortDir=asc" -H "accept: */*" -H "Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmNvbSIsImV4cCI6MTY4ODYwMjA2MCwiaWF0IjoxNjg4NTg0MDYwfQ.7Ped4lQms46i3pUBTbL8mcOqzeWYmvJ7OrdvC8aeBcc1GRDXcOtGvuVhxldlKwYreFoeZLmdxC6Fu_-0YqsYHA"

#### Search Posts:
    curl -X GET "http://localhost:8080/api/v1/posts/search/test" -H "accept: */*" -H "Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmNvbSIsImV4cCI6MTY4ODYwMjA2MCwiaWF0IjoxNjg4NTg0MDYwfQ.7Ped4lQms46i3pUBTbL8mcOqzeWYmvJ7OrdvC8aeBcc1GRDXcOtGvuVhxldlKwYreFoeZLmdxC6Fu_-0YqsYHA"

#### Save Post By User:
    curl -X GET "http://localhost:8080/api/v1/posts/5/save" -H "accept: */*" -H "Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmNvbSIsImV4cCI6MTY4ODYwMjA2MCwiaWF0IjoxNjg4NTg0MDYwfQ.7Ped4lQms46i3pUBTbL8mcOqzeWYmvJ7OrdvC8aeBcc1GRDXcOtGvuVhxldlKwYreFoeZLmdxC6Fu_-0YqsYHA"

#### Comment Post:
    curl --location 'http://localhost:8080/api/v1/post/5/comments' \
    --header 'accept: */*' \
    --header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmNvbSIsImV4cCI6MTY4ODYwMjA2MCwiaWF0IjoxNjg4NTg0MDYwfQ.7Ped4lQms46i3pUBTbL8mcOqzeWYmvJ7OrdvC8aeBcc1GRDXcOtGvuVhxldlKwYreFoeZLmdxC6Fu_-0YqsYHA' \
    --header 'Content-Type: application/json' \
    --header 'Cookie: JSESSIONID=A82DCD2F3646996E0C8BC8DA80975294' \
    --data '{
    "content": "Love this"
    }'