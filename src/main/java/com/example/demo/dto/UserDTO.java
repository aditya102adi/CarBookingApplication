package com.example.demo.dto;

import java.util.Set;

import com.example.demo.entity.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	
	private String name;
	private String email;
	private Set<Role> roles;
	
}
