package com.paradigmadigital.restTest;

import static org.junit.Assert.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RestGetTest {
	
	Response response;
	JsonPath jsonPath;
	Headers headers;

	@Before
	public void setUp() throws Exception {
		RestAssured.baseURI = "http://localhost:8080"; 
		
		response=
			given()
				.request().headers("Content-Type", "application/Json")
			.when()
				.get("/jsonpath")
			.then()
				.assertThat()
					.statusCode(200)
				.extract().response();
		
		jsonPath = response.jsonPath();

		
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
