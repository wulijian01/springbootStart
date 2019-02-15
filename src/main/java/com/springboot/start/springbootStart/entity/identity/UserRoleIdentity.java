package com.springboot.start.springbootStart.entity.identity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class UserRoleIdentity implements Serializable{

	@Column(name="uid")
	private Long uId;
	
	@Column(name="rid")
	private Long rId;
}
