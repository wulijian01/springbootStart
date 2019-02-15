package com.springboot.start.springbootStart.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.sql.DataSource;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.start.springbootStart.config.AppConfig;
import com.springboot.start.springbootStart.entity.Permission;
import com.springboot.start.springbootStart.entity.Role;
import com.springboot.start.springbootStart.entity.User;

@RunWith(value = SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestPropertySource(locations = "classpath:application-test.properties")
public class RoleRepositoryTest {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;
	

	@Test
	public void getRoleById() {


		Optional<Role> role = roleRepository.findById(2L);

		Role role2 = role.get();

		System.out.println(role2.toString());

	}

	@Test
	@Rollback(false)
	public void createRole() {

		Set<Permission> permissions = new HashSet<Permission>();

		Permission permission1 = Permission.builder().id(1L).build();
		Permission permission2 = Permission.builder().id(2L).build();
		permissions.add(permission1);
		permissions.add(permission2);

		Role role = roleRepository.findByName("GUser");
		if (role != null) {
			role.setPermissions(permissions);
		} else {

			role = Role.builder().name("GUser").permissions(permissions).build();
		}

		roleRepository.save(role);

	}

	@Test
	@Rollback(false)
	public void deleteRoleById() {
		Role role = null;
		Optional<Role> option = roleRepository.findById(12L);

		if (option.isPresent()) {
			role = option.get();
		}

		if (role != null && CollectionUtils.isNotEmpty(role.getUsers())) {
			List<Long> list = new ArrayList<>();
			role.getUsers().stream().forEach(user -> {
				list.add(user.getId());
			});

			List<User> users = userRepository.findByIdIn(list);
			Set<Role> hashSet = new HashSet<>();
			users.stream().forEach(user -> {

				user.setURoles(hashSet);
			});
			userRepository.saveAll(users);
		}
		roleRepository.deleteById(12L);
	}

}
