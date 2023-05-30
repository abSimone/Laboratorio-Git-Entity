package com;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.entity.Order;
import com.entity.Product;
import com.repository.OrderProductRepo;

import com.entity.Course;
import com.entity.Student;
import com.service.CourseService;
import com.service.StudentCourseService;
import com.service.StudentService;

import jakarta.annotation.Resource;

@SpringBootApplication
public class LaboratorioGitEntityApplication implements CommandLineRunner {

	@Autowired
	private OrderProductRepo repo;
  
	@Autowired
	private StudentService studentService;

	@Autowired
	private StudentCourseService studentCourseService;
  
  @Autowired
  private CourseService courseService;

	@Resource(name = "insertProduct1")
	private Product insertProduct1;

	@Resource(name = "insertProduct2")
	private Product insertProduct2;

	@Resource(name = "insertProduct3")
	private Product insertProduct3;

	/*********************************************/

	@Resource(name = "insertOrder1")
	private Order insertOrder1;

	@Resource(name = "insertOrder2")
	private Order insertOrder2;

	@Resource(name = "insertOrder3")
	private Order insertOrder3;
  
	@Resource
	private Student s1;

	@Resource
	private Student s2;

	@Resource
	private Student s3;

	@Resource
	private Course c1;

	@Resource
	private Course c2;

	public static void main(String[] args) {
		SpringApplication.run(LaboratorioGitEntityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		repo.insertOrder(insertOrder1);
		repo.insertOrder(insertOrder2);
		repo.insertOrder(insertOrder3);

		repo.insertProduct(insertProduct1);
		repo.insertProduct(insertProduct2);
		repo.insertProduct(insertProduct3);


		c1.setTitle("Java");
		c1.setDescription("Corso Java Spring");
		c1.setLength(92);

		c2.setTitle("Angular");
		c2.setDescription("Corso Angular");
		c2.setLength(78);
		courseService.createCourse(c2);

		s1.setFirstName("Alice");
		s1.setLastName("Rossi");
		s1.setAge(20);
		s1.setBirthCountry("Italia");
		s1.setEmail("alice.rossi@example.com");
		s1.setSubscriptionYear(2020);

		s2.setFirstName("Marco");
		s2.setLastName("Bianchi");
		s2.setAge(22);
		s2.setBirthCountry("Germania");
		s2.setEmail("marco.bianchi@example.com");
		s2.setSubscriptionYear(2019);

		s3.setFirstName("Emily");
		s3.setLastName("Johnson");
		s3.setAge(19);
		s3.setBirthCountry("Stati Uniti");
		s3.setEmail("emily.johnson@example.com");
		s3.setSubscriptionYear(2020);

		List<Student> students = Arrays.asList(s1, s2, s3);

		studentCourseService.createCourseStudents(c1, students);

		// ---------------- QUERIES ----------------

		System.err.println("--------------------------------------------");

		// Selezionare tutti gli studenti che sono iscritti allo stesso anno accademico
		studentService.readStudentsByYear(2020).forEach(System.out::println);
		System.err.println("--------------------------------------------");

		// Selezionare tutti i corsi frequentati da studenti nati in germania
		studentCourseService.readCoursesByStudentBirthCountry("Germania").forEach(System.out::println);
		System.err.println("--------------------------------------------");

		// Selezionare tutti i corsi che hanno una durata di almeno 90 ore
		courseService.readCoursesLongerThan(90).forEach(System.out::println);
		System.err.println("--------------------------------------------");

	}

}
