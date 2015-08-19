package com.seedingmicroservice.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
	private static final Logger logger = LogManager.getLogger();

	private String greetingMessage;

	@Autowired
	public GreetingService(@Value("${greeting}") String greetingMessage) {
		this.greetingMessage = greetingMessage;
	}

	public Greeting greeting(){
		logger.debug("GreetingService is saying 'Hello' to %s", greetingMessage);
		Greeting greeting = new Greeting();
		greeting.setMessage("Hello " + greetingMessage);
		return greeting;
	}

}
