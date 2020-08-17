# Deving Java Service in a Container with a Database

Building on the simple "Hello World" service in the master branch, this branch adds a mysql database. 

The database [k8s manifest file](templates/db.yaml) initializes a simple `Greetings` db.

The database is exposed to the host on `localhost:32463`

Run `skaffold dev` to start the web app and the database. Once the deployment has stabilized (might take ~1min) navigate to `http://localhost:8080/` and be greeted with a message! That is coming from your db! 
