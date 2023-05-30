package com.service;

import java.util.List;

import com.entity.Course;
import com.vo.CourseVO;

public interface CourseService {

	public void createCourse(Course course);

	public List<CourseVO> readCourses();

	public List<CourseVO> readCoursesLongerThan(Integer length);

}
