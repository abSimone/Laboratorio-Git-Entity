package com.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.entity.Order;
import com.entity.Product;
import com.repository.OrderProductRepo;

public class OrderProductServiceImpl implements OrderProductService {

	@Autowired
	private OrderProductRepo opr;

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public void insertOrder(Order order) {
		try {
			opr.insertOrder(order);
			log.info("creazione avvenuta con successo!");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("creazione fallita");
		}

	}

	@Override
	public void insertProduct(Product product) {
		try {
			opr.insertProduct(product);
			log.info("creazione avvenuta con successo!");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("creazione fallita");
		}
	}

	@Override
	public void insertOrderProduct(Order order, List<Product> products) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertProductOrder(Product product, List<Order> orders) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Product> getAllProductsByBrand(String brand) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getAllOrdersByProductId(Integer productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getAllOrdersByDate(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

}
