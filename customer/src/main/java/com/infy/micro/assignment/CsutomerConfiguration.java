package com.infy.micro.assignment;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CsutomerConfiguration {
	
	 @LoadBalanced
	 @Bean
	  RestTemplate restTemplate(){
	    return new RestTemplate();
	  }

}
