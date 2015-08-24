package com.seedingmicroservice.web;


import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.seedingmicroservice.Application;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
@WebIntegrationTest(randomPort = true)
//@DirtiesContext
public class GreetingEndpointTest {

	@Value("${local.server.port}")
	private Integer serverPort;

	@Value("${greeting}")
	private String greetingMessage;

	@Before
	public void setupRestAssured() {
		RestAssured.port = serverPort;
	}

	@Test
	public void greetingEndpointShouldReturnHelloWorld(){
		//@formatter:on
		given()
		.when()
			.get("/greeting")
		.then()
			.statusCode(HttpStatus.SC_OK)
			.contentType(ContentType.JSON)
			.body("message", equalTo("Hello "+ greetingMessage));
		//@formatter:off
	}

}
