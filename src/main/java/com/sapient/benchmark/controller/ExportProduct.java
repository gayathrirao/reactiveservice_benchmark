package com.sapient.benchmark.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.benchmark.domain.Product;
import com.sapient.benchmark.domain.SKU;
import com.sapient.benchmark.repository.ProductRepository;
import com.sapient.benchmark.repository.SKURepository;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
public class ExportProduct {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private SKURepository skurepository;
	
	@GetMapping("/product/id/{id}")
	public Mono<Product> getProduct(@PathVariable ("id") String productID)
	{
		 Mono<Product> prod = productRepository.findByProductID(productID);
		 return prod;
	}
	
	@GetMapping("/saveskuForProduct/id/{id}")
	public Flux<SKU> saveSKU(@PathVariable ("id") String productID)
	{
		Mono<Product> prod = productRepository.findByProductID(productID);
		prod.map(product -> { 
		
		Flux<SKU> skus = skurepository.findByProductID(product.getProductID());
	
		Flux<SKU> newSKUS = skus.map(sku -> 
		 {
			 log.info("sku "+sku);
			 int newskuid = Integer.parseInt(sku.getSku_id()) +10;
			 SKU newSKU = new SKU(newskuid+"",sku.getSize()+newskuid,"400",sku.getProductID());
					 skurepository.save(newSKU).subscribe();
					 System.out.println("new sku"+newSKU);
			  return newSKU;
		 });
		newSKUS.subscribe(sku -> System.out.println(sku));
		 return skus;
		}).subscribe();
		return null;
			
	}

}
