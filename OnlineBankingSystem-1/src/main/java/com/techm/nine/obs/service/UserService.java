package com.techm.nine.obs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.techm.nine.obs.entity.User;

public interface UserService {
	
	User createUser(User user);
	User getUserByUserNameAndPassword(String userName,String password);
	User getUserById(Long userId);
}
