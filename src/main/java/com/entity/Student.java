package com.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

@Entity
@NamedQueries({
		@NamedQuery(name = "Student.readStudentsByYear", query = "SELECT new com.vo.StudentVO(s.passportNumber, s.firstName, s.lastName, s.email, s.age, s.subscriptionYear, s.birthCountry) FROM Student s WHERE s.subscriptionYear = :subscriptionYear"), })

public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "passport_number")
	private String passportNumber;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;

	@Column(name = "age")
	private Integer age;

	@Column(name = "subcription_year")
	private Integer subscriptionYear;

	@Column(name = "birth_country")
	private String birthCountry;

	@ManyToMany
	@JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "passport_number"), inverseJoinColumns = @JoinColumn(name = "code"))
	private List<Course> courses = new ArrayList<>();

	public Student(String firstName, String lastName, String email, Integer age, Integer subscriptionYear,
			String birthCountry) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.age = age;
		this.subscriptionYear = subscriptionYear;
		this.birthCountry = birthCountry;
	}

}
