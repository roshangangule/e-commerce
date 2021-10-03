package com.ecommerce.entity;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Product")
//@Data
@Getter
@Setter
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="category_id",nullable = false)
	private ProductCategory category;
	
	@Column(name="sku")
	private String sku;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="unit_price")
	private BigDecimal unitPrice;
	
	@Column(name="image_url")
	private String imageURL;
	
	@Column(name="active")
	private boolean active;
	
	@Column(name="units_in_stock")
	private int unitInStock;
	
	@Column(name="date_created")
	@CreationTimestamp
	private Date createdOn;
	
	@Column(name="last_updated")
	@LastModifiedDate
	private Date updatedOn;
//	
//	@Column(name="category_id")
//	private Long categoryId;
//	
	
}
