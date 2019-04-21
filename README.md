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

**rename the JSON File to "service_account.json" and place file in the location below:**

```sh
src\main\resources
```
![firebase project settings](fireabase_project_setting.png)



src\main\resources\service_account.json"


Rest API testing tool
https://www.getpostman.com/


Example: insert a guest into database:

method: POST
url:  localhost:8080/guests 


Body - raw - JSON(application/json)


```javascript
{
"name": "moya",
"email": "adi@example.com"
}
```
![postMan Insert Data](postman_insert_data.png)




## How to make contributions?
This is a group project, sorry you cannot contrubute unless you are a prt of the group


