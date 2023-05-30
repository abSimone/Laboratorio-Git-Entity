package com.service;

import java.util.List;

import com.entity.Course;
import com.entity.Student;
import com.vo.CourseVO;

public interface StudentCourseService {

	public void createStudentCourses(Student student, List<Course> courses);

	public void createCourseStudents(Course course, List<Student> students);

	public List<CourseVO> readCoursesByStudentBirthCountry(String birthCountry);

}
