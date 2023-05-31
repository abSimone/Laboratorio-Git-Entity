package com.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity

@NamedQueries({ @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
		@NamedQuery(name = "Product.getAllProductsByBrand", query = "SELECT p FROM Product p WHERE brand = :brand"),
		@NamedQuery(name = "Product.getAllOrdersByProductId", query = "SELECT p.orders FROM Product p WHERE productId = :productId") })

public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Integer productId;

	@Column(name = "product_name")
	private String productName;

	private String brand;

	private String description;

	private Double price;

	@ManyToMany(mappedBy = "products")
	private List<Order> orders = new ArrayList<>();

	public Product(String productName, String brand, String description, Double price) {
		this.productName = productName;
		this.brand = brand;
		this.description = description;
		this.price = price;
	}

	public Product(Integer productId, String productName, String brand, String description, Double price) {
		this.productId = productId;
		this.productName = productName;
		this.brand = brand;
		this.description = description;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", brand=" + brand
				+ ", description=" + description + ", price=" + price + "]";
	}

}
