package com.paradigmadigital.restTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import io.restassured.RestAssured;

public class RestGetTest {
	
	String mockUrl = "http://localhost:8080";

	@Test
	public void jsonGetTest() throws Exception {
		RestAssured.baseURI = mockUrl; 
		
			given()
				.headers("Content-Type", "application/json", "Accept", "application/json")
				.request()
			.when()
				.get("/jsongetpath")
			.then()
				.assertThat()
					.statusCode(200)
					.header("Content-Type", equalTo("application/json"))
					.content("name", equalTo("Johny"))
					.content("favourites.beer", equalTo("Jacobsen"));
			
	}
}
