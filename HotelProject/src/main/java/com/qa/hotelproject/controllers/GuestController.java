package com.qa.hotelproject.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.hotelproject.entities.Guest;

@RestController
@RequestMapping("/guest")											//localhost:8080/guest
public class GuestController {
	
//	Hello Test:
//	Used for testing functionality using postman
	@GetMapping("/hello")											//localhost:8080/guest/hello
	public String hello() {
		return "Hello";
	}
	
	//Temporary Array for testing CRUD, given unique name 'guestlist' to prevent confusion
	private List<Guest> guestlist = new ArrayList<>();
	
	//Get - Read All Functionality
	@GetMapping("/readAll")
	public List<Guest> readAll() {
		return this.guestlist;
	}
	
	@PostMapping("/create")
	public Guest create(@RequestBody Guest guest) {
		this.guestlist.add(guest);									//append to temp test list
		return this.guestlist.get(guestlist.size() - 1);			//-1 used as mock SQL id's begin at 1, Array Lists begin at 0 - for testing purposes only.
	}
	
}
