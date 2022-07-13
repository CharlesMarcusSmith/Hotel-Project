package com.qa.hotelproject.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.qa.hotelproject.entities.Guest;
import com.qa.hotelproject.repos.GuestRepo;

@Service
public class GuestService {
	
//	Repo Dependency:
	private GuestRepo repo;
	public GuestService(GuestRepo repo) {
		this.repo = repo;
	}

//	Repo Functionality:
	
	// Read All 
	public List<Guest> readAll() {
		return this.repo.findAll();
	}

	// Read By Id
	public Guest readByID(@PathVariable long id) {
		return this.repo.findById(id).get();
	}

	// Create
	public Guest create(@RequestBody Guest guest) {
		return this.repo.saveAndFlush(guest);
	}
	
	// Update by id
	public Guest update(@PathVariable long id, @RequestBody Guest guest) {					//'guest' holds the new properties we with to overwrite, not including id.
		//Store existing entry as temp using id
		Guest temp = this.repo.findById(id).get();											
		
//		Overwriting existing properties:
		temp.setFirstName(guest.getFirstName());
		temp.setLastName(guest.getLastName());
		temp.setEmail(guest.getEmail());
		temp.setRoomNumber(guest.getRoomNumber());
		
//		Add newly updated entry:
		return this.repo.saveAndFlush(temp);												// entity is parameter data type.
	}
	
	//Delete
	public Guest delete(@PathVariable long id) {
		return this.guestlist.remove(id - 1);
	}
}
