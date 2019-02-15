package com.springboot.start.springbootStart.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springboot.start.springbootStart.bean.UserVO;
import com.springboot.start.springbootStart.config.PropertiesReadTestConfig;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
	
	@Autowired
	private PropertiesReadTestConfig propertiesConfig;
	
	@RequestMapping({ "/", "/index" })
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/config", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="test read proerties",notes="test")
	public Map<String, Object> config() {
		Map<String, Object> map = new HashMap<>();
		map.put("id", propertiesConfig.getId());
		map.put("host", propertiesConfig.getHost());
		map.put("testMap", propertiesConfig.getTestMap());
		
		return map;

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String sublogin(@Valid UserVO user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
		token.setRememberMe(false);
		try {
			log.info("对用户[{}]进行登录验证..验证开始", user.getUsername());
			subject.login(token);
			System.out.println(token.toString());
		} catch (UnknownAccountException uae) {
			redirectAttributes.addFlashAttribute("message", "未知账户");
		} catch (IncorrectCredentialsException ice) {
			redirectAttributes.addFlashAttribute("message", "密码不正确");
		} catch (LockedAccountException lae) {
			redirectAttributes.addFlashAttribute("message", "账户已锁定");
		} catch (ExcessiveAttemptsException eae) {
			redirectAttributes.addFlashAttribute("message", "用户名或密码错误次数过多");
		} catch (AuthenticationException ae) {
			// 通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
			ae.printStackTrace();
			redirectAttributes.addFlashAttribute("message", "用户名或密码不正确");
		}
		if (subject.isAuthenticated()) {
			
			return "redirect:/index";
		}else {
			
			token.clear();
			return "login";
		}

	}

	@RequestMapping("/logout")
	public String logout() {
		
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "login";
	}
	
	@RequestMapping("/403")
	public String unauthorizedRole() {
		System.out.println("------------12345------");
		return "403";
	}

}