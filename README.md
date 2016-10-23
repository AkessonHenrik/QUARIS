# QUARIS

## A multi-tier application project by Henrik Akesson & Fabien Salathe

### Protected content
A page is made available only for registered and logged in visitors. That page is the **administration** page, where the databse content is shown and a user can create new ones.

### How to launch
Run the command `docker-compose up --build` in the main directory, "**QUARIS**", The one where docker-compose.yml is.

Once the docker image is up and running, go to the following address: [{localhost/192.168.99.100}:9090/QUARIS-1.0-SNAPSHOT](localhost:8080/QUARIS-1.0-SNAPSHOT)

### Wildfly Admin dashboard
Go to [{localhost/192.168.99.100}:9990}



### API documentation
Check it out here: https://akessonhenrik.github.io/QUARIS/api/

### PostMan tests info
To make the postman tests work ("**QUARIS.postman_collection.json**"), you may want to use postman environment variables.

Three are needed in that case, unless you want to manually inject them in every query:

**host** : address where the site is running (examples: **localhost** or **192.168.99.100**)

**port** : port where the webapp is accessible (using docker or without modifying the configuration: **9090**)

**base** : Name of the webapp (using docker or without modifying the configuration: **/QUARIS-1.0-SNAPSHOT**)
