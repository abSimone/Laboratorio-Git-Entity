package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.entity.Order;
import com.entity.Product;
import com.repository.OrderProductRepo;

import jakarta.annotation.Resource;

@SpringBootApplication
public class LaboratorioGitEntityApplication implements CommandLineRunner {

	@Autowired
	private OrderProductRepo repo;

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

	}

}
