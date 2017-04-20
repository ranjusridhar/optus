# optus
Test from Optus

Question 1 :

optus.war is a deployable war file. Java 1.8 and Tomcat 7.0 are essential to deploy this. Please install them if not already present. 
Once installed, place this war file inside the Tomcat installation directory’s “webapps” folder. Also ensure that your system or the 
Tomcat server is pointing to the updated 1.8 Java. The last step is to restart your Tomcat server. This can be done on the command prompt 
by running the following :
1.	If Tomcat is setup as Windows service
<Tomcat Root>/bin>Tomcat7.exe start
2.	If downloaded binaries as .zip
<Tomcat Root>/bin>catalina.bat start
3.	On Linux
<Tomcat Root>/bin>./catalina.sh start

Now, you can use a REST client like Postman to retrieve truncated string information. 
For instance, http://localhost:8080/optus/subscribe returns the truncated string.

Since the input string comes from the getOrderDetails method, I gave only a single string to check. Although I tested it with various conditions
and the following are the inputs and outputs :
>>>		System.out.println(truncate( "123456789012345678901234567890" , 24));
    12 ... (truncated) ... 0
>>>		System.out.println(truncate( "1234567890" , 5));
    1234567890
>>>		System.out.println(truncate( "123456789012345678901234567890" , 31));
    123456789012345678901234567890
>>>		System.out.println(truncate( "123456789012345678901234567890" , 5));
    1 ... (truncated) ... 0
>>>		System.out.println(truncate( "123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890" , 100));
    1234567890123456789012345678901234567890 ... (truncated) ... 234567890123456789012345678901234567890
    
Question 2 :

replaceTokens.sh file contains the shell script to take 3 parameters - input.html test.properties output.html, and find all placeholders in input.html
which are contained within "[[ ]]" and replace them with their values from the properties file and see the replaced file in the output.html

To run this, the following command is used :
sh replaceTokens.sh index.html test.properties output.html
