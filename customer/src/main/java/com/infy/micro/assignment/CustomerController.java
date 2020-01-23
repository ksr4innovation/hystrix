package com.infy.micro.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
public class CustomerController {

	
	@Autowired
	  RestTemplate restTemplate;

	  @RequestMapping("/hi")
	  
	  public String hi() {
	    String greeting = this.restTemplate.getForObject("http://localhost:8082/getCount", String.class);
	   return greeting;
	  }
	  
	  @RequestMapping("/ribbontest")
	  @HystrixCommand(commandKey="ribbontestCommandKey",
		fallbackMethod="ribbontestFallBackMethod",
	commandProperties= {
	@HystrixProperty(name="circuitBreaker.requestVolumeThreshold" ,value="3"),
  @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000"),

	})
	  public String ribbontest() {
	    String greeting = this.restTemplate.getForObject("http://ORDER/getCount", String.class);
	   return greeting;
	  }
	  
	  private String ribbontestFallBackMethod() {
			
			System.out.println(" Fallback : ribbontestFallBackMethod    Entering ");
			
			
			
			return "ribbontestFallBackMethod Response return from curcuit break fallback";
		}
}
