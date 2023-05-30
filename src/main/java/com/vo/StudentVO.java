package com.vo;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString

public class StudentVO {

	private String passportNumber;

	private String firstName;

	private String lastName;

	private String email;

	private Integer age;

	private Integer subscriptionYear;

	private String birthCountry;

}
