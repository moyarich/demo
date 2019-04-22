
---------------------------------------------------
---------------------------------------------------
mongodb as window service
1. create mongod.cfg file in "C:\MongoDB\config\mongod.cfg"
2. mongod.cfg file contains
```sh
	# mongod.conf

	# for documentation of all options, see:
	# http://docs.mongodb.org/manual/reference/configuration-options/

	# Where and how to store data.

	storage:
	  dbPath: C:\MongoDB\data\db
	  directoryPerDB: true
	  journal:
	    enabled: true



	# where to write logging data.
	systemLog:
	  destination: file
	  logAppend: true
	  path:  C:\MongoDB\log\mongod.log

	# network interfaces
	net:
	  port: 27017
	  bindIp: 127.0.0.1

```

3. Install as windows service : cmd prompt with admin rights

	a. create the empty folder - C:\MongoDB\data\db

	b. run command
```
		mongod --config "C:\MongoDB\config\mongod.cfg" --install
```


4. start MongoDB

	To start MongoDB Service run command:
```
	net start MongoDB
```

To stop MongoDB Service
```
	net stop MongoDB
```

To remove MongoDB Service
```
	mongod --remove
```


#--------------------------------------------------------------



open database in cmd , type:
```
mongo
```




#MongoDB Create Database
```
use hotelreservation
```

IF Access control is not enabled for the database. Read and write access to data and configuration is unrestricted.
Add an admin account by typing command below, dont forget to change password



# switched to db admin: 
```
	use admin
```
# create an admin user account :

```
	db.createUser(
	  {
	    user: "aministrator",
	    pwd: "a#@erW%%bc123",
	    roles: [ { role: "userAdminAnyDatabase", db: "admin" },
			{ role: "readWrite", db: "hotelreservation" }
	 	]
	  }
	)
```



# create a regular user account :
```
use hotelreservation
```

```
db.createUser(
  {
    user: "hoteladmin",
    pwd: "YERsdr$%3w43@123",
    roles: [ { role: "readWrite", db: "hotelreservation" } ]
  }
)

```


# update a regular user account :

```
db.updateUser("hoteladmin",
	{
    pwd: "YERsdr$%3w43@123",
    roles: [ { role: "readWrite", db: "hotelreservation" } ]
	}
)
```


# To authenticate and connect at same time
```
mongo -u "aministrator" -p "a#@erW%%bc123"  --authenticationDatabase "admin"
```

# To authenticate admin after connecting
-----------------------------------------
```
mongo
```
```
use admin
```

```
db.auth("aministrator", "a#@erW%%bc123" )

```
---------------------------------



#Create additional users as needed for your deployment on the database called "hotelreservation".


# To authenticate at the same time connecting
-----------------------------------------
```
mongo -u "hoteladmin" -p "YERsdr$%3w43@123" --authenticationDatabase "hotelreservation"

```
# To authenticate user after connecting
-----------------------------------------
```
use hotelreservation
```
```
db.auth("C", "YERsdr$%3w43@123" )
```
-------------------------------------------


