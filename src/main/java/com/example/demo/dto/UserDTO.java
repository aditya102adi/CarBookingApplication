package com.example.demo.dto;

import java.util.Set;

import com.example.demo.entity.enums.Role;

public class UserDTO {
	
	private String name;
	
	private String email;
	
	private Set<Role> roles;
	
	public UserDTO() {
		// TODO Auto-generated constructor stub
	}

	public UserDTO(String name, String email, Set<Role> roles) {
		super();
		this.name = name;
		this.email = email;
		this.roles = roles;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
