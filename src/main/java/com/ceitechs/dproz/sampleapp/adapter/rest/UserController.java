package com.ceitechs.dproz.sampleapp.adapter.rest;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceitechs.dproz.sampleapp.domain.User;
import com.ceitechs.dproz.sampleapp.domain.UserService;

@RestController
@RequestMapping("/api/dproz/user")
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	} 
	
	
	@GetMapping(value= "/{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE )
	public ResponseEntity<User> getUser(Long id){	
		return ResponseEntity.ok(userService.getUser(id));
		
	}

}
