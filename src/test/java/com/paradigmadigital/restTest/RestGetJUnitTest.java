package com.paradigmadigital.restTest;

import static io.restassured.RestAssured.given;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RestGetJUnitTest {
	
	Response response; 
	JsonPath jsonPath;
	Headers headers;
	String mockUrl = "http://localhost:8080";

	@Before
	public void jsonGetTest() throws Exception {
		RestAssured.baseURI = mockUrl; 
		
		response=
			given()
				.request()
				.headers("Content-Type", "application/json", "Accept", "application/json")
			.when()
				.get("/jsongetpath")
			.then()
				.extract().response();
		
		jsonPath = response.jsonPath();

		
	}
	
	@Test
	public void printJsonResponse () {
		String stringResponse;
		stringResponse = response.asString();
		System.out.println("==========ESTA ES LA RESPUESTA=========\n" + stringResponse);
		
	}

	
	@Test
	public void jsonFirstTest () {
		Assert.assertEquals("Johny", jsonPath.get("name"));
	}

	@Test
	public void jsonSecondTest() {
		Assert.assertEquals("Jacobsen", jsonPath.get("favourites.beer"));
	}
	
	@Test
	public void jsonHeadersTest () {
		headers = response.getHeaders();
		Assert.assertEquals("application/json", headers.getValue("Content-Type"));
	}

}
