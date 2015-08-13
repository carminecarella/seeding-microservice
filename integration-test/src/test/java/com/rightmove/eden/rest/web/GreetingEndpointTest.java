package com.rightmove.eden.rest.web;


import com.rightmove.eden.rest.Application;
import com.rightmove.eden.rest.ExternalConfiguration;
import com.rightmove.eden.rest.service.greeting.Greeting;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import static org.fest.assertions.api.Assertions.assertThat;

//TODO: change this test to use Rest Assured
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class, ExternalConfiguration.class})
@WebAppConfiguration
@IntegrationTest({"server.port:0"})
public class GreetingEndpointTest {

	@Value("${local.server.port}")
	private Integer serverPort;

	@Value("${greeting}")
	private String greetingMessage;

	private RestTemplate restTemplate = new TestRestTemplate();

	@Test
	public void greetingEndpointShouldReturnHelloWorld(){
		Greeting greeting = restTemplate.getForEntity(
				String.format("http://localhost:%d/greeting", serverPort),
				Greeting.class).getBody();
		assertThat(greeting.getMessage()).isEqualTo("Hello "+greetingMessage);
	}

}
