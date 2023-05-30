package com;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.entity.Order;
import com.entity.Product;

@Configuration
public class BeanConfig {

	@Bean(name = "insertProduct1")
	public Product insertProduct1() {
		return new Product("Wacko's", "San Carlo", "cos cos tutt cos", 45.99);
	}

	@Bean(name = "insertProduct2")
	public Product insertProduct2() {
		return new Product("Ovetto Kinder", "Kinder", "chi ha avuto ebbe", 2.99);
	}

	@Bean(name = "insertProduct3")
	public Product insertProduct3() {
		return new Product("Goleador Sour", "Goleador", "Maniscalco's passion davanti agli asili", 0.10);
	}

	/**
	 * @throws ParseException
	 ***********************************************************/

	@Bean(name = "insertOrder1")
	public Order insertOrder1() throws ParseException {
		return new Order(new SimpleDateFormat("dd-MM-yyyy").parse("30-05-2023"), "Via le mani dal C");
	}

	@Bean(name = "insertOrder2")
	public Order insertOrder2() throws ParseException {
		return new Order(new SimpleDateFormat("dd-MM-yyyy").parse("07-03-2021"), "Via col Vento");
	}

	@Bean(name = "insertOrder3")
	public Order insertOrder3() throws ParseException {
		return new Order(new SimpleDateFormat("dd-MM-yyyy").parse("21-09-2002"), "Via col Maniscalco");
	}

}
