package com.ceitechs.dproz.sampleapp.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class User implements Serializable {

	private static final long serialVersionUID = -1353329736543106750L;
	
	private String firstName;
	
	private String lastName;
	
	private String email;

}
