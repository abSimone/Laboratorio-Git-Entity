package com.repository;

import java.util.List;

import com.entity.Course;
import com.entity.Student;
import com.vo.CourseVO;

public interface StudentCourseRepository {

	public void createStudentCourses(Student student, List<Course> courses);

	public void createCourseStudents(Course course, List<Student> students);

	public List<CourseVO> readCoursesByStudentBirthCountry(String birthCountry);
}
