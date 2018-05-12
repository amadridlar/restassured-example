package com.paradigmadigital.restTest;

import static io.restassured.RestAssured.given;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RestPostTest {
	
	Response response;
	JsonPath jsonpath;
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
		RestAssured.baseURI ="http://localhost:8080";
		
		response =
			given()
				.request()
				.headers("Content-Type", "application/Json")
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
		Assert.assertEquals("Your post was posted ok :)", jsonpath.get("message"));
	}

}
