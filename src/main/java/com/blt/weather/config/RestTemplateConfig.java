package com.blt.weather.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author fatih
 */
@Configuration
public class RestTemplateConfig {
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
