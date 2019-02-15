package com.springboot.start.springbootStart.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequestVO {
	
	private String username;
	
	private String password;
	
	private String email;
	
	private String createTime;
	
	private String lastLoginTime;
	
	private Integer status;
	
	private String roleName;
	
	private String permissionName;
	

}
