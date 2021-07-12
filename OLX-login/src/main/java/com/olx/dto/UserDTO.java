package com.olx.dto;

import com.olx.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


public class UserDTO {
	private String username;
	private String firstName;
	private String lastName;
	private String jwtToken;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getJwtToken() {
		return jwtToken;
	}
	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	public UserDTO(String username, String firstName, String lastName, String jwtToken) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.jwtToken = jwtToken;
	}
	public UserDTO(UserEntity userEntity) {
		// TODO Auto-generated constructor stub
	}
	public UserDTO() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "UserDTO [username=" + username + ", firstName=" + firstName + ", lastName=" + lastName + ", jwtToken="
				+ jwtToken + "]";
	}
	
	
}
