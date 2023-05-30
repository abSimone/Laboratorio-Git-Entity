package com.vo;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString

public class CourseVO {
	private String courseId;

	private String title;

	private String description;

	private Integer length;
}
