package org.restassured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC03_GET_Request {

	 @Test
	 void googleMapTest()
	 {
	  
	  //Specify base URI
	  RestAssured.baseURI="https://samples.openweathermap.org";
	  
	  //Request object
	  RequestSpecification httpRequest=RestAssured.given();
	  
	  //Response object
	  Response response=httpRequest.request(Method.GET,"/data/2.5/weather?id=2172797&appid=7fe67bf08c80ded756e598d6f8fedaea");
	  
	  //print response in console window
	  String responseBody=response.getBody().asString();
	  System.out.println("Response Body is:" +responseBody);
	  
	  //validating headers
	  String contentType=response.header("Content-Type");// capture details of Content-Type header
	  System.out.println("Content Type is:"+contentType);
	  Assert.assertEquals(contentType, "application/xml; charset=UTF-8");
	  
	  String contentEncoding=response.header("Content-Encoding");// capture details of Content-Encoding  header
	  System.out.println("Content Encoding is:"+contentEncoding);
	  Assert.assertEquals(contentEncoding, "gzip");
	  
	 }
	 
}

