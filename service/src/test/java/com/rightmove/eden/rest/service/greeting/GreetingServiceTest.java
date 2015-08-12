package com.rightmove.eden.rest.service.greeting;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class GreetingServiceTest {

	@Test
	public void shouldReturnGreeting(){
		GreetingService greetingService = new GreetingService("World!");
		Greeting greeting = greetingService.greeting();
		assertThat(greeting.getMessage()).isEqualTo("Hello World!");
	}

}