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
public class RolePermissionIdentity implements Serializable{

	@Column(name="rid")
	private Long rId;

	@Column(name="pid")
	private Long pId;
}
