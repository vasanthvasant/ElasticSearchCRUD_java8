package com.elasticSearch.crud.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(indexName = "student")
public class Student {
	@Id
	private int id;
	@Field(type = FieldType.Text,name = "name")
	private String name;
	@Field(type=FieldType.Integer,name="mobile")
	private long mobile;
	@Field(type = FieldType.Text,name = "name")
	private String email;

}
