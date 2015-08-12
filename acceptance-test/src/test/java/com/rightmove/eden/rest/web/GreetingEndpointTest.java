package com.rightmove.eden.rest.web;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

import static org.fest.assertions.api.Assertions.assertThat;

public class GreetingEndpointTest {

	private String serverHost;

	private String serverPort;

	private String path;

	@Before
	public void before() {
		serverHost = System.getProperty("target.host");
		serverPort = System.getProperty("target.port");
	}

	@Test
	@Ignore
	public void greetingEndpointShouldReturnHelloWorld(){
		path = "/greeting";
		Greeting greeting = getResponse();
		assertThat(greeting.getMessage()).startsWith("Hello");
	}

	private Greeting getResponse() {
		System.out.println("host: "+ serverHost);
		System.out.println("port: "+serverPort);
		URI uri = UriBuilder.fromUri("http://"+serverHost+":"+serverPort)
				.path(path)
				.build();
		return ClientBuilder.newClient()
				.target(uri)
				.request()
				.build("GET")
				.invoke()
				.readEntity(Greeting.class);
	}

}
