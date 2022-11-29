package com.solera.bank.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solera.bank.models.User;
import com.solera.bank.services.IUserService;

@RestController
@CrossOrigin
@RequestMapping("/api/bank/")
public class UserController {

	@Autowired
	IUserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		
		List<User> users= service.getAllUsers();
		
		return ResponseEntity.ok(users);
		
	}
	/**
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable String id){
		User user= service.getById(id);
		return ResponseEntity.ok(user);
	}
	
	/**
	 * 
	 * @param user
	 * @return ResponseEntity
	 */
	@PostMapping
	public ResponseEntity<String> createUser(@RequestBody User user){
	
		if(	service.createUser(user)) {
			return new ResponseEntity<String>("created",HttpStatus.CREATED); 
		}
		return new ResponseEntity<String>("not created",HttpStatus.BAD_REQUEST); 
	}
} 
