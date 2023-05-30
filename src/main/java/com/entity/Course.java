package com.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

@Entity
@NamedQueries({
		@NamedQuery(name = "Course.readCoursesByStudentBirthCountry", query = "SELECT new com.vo.CourseVO(c.code, c.title, c.description, c.length) FROM Course c JOIN students s WHERE s.birthCountry = :birthCountry"),
		@NamedQuery(name = "Course.readCoursesLongerThan", query = "SELECT new com.vo.CourseVO(c.code, c.title, c.description, c.length) FROM Course c WHERE c.length > :length"), })

public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String code;

	private String title;

	private String description;

	private Integer length;

	@ManyToMany(mappedBy = "courses")
	private List<Student> students = new ArrayList<>();

	public Course(String title, String description, Integer length) {
		this.title = title;
		this.description = description;
		this.length = length;
	}

}
