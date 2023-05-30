package com.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.Student;
import com.vo.StudentVO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class StudentRepositoryImpl implements StudentRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void createStudent(Student student) {
		em.persist(student);

	}

	@Override
	public List<StudentVO> readStudents() {
		return em.createNamedQuery("Student.readStudents", StudentVO.class).getResultList();
	}

	@Override
	public List<StudentVO> readStudentsByYear(Integer subscriptionYear) {
		return em.createNamedQuery("Student.readStudentsByYear", StudentVO.class)
				.setParameter("subscriptionYear", subscriptionYear).getResultList();
	}

}
