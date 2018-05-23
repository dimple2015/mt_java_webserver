# mt_java_webserver
This is a file based simple multithreaded web server in java which uses the thread pooling capability. 
It supports POST, GET and DELETE methods against the /v1/file API.
Currently, it supports text/xml, text/plain/, application/json types of files.
For the Thread Pool, it sets a limit of 10 threads

Compiling
=====================
1. You will need Java 1.8 and Maven 3.3 to compile the project.
2. Download the project source code from GitHub repository (https://github.com/dimple2015/mt_java_webserver.git)

    $ git clone git@github.com:dimple2015/mt_java_webserver.git

This will create a folder "mt_java_webserver" containing the project source files. 

3. Go to the project root folder and run the following command:

    $  mvn clean compile assembly:single

4. This will create a "target" folder containing the application jar file: mt_java_webserver-0.0.1-SNAPSHOT-jar-with-dependencies.jar  

Usage
=============================
To start the web server,
java -jar target/mt_java_webserver-0.0.1-SNAPSHOT-jar-with-dependencies.jar <PORT_NUMBER>
Note: The parameter PORT_NUMBER is optional, default port is 4444

Example API usages via POSTMAN
1. POST /v1/file : http://localhost:4444/v1/file?filename=sample.xml&filepath=/tmp and select the file to be uploaded in the Request body.

2. GET /v1/file : http://localhost:4444/v1/file?filenamewithpath=/tmp/sample.xml

3. DELETE /v1/file: http://localhost:4444/v1/file?filenamewithpath=/tmp/sample.xml

To stop the Simple Web server, just press Ctrl+C on the command line.

