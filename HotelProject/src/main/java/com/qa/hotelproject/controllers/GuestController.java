package com.qa.hotelproject.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.hotelproject.entities.Guest;

@RestController
@RequestMapping("/guest") // localhost:8080/guest
public class GuestController {

//	Hello Test:
//	Used for testing functionality using postman
	@GetMapping("/hello") // localhost:8080/guest/hello
	public String hello() {
		return "Hello";
	}

	// Get - Read All Functionality
	@GetMapping("/readAll")
	public List<Guest> readAll() {
		return this.guestlist;
	}

	// Get - Read By Id
	@GetMapping("/readById/{id}")
	public Guest readByID(@PathVariable int id) {
		// This works differently to final readByID functionality, due to .get() and SQL
		// id's begin at 1 not 0.
		// On postman, searching id 0 instead of 1, will return first result, as method
		// uses List index not ID to search currently.
		return this.guestlist.get(id);
	}

	// POST - Create
	@PostMapping("/create")
	public Guest create(@RequestBody Guest guest) {
		this.guestlist.add(guest);									//append to temp test list
		return this.guestlist.get(guestlist.size() - 1);			//-1 used as mock SQL id's begin at 1, Array Lists begin at 0 - for testing purposes only.
	}
	
	//PUT - UPDATE
	@PutMapping("/update/{id}")
	public Guest update(@PathVariable int id, @RequestBody Guest guest) {
		//Remove old record:
		this.guestlist.remove(id);
		//Adding new record:
		this.guestlist.add(id, guest);
		//Return new record:
		return this.guestlist.get(id);
	}
	
	//POST - Delete
	@DeleteMapping("delete/{id}")
	public Guest delete(@PathVariable int id) {
		return this.guestlist.remove(id);
	}
	

}
