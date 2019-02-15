package com.springboot.start.springbootStart.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder.FilterFunctionBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.start.springbootStart.bean.UserVO;
import com.springboot.start.springbootStart.config.AppConfig;
import com.springboot.start.springbootStart.entity.Role;
import com.springboot.start.springbootStart.entity.User;
import com.springboot.start.springbootStart.es.UserIndex;
import com.springboot.start.springbootStart.repository.RoleRepository;
import com.springboot.start.springbootStart.repository.UserEsRepository;
import com.springboot.start.springbootStart.repository.UserRepository;

@Controller
@RequestMapping("/userInfo")
public class UserInfoController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserEsRepository userEsRepository;

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
//	private AppConfig app;
	@Qualifier("S400DataSource")
	private DataSource asdb;

	@RequestMapping("/userList")
	@RequiresPermissions("userInfo:view")
	public String userInfo() {
		return "userInfo";
	}

	@RequestMapping("/userAdd")
	@RequiresPermissions("user:create")
	@Transactional
	public String userAdd(Model model, UserVO userVO) {

		Set<Role> sRoles = new HashSet<Role>();

		userVO.getRoles().forEach(roleId -> {
			Role role = new Role();
			role.setId(roleId);
			sRoles.add(role);
		});

		User user = userRepository.findByNickName(userVO.getUsername());
		if (user != null) {
			user.setPassword(userVO.getPassword() == null ? user.getPassword() : userVO.getPassword());
			user.setEmail(userVO.getEmail() == null ? user.getEmail() : userVO.getEmail());
			if (CollectionUtils.isNotEmpty(sRoles)) {
				user.setURoles(sRoles);
			}
			user.setStatus(1);
		} else {

			user = User.builder().nickName(userVO.getUsername()).password(userVO.getPassword()).email(userVO.getEmail())
					.status(1).uRoles(sRoles).build();
		}

		User save = userRepository.save(user);
		UserIndex userEs = UserIndex.builder().id(save.getId()).nickName(save.getNickName()).des("nihaoa").build();
		
//        //save to ES
		userEsRepository.save(userEs);

		List<Role> roles = roleRepository.findAll();

		model.addAttribute("roles", roles);

		model.addAttribute("user", save);

		return "add_user";
	}

	@RequestMapping("/toAddUser")
	public String toAddUserHtml(Model model) {
		List<Role> roles = roleRepository.findAll();
		model.addAttribute("roles", roles);
		return "add_user";
	}

	@RequestMapping(value = "/getUserByNickName", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody UserVO getUserByNickNameWithAjax(Model model,String nickname) {
		
		FilterFunctionBuilder[] functions = {
		        new FunctionScoreQueryBuilder.FilterFunctionBuilder(
		        		QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("nickName", nickname)),                 
		        		ScoreFunctionBuilders.weightFactorFunction(1000)),                    
		        new FunctionScoreQueryBuilder.FilterFunctionBuilder(
		        		QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("des", nickname)),
		        		ScoreFunctionBuilders.weightFactorFunction(1000))      
		};
		QueryBuilder qb = QueryBuilders.functionScoreQuery(functions);

		SearchQuery searchQuery = new NativeSearchQueryBuilder()

				.withQuery(qb).build();

		Page<UserIndex> search = userEsRepository.search(searchQuery);
		UserIndex user = search.getContent().get(0);
//		Optional<UserIndex> findById = userEsRepository.findById("42");

//		UserIndex user = findById.get();

		UserVO userVO = new UserVO();
//		userVO.setEmail(user.getEmail());
		userVO.setUsername(user.getNickName());
//		userVO.setPassword(user.getPassword());

		return userVO;

	}

	////////////////// registerUser//////////////////
	@RequestMapping("/toRegister")
	public String toRegisterUser() {

		return "register";
	}

	@PostMapping("/userRegister")
	public String userRegister(UserVO userVO) {

		User findByNickName = userRepository.findByNickName(userVO.getUsername());
		if (findByNickName != null) {

			// return error page！
			return "403";
		}

		Role role = Role.builder().id(userVO.getRole()).build();
		Set<Role> roles = new HashSet<>();
		roles.add(role);

		User user = User.builder().nickName(userVO.getUsername()).password(userVO.getPassword())
				.email(userVO.getEmail()).status(1).uRoles(roles).build();
		User save = userRepository.save(user);
		return "login";
	}

	@RequestMapping("/userDel")
	@RequiresPermissions("userInfo:del")
	public String userDel() {
		return "userInfoDel";
	}

	public static void main(String[] args) {
		List<Long> list = Arrays.asList(1L, 2L);
		Set<Role> sRoles = new HashSet<Role>();

		Role role = new Role();
		list.forEach(roleId -> {
			role.setId(roleId);
			sRoles.add(role);
		});

		System.out.println(sRoles);
	}
}