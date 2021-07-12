package com.olx.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olx.dto.RegRequest;
import com.olx.dto.UserDTO;
import com.olx.entity.UserEntity;
import com.olx.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDTO findByUsername(String username) {
		List<UserEntity> userEntityList = userRepository.findByUserName(username);	
		UserEntity userEntity = userEntityList.get(0);
		UserDTO userDto = new UserDTO();
		userDto.setFirstName(userEntity.getFirstName());
		userDto.setLastName(userEntity.getLastName());
		userDto.setUsername(userEntity.getUserName());
		return userDto;
	}

	@Override
	public UserDTO registerUser(RegRequest registerRequest) {
		List<UserEntity> userEntityList = userRepository.findByUserName(registerRequest.getUsername());
	
		UserEntity userEntity = new UserEntity();
		userEntity.setActive(true);
		userEntity.setFirstName(registerRequest.getFirstname());
		userEntity.setLastName(registerRequest.getLastname());
		userEntity.setPassword(registerRequest.getPassword());
		userEntity.setRoles("USER");
		userEntity.setUserName(registerRequest.getUsername());
		userEntity = userRepository.save(userEntity);
		
		UserDTO userDto = new UserDTO();
		userDto.setFirstName(userEntity.getFirstName());
		userDto.setLastName(userEntity.getLastName());
		userDto.setUsername(userEntity.getUserName());
		return userDto;
	}

	@Override
	public List<UserDTO> findByUsernames(String usernames) {
		String usernameArray[] = usernames.split(",");
		List<UserDTO> userList = new ArrayList<>();
		for(int i=0; i<usernameArray.length; i++) {
			if(usernameArray[i]!=null && usernameArray[i].trim().length()>0) {
				userList.add(this.findByUsername(usernameArray[i]));
			}
		}
		return userList;
	}

	
	@Override
	public List<UserDTO> getUsersInfo() {
		List<UserEntity> userDTOEntities = userRepository.findAll();
		List<UserDTO> users = new ArrayList<>();
		userDTOEntities.stream().
		forEach((userEntity)->users.add(new UserDTO(userEntity)));
		return users;
	}

}
