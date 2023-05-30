package com.repository;

import java.util.Date;
import java.util.List;

import com.entity.Order;
import com.entity.Product;

public interface OrderProductRepo {

	public void insertOrder(Order order);

	public void insertProduct(Product product);

	public void insertOrderProduct(Order order, List<Product> products);

	public void insertProductOrder(Product product, List<Order> orders);

	public List<Product> getAllProductsByBrand(String brand);

	public List<Order> getAllOrdersByProductId(Integer productId);

	public List<Order> getAllOrdersByDate(Date date);
}
