package com.seedingmicroservice.web;


import com.seedingmicroservice.Application;
import com.seedingmicroservice.ExternalConfiguration;
import com.seedingmicroservice.service.Greeting;
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
