package com.ceitechs.dproz.sampleapp.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ceitechs.dproz.sampleapp.adapter.datastore.mongo.UserRepostitory;
import com.ceitechs.dproz.sampleapp.domain.User;
import com.ceitechs.dproz.sampleapp.domain.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepostitory userRepository;
	
	public UserServiceImpl(UserRepostitory userRepostitory) {
		this.userRepository = userRepostitory;	
	}
	

	@Override
	public Optional<User> getUser(String id) {
		return userRepository.findById(id);
	}

	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

}
