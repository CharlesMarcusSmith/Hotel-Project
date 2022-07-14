package com.qa.hotelproject.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;

import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.hotelproject.entities.Guest;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:testschema.sql", "classpath:testdata.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class GuestControllerTest {
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper om;
	
	//readAll
	@Test
	public void getAllTest() throws Exception {
		//The result we expect
		List<Guest> output = new ArrayList<>();
		Guest entry = new Guest(1L, "Charles", "Smith", "charles@googlemail.com", 333);
		output.add(entry);
		
		//Converting output to JSON
		String outJSON = om.writeValueAsString(output);
		
		//Sending request
		mvc.perform(get("/guest/readAll").contentType(MediaType.APPLICATION_JSON)).andExpect(content().json(outJSON));
	} 
	
	//readById
	@Test
	public void getByIDTest() throws Exception {
		//The result we expect
		Guest output = new Guest(1L, "Charles", "Smith", "charles@googlemail.com", 333);
		
		//Converting output to JSON
		String outJSON = om.writeValueAsString(output);
		
		// Sending request
		mvc.perform(get("/guest/readById/1").contentType(MediaType.APPLICATION_JSON)).andExpect(content().json(outJSON));
		
		
	}
	
}
