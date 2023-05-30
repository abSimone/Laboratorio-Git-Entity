package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Course;
import com.entity.Student;
import com.repository.StudentCourseRepository;
import com.vo.CourseVO;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.TransactionRequiredException;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {

	@Autowired
	StudentCourseRepository studentCourseRepository;

	@Override
	public void createStudentCourses(Student student, List<Course> courses) {
		try {
			studentCourseRepository.createStudentCourses(student, courses);
			System.out.println("Info: Transazione riuscita.");
		} catch (EntityExistsException | IllegalArgumentException | TransactionRequiredException e) {
			e.printStackTrace();
			System.err.println("Errore: Transazione fallita.");
		}

	}

	@Override
	public void createCourseStudents(Course course, List<Student> students) {
		try {
			studentCourseRepository.createCourseStudents(course, students);
			System.out.println("Info: Transazione riuscita.");
		} catch (EntityExistsException | IllegalArgumentException | TransactionRequiredException e) {
			e.printStackTrace();
			System.err.println("Errore: Transazione fallita.");
		}

	}

	@Override
	public List<CourseVO> readCoursesByStudentBirthCountry(String birthCountry) {
		List<CourseVO> courses = new ArrayList<>();
		try {
			courses = studentCourseRepository.readCoursesByStudentBirthCountry(birthCountry);
			System.out.println("Info: Transazione riuscita.");
		} catch (EntityExistsException | IllegalArgumentException | TransactionRequiredException e) {
			e.printStackTrace();
			System.err.println("Errore: Transazione fallita.");
		}

		return courses;
	}

}
