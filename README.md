REST API Weather Information
This is a wrapper API for the open-metro.com forecast API. 
The services are available after deploying this application.
The endpoint is localhost:8080/weather to get the current temperature of the region.
You need to pass to a parameter named ‘latitude’ and ‘longitude’
Example: localhost:8080/weather?latitude=45.444&longitude=-75.8803  
Expected output: {currentTemperature:-17.5} 
Installation & Run

There is a docker file available for docker the project.  Build the image file from the source and run the application. You do not need any database configuration. 

