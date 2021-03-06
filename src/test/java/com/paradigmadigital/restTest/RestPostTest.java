package com.paradigmadigital.restTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RestPostTest {
	
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

	@Test
	public void jsonPostTest() throws Exception {
		RestAssured.baseURI = mockUrl;
		

			given()
				.request()
				.headers("Content-Type", "application/json", "Accept", "application/json")
				.body(postString)
			.when()
				.post("/jsonpostpath")
			.then()
				.assertThat()
					.statusCode(200)
					.contentType("application/Json")
					.content("message", equalTo("Your post was posted successfully :)"));
					
				
	}

}
