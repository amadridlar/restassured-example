package com.paradigmadigital.restTest;

import static io.restassured.RestAssured.given;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RestPostJUnitTest {
	
	Response response;
	JsonPath jsonpath;
	String mockUrl = "http://localhost:8080";
	String postString = "{\r\n" + 
		"	\"name\":\"Johny\",\r\n" + 
		"	\"lastName\":\"Reland\",\r\n" + 
		"	\"favourites\":{\r\n" + 
		"		\"beer\":\"Jacobsen\",\r\n" + 
		"		\"whiskey\":\"JohnCor\"\r\n" + 
		"	}\r\n" + 
		"}";

	@Before
	public void setUp() throws Exception {
		RestAssured.baseURI = mockUrl;
		
		response =
			given()
				.request()
				.headers("Content-Type", "application/json", "Accept", "application/json")
				.body(postString)
			.when()
				.post("/jsonpostpath")
			.then()
				.extract().response();
				
	}

	@Test
	public void jsonPostStatusTest() {
		Assert.assertEquals(200, response.getStatusCode());
	}
	
	@Test
	public void jsonPostBodyTest () {
		jsonpath = response.jsonPath();
		Assert.assertEquals("Your post was posted successfully :)", jsonpath.get("message"));
	}

}
