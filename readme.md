https://www.baeldung.com/spring-boot-soap-web-service

https://github.com/eugenp/tutorials/blob/master/spring-soap/src/main/java/com/baeldung/springsoap/CountryRepository.java


` cmd /c 'curl --header "content-type: text/xml" -d @request.xml http://localhost:8080/ws  | xmllint --format -' `



### Chrome extension: `Wizdler`
 
1. ` http://localhost:8080/ws/countries.wsdl `
2. Click on the [Wizdler] icon
3. Click on the name of the method


[@Endpoint]         – registers the class with Spring WS as a Web Service Endpoint
[@PayloadRoot]      – defines the handler method according to the namespace and localPart attributes
[@ResponsePayload]  – indicates that this method returns a value to be mapped to the response payload
[@RequestPayload]   – indicates that this method accepts a parameter to be mapped from the incoming request
[@EnableWs]         – enables SOAP Web Service features in this Spring Boot application.