package org.restassured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TC04_PUT_Request {
	
	@Test
	public void put() {
		Response put = RestAssured.given().delete("https://reqres.in/api/users/2");
		

        put.then().statusCode(204);
        
        System.out.println("Status Body is"+put.getBody().asString());
		
		
	}

}
