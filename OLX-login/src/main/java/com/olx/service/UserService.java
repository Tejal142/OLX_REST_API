package com.olx.service;

import java.util.List;

import com.olx.dto.RegRequest;
import com.olx.dto.UserDTO;

public interface UserService {

	public UserDTO registerUser(RegRequest registerRequest);
	List<UserDTO> findByUsernames(String usernames);
	UserDTO findByUsername(String username);
	public List<UserDTO> getUsersInfo();
}
