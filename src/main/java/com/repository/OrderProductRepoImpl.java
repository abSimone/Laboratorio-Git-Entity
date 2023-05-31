package com.repository;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Order;
import com.entity.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Transactional
@Repository
public class OrderProductRepoImpl implements OrderProductRepo {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void insertOrder(Order order) {
		em.persist(order);
	}

	@Override
	public void insertProduct(Product product) {
		em.persist(product);
	}

	@Override
	public void insertOrderProduct(Order order, List<Product> products) {
		em.persist(order);
		for (Product p : products) {
			p.getOrders().add(order);
			em.persist(p);
		}
	}

	@Override
	public void insertProductOrder(Product product, List<Order> orders) {
		em.persist(product);
		for (Order o : orders) {
			o.getProducts().add(product);
			em.persist(o);
		}
	}

	@Override
	public List<Product> getAllProductsByBrand(String brand) {
		return em.createNamedQuery("Product.getAllProductsByBrand", Product.class).setParameter("brand", brand)
				.getResultList();
	}

	@Override
	public List<Order> getAllOrdersByProductId(Integer productId) {
		return em.createNamedQuery("Product.getAllOrdersByProductId", Order.class).setParameter("productId", productId)
				.getResultList();
	}

	@Override
	public List<Order> getAllOrdersByDate(Date date) {
		return em.createNamedQuery("Order.getAllOrdersByDate", Order.class).setParameter("date", date).getResultList();
	}

}
