package com.springboot.start.springbootStart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.springboot.start.springbootStart.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> ,JpaSpecificationExecutor<User>{
	
	 User findByNickName(String nickName);
	 
	 List<User> findByIdIn(List ids);

}
