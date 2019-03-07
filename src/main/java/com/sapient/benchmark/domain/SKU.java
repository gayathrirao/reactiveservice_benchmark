package com.sapient.benchmark.domain;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Document(collection="SKU")
@Getter
@Setter
@ToString
public class SKU {
	String sku_id;
	String 	size;
	String sku_sale_price;
	@Field("product_ID")
	String productID;
	
}
