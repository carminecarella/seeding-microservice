package com.seedingmicroservice;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("test-application.properties")
public class ExternalConfiguration {
}
