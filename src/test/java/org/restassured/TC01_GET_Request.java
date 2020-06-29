package org.restassured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC01_GET_Request {
	
	@Test
	void getWeatherDetails()
	{
	
	//Specify base URI
	RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
	
	//Request object
	RequestSpecification httpRequest=RestAssured.given();
	
	//Response object
	Response response=httpRequest.request(Method.GET,"/Coimbatore");
	
	//Print Response
	String responseBody = response.getBody().asString();
	System.out.println("Reponse Body is :" +responseBody);
	
	//Status code validation
	int statusCode = response.getStatusCode();
	System.out.println("Status code is :" +statusCode);
	Assert.assertEquals(statusCode, 200);
	
	//Status line verification
	String statusLine = response.statusLine();
	System.out.println("Status line is :" +statusLine);
	Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

	
	}

}
