package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Student;
import com.repository.StudentRepository;
import com.vo.StudentVO;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.TransactionRequiredException;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void createStudent(Student student) {
		try {
			studentRepository.createStudent(student);
			System.out.println("Info: Transazione riuscita.");
		} catch (EntityExistsException | IllegalArgumentException | TransactionRequiredException e) {
			e.printStackTrace();
			System.err.println("Errore: Transazione fallita.");
		}
	}

	@Override
	public List<StudentVO> readStudents() {
		List<StudentVO> students = new ArrayList<>();
		try {
			students = studentRepository.readStudents();
			System.out.println("Info: Transazione riuscita.");
		} catch (EntityExistsException | IllegalArgumentException | TransactionRequiredException e) {
			e.printStackTrace();
			System.err.println("Errore: Transazione fallita.");
		}

		return students;
	}

	@Override
	public List<StudentVO> readStudentsByYear(Integer subscriptionYear) {
		List<StudentVO> students = new ArrayList<>();
		try {
			students = studentRepository.readStudentsByYear(subscriptionYear);
			System.out.println("Info: Transazione riuscita.");
		} catch (EntityExistsException | IllegalArgumentException | TransactionRequiredException e) {
			e.printStackTrace();
			System.err.println("Errore: Transazione fallita.");
		}

		return students;
	}

}
