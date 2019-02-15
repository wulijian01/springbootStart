package com.springboot.start.springbootStart.es;

import javax.persistence.Id;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "useresidx", type = "useridx")
public class UserIndex {

	@Id
	private Long id;

	@Field(type = FieldType.Text)
	private String nickName;

	@Field(type = FieldType.Keyword)
	private String des;
}
