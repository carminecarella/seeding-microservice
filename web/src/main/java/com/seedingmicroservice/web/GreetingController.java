package com.seedingmicroservice.web;

import com.seedingmicroservice.service.Greeting;
import com.seedingmicroservice.service.GreetingService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	private static final Logger logger = LogManager.getLogger();

	@Autowired
	private GreetingService greetingService;

	@RequestMapping("greeting")
	public Greeting helloWorld(){
		logger.info("Saying hello to the world!");
		return greetingService.greeting();
	}

}
