# Getting Started

##Eclaim Processing System

### environment details
The solution uses Spring Boot to expose the REST services for the Eclaim system for XYZ compant

###    software dependencies (if any)
Maven and JDK (1.8).
All the dependencies get downloaded from the maven central repo while running the application.


############################ Launch application through Maven ########################
### instructions to launch/run the application
1. Unzip eclaim.zip. 
2. I have used the H2 in-memory database which will avoid anyone to set up the application-specific database
3. Some initial data will be populated for Configuration table through data.sql
4. build the application using maven command 'mvn clean install' (In this build source and JUnit will be compiled , no automation tests will be executed default)
5. Run the application as a Java application using click on runApplication.sh or open command prompt and execute runApplication.sh 
6. The swagger UI can be accessed at http://localhost:8080/swagger-ui.html to know the available endpoints and operations.






############################ Launch application through Docker ########################
### instructions to launch/run the application
1. Unzip eclaim.zip. 
2. I have used H2 in memory database which will avoid anyone to setup application specific database
3. build the application using maven command 'mvn clean install' (In this build source and junit will be compliled , no automation tests will be executed default)
4. Some initial data will be populated for Configuration table through data.sql
5. Docker file is configured- 
    1. create a docker build - 'docker build -t eclaim:1.0.1 .'
    2. verify image - 'docker images'
    3. run docker - 'docker run --name eclaim-container -p 8080:8080 eclaim:1.0.1'
    
6. The swagger UI can be accessed at http://localhost:8080/swagger-ui.html to know the available endpoints and operations.




### the supported OS/ browser combinations.
The application supports all major OS and browsers.