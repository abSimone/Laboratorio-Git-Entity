package com.repository;

import java.util.List;

import com.entity.Student;
import com.vo.StudentVO;

public interface StudentRepository {
	public void createStudent(Student student);

	public List<StudentVO> readStudents();

	public List<StudentVO> readStudentsByYear(Integer subscriptionYear);

}
