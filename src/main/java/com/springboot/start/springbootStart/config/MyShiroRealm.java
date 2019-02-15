package com.springboot.start.springbootStart.config;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.start.springbootStart.entity.Permission;
import com.springboot.start.springbootStart.entity.Role;
import com.springboot.start.springbootStart.entity.User;
import com.springboot.start.springbootStart.service.UserInfoService;

@Component
public class MyShiroRealm extends AuthorizingRealm{
	
	@Autowired
	private UserInfoService userInfoService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//shouquan
		
		User user =(User)principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		
		for (Role role : user.getURoles()) {
			authorizationInfo.addRole(role.getName());
			
			for (Permission permission : role.getPermissions()) {
					authorizationInfo.addStringPermission(permission.getName());
			}
		}
		
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//renzheng
		String userName = (String) token.getPrincipal();
		User user = userInfoService.findByUsername(userName);
		if (user==null) {
			return null;
		}
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(),getName());
		return authenticationInfo;
	}

}
