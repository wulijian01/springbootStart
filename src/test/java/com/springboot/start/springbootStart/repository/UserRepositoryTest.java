package com.springboot.start.springbootStart.repository;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.springboot.start.springbootStart.entity.Role;
import com.springboot.start.springbootStart.entity.User;

@RunWith(value = SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestPropertySource(locations = "classpath:application-test.properties")
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

//	@Autowired
//	private UserInfoController userInfoController;

	private Gson gson;

	{
		gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		;
	}

	@Test
	public void getUserTest() {

		User user = userRepository.findByNickName("小毛");

		System.out.println(gson.toJson(user));

	}

	@Test
	@Rollback(false)
	public void saveUserTest() {

		Set<Role> roles = new HashSet<Role>();		
		Role role = Role.builder().id(1L)
				.build();
		Role role1 = Role.builder().id(2L)
				.build();
		roles.add(role);
		roles.add(role1);
		
		User user=userRepository.findByNickName("admin");
		if (user!=null) {
			user.setURoles(roles);
			user.setStatus(1);			
		}else {
			
		user = User.builder().nickName("admin").password("1234").email("admin@631.com")
				.status(1)
				.uRoles(roles)
				.build();
		}


		User save = userRepository.save(user);
		System.out.println(save.toString());

	}

	
	@Test
	@Rollback(false)
	public void deleteUserTest() {
		userRepository.deleteById(29L);
		
	}
}
