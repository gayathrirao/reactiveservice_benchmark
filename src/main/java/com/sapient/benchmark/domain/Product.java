package com.sapient.benchmark.domain;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Document(collection="Product")
@Getter
@Setter
@ToString
public class Product {
	@Field("product_ID")
	String productID;
	String productname;
	String Category;
	String age;
	boolean hazardous;
	String MRP;
	String description;
}
