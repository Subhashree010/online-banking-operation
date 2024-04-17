package com.techm.nine.obs.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techm.nine.obs.entity.User;
import com.techm.nine.obs.repository.UserRepository;
import com.techm.nine.obs.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User createUser(User user) {
		
		return userRepository.save(user);
	}

	@Override
	public User getUserByUserNameAndPassword(String userName,String password) {
		
		User user = userRepository.findByUserNameAndPassword(userName, password);
		
		return user;
	}

	@Override
	public User getUserById(Long userId) {

		return userRepository.findById(userId).get();
	}

}
