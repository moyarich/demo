# Hotel


## Database:

 1. Firebase
	  https://firebase.google.com
	  https://firebase.google.com/docs/database/android/read-and-write
 2. MongoDB
 3. Fake data - a List data structure


## Firebase server admin

https://firebase.google.com/docs/admin/setup

## Add Firebase to your app

>To use the Firebase Admin SDKs, you'll need a Firebase project, a service account to communicate with the Firebase service, >and a configuration file with your service account's credentials. 

>If you don't already have a Firebase project, add one in the Firebase console[https://console.firebase.google.com/]. 
>

**rename the JSON File to "service_account.json"**

```sh
src\main\resources
```

In the sources folder, add the resource file:  src/main/resources/service_account.json


![firebase project settings](fireabase_project_setting.png)



## Create the **application.properties file**

Spring Boot gives you defaults on all things, the default in database is H2, so when you want to change this and use any other database you must define the connection attributes in the application.properties file.

In the sources folder, you create a resource file src/main/resources/application.properties

```sh
#Firebase configuration
rs.firebase.database.url=https://group-project.firebaseio.com
rs.firebase.config.path=service_account.json

# Mongo database URI. Cannot be set with host, port and credentials.
# 

spring.data.mongodb.host=localhost 
spring.data.mongodb.port=27017   
spring.data.mongodb.database=hotelreservation
spring.data.mongodb.username=hoteladmin
spring.data.mongodb.password=sdr$%3w43@123
```


##Rest API testing tool
https://www.getpostman.com/


REST API Examples

INSERT: **POST** method
url:  localhost:8080/guests 
Body - raw - JSON(application/json)

```javascript
{
    "name": "kim",
    "email": "wedrt@example.com"
}
```

```javascript
{
"name": "moya",
"email": "adi@example.com"
}
```
![postMan Insert Data](postman_insert_data.png)

SELECT by id: **GET** method
url:  localhost:8080/guests/id/5cbd4d118f10f904687a4b2d

DELETE by id: **DELETE** method
url:  localhost:8080/guests/id/5cbd4d118f10f904687a4b2d


UPDATE: **PUT** method
url:  localhost:8080/guests 
Body - raw - JSON(application/json)

```javascript
{
    "id": "5cbd4d118f10f904687a4b2d",
    "name": "kim white",
    "email": "twiceto@example.com"
}
```







## How to make contributions?
This is a group project, sorry you cannot contrubute unless you are a prt of the group


