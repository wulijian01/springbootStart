package com.springboot.start.springbootStart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.start.springbootStart.entity.User;
import com.springboot.start.springbootStart.repository.UserRepository;
import com.springboot.start.springbootStart.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User findByUsername(String username) {
		
		 User findByNickName = userRepository.findByNickName(username);
		 return findByNickName;
	}

}
