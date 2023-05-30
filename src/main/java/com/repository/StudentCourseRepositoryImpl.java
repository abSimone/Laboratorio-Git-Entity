package com.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.Course;
import com.entity.Student;
import com.vo.CourseVO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class StudentCourseRepositoryImpl implements StudentCourseRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void createStudentCourses(Student student, List<Course> courses) {
		student.setCourses(courses);
		for (Course c : courses) {
			em.persist(c);
		}
		em.persist(student);

	}

	@Override
	public void createCourseStudents(Course course, List<Student> students) {
		em.persist(course);
		for (Student s : students) {
			s.getCourses().add(course);
			em.persist(s);
		}

	}

	@Override
	public List<CourseVO> readCoursesByStudentBirthCountry(String birthCountry) {
		return em.createNamedQuery("Course.readCoursesByStudentBirthCountry", CourseVO.class)
				.setParameter("birthCountry", birthCountry).getResultList();
	}

}
