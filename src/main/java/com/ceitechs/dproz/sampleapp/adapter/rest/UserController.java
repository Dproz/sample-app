package com.ceitechs.dproz.sampleapp.adapter.rest;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceitechs.dproz.sampleapp.domain.User;
import com.ceitechs.dproz.sampleapp.domain.UserService;
import com.ceitechs.dproz.shared.rest.util.HeaderUtil;

import io.github.jhipster.web.util.ResponseUtil;

@RestController
@RequestMapping("/api/dproz/user")
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	} 
	
	
	@GetMapping(value= "/{id}")
	public ResponseEntity<User> getUser(@PathVariable String id){	
		return ResponseUtil.wrapOrNotFound(userService.getUser(id));
		
	}
	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE )
	public ResponseEntity<User> addUser(@RequestBody User user){	
		User userAdded = userService.addUser(user);
		 return ResponseEntity.ok()
		            .headers(HeaderUtil.createEntityUpdateAlert("USER", userAdded.getId().toString()))
		            .body(userAdded);
	}

}
