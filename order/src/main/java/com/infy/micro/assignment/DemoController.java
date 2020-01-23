package com.infy.micro.assignment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	private int i =0;
	
	@GetMapping(value="/getCount")
	public String getCount() {
		
		System.out.print("  From getCount  ");
		
		return " GetCount "+i++;
	}

}
