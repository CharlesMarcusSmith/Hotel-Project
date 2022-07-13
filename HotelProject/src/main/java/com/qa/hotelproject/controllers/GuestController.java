package com.qa.hotelproject.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guest")											//localhost:8080/guest
public class GuestController {
	
//	Hello Test:
	@GetMapping("/hello")											//localhost:8080/guest/hello
	public String hello() {
		return "Hello";
	}
}
