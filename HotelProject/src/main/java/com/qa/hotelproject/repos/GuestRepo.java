package com.qa.hotelproject.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.hotelproject.entities.Guest;

@Repository
public interface GuestRepo extends JpaRepository<Guest, Long> {
	
}
