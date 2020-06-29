package org.restassured;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC02_POST_Request {

	@Test
	void registrationCheck() {

		// Specify base URI
		RestAssured.baseURI = "https://reqres.in/api";

		// Request object
		RequestSpecification httpRequest = RestAssured.given();

		// Request paylaod sending along with post request
		JSONObject requestPara = new JSONObject();

		requestPara.put("email", "eve.holt@reqres.in");
		
		httpRequest.header("Content-Type", "application/json");

		httpRequest.body(requestPara.toJSONString());

		// Response object
		Response response = httpRequest.request(Method.POST, "/register");

		// print response in console window

		String responseBody = response.getBody().asString();
		System.out.println("Response Body is:" + responseBody);

		// status code validation
		int statusCode = response.getStatusCode();
		System.out.println("Status code is: " + statusCode);
		Assert.assertEquals(statusCode, 400);
		

	}

}
