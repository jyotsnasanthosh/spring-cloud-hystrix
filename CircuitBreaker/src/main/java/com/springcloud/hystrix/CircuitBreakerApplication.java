package com.springcloud.hystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@SpringBootApplication
@RestController
@EnableCircuitBreaker
public class CircuitBreakerApplication {

	@Autowired
	RestTemplate restTemplate;
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(CircuitBreakerApplication.class, args);
	}
	
	@RequestMapping(value="/circuitBreaker", method=RequestMethod.GET)
	@HystrixCommand(fallbackMethod="fallbackMethod")
	public String ciruitBreaker() {
		return this.restTemplate.getForObject("http://localhost:8090/getMessage", String.class);
	}
	
	public String fallbackMethod() {
		return "This is the fallback method executing";
	}
}
