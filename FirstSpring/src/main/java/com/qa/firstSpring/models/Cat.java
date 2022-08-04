package com.qa.firstSpring.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;

import com.sun.istack.NotNull;

@Entity
public class Cat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min = 2, max = 12)
	@NotNull
	private String name;
	
	@Min(0)
	@Max(110)
	private int age;
	
	@Autowired
	public Cat(Long id, @Size(min = 2, max = 12) String name, @Min(0) @Max(120) int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	@Autowired
	public Cat() {
		
	}
	
	@Autowired
	public Cat(@Size(min = 2, max = 12) String name, @Min(0) @Max(120) int age) {
		super();
		this.name = name;
		this.age = age;
	}


	@Override
	public String toString() {
		return "Cat [id= " + id + ", name= " + name + ", age= " + age + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cat other = (Cat) obj;
		return age == other.age && Objects.equals(name, other.name);
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	
}
