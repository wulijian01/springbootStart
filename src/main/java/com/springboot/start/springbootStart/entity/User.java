package com.springboot.start.springbootStart.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.data.elasticsearch.annotations.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name="user",uniqueConstraints=@UniqueConstraint(columnNames="nickname"))
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="nickname")
	private String nickName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="create_time")
	@JsonIgnore
	private LocalDateTime createTime;
	
	@Column(name="last_login_time")
	@JsonIgnore
	private LocalDateTime lastLoginTime;
	
	@Column(name="status")
	private Integer status;
	
	@Column(name="des")
	private String des;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="user_role",joinColumns=@JoinColumn(name="uid"),inverseJoinColumns=@JoinColumn(name="rid"))
	private Set<Role> uRoles = new HashSet<>();
}
