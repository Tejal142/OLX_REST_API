package com.olx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.olx.dto.AuthRequest;
import com.olx.dto.RegRequest;
import com.olx.dto.UserDTO;
import com.olx.service.UserService;
import com.olx.utils.JwtUtils;

@RestController
public class UserController {

	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	private UserService userService;	
	@Autowired
	JwtUtils jwtUtils;
	
	@PostMapping(value="/authenticate", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		authenticationManager.authenticate
		(new UsernamePasswordAuthenticationToken
				(authRequest.getUsername(), authRequest.getPassword()));
		UserDTO userDto = userService.findByUsername(authRequest.getUsername());
		userDto.setJwtToken(jwtUtils.generateToken(authRequest.getUsername()));
		return new ResponseEntity<UserDTO>(userDto, HttpStatus.OK);
	}
	
	@PostMapping(value="/register", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> register(@RequestBody RegRequest regRequest) throws Exception 
	{
		return new ResponseEntity<UserDTO>(userService.registerUser(regRequest), HttpStatus.OK);
	}
	
	
	@GetMapping(value="/userList", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<UserDTO> getAllUsers() {
		return this.userService.getUsersInfo();
	}
	
	
}
