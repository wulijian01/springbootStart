package com.springboot.start.springbootStart.bean;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserVO {

	private String username;

	private String password;

	private String email;
	
	private List<Long> roles;
	
	private Long role;
	
}
