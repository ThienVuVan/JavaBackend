package com.in28minute.jpahibernate.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Course {
	@Id
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "author")
	private String author;
}
