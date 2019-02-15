package com.springboot.start.springbootStart.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.springboot.start.springbootStart.entity.identity.UserRoleIdentity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="user_role")
public class UserRole implements Serializable{
	
	@EmbeddedId
	private UserRoleIdentity urids;

}
