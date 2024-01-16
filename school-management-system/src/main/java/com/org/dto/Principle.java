package com.org.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Principle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	
	private String name;
	private int age;
	private long mobile;
	private String qualification;
	private String email;
	private String password;
	
	
	@OneToOne(mappedBy = "principle")
	private School school;
	
	@OneToMany(mappedBy = "principle" , cascade = CascadeType.ALL)
	private List<Teacher> teachers;
	
	@OneToMany(mappedBy = "principle",cascade = CascadeType.ALL)
	private List<Student> students;
	
}
