package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Course;
import com.repository.CourseRepository;
import com.vo.CourseVO;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.TransactionRequiredException;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;

	@Override
	public void createCourse(Course course) {
		try {
			courseRepository.createCourse(course);
			System.out.println("Info: Transazione riuscita.");
		} catch (EntityExistsException | IllegalArgumentException | TransactionRequiredException e) {
			e.printStackTrace();
			System.err.println("Errore: Transazione fallita.");
		}
	}

	@Override
	public List<CourseVO> readCourses() {
		List<CourseVO> courses = new ArrayList<>();
		try {
			courses = courseRepository.readCourses();
			System.out.println("Info: Transazione riuscita.");
		} catch (EntityExistsException | IllegalArgumentException | TransactionRequiredException e) {
			e.printStackTrace();
			System.err.println("Errore: Transazione fallita.");
		}

		return courses;
	}

	@Override
	public List<CourseVO> readCoursesLongerThan(Integer length) {
		List<CourseVO> courses = new ArrayList<>();
		try {
			courses = courseRepository.readCoursesLongerThan(length);
			System.out.println("Info: Transazione riuscita.");
		} catch (EntityExistsException | IllegalArgumentException | TransactionRequiredException e) {
			e.printStackTrace();
			System.err.println("Errore: Transazione fallita.");
		}

		return courses;
	}

}
