package com.ceitechs.dproz.sampleapp.domain;

public interface UserService {
	
	User getUser(Long id);
	
	void addUser(User user);

}
