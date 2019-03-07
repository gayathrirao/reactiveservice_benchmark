package com.sapient.benchmark.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.sapient.benchmark.domain.SKU;

import reactor.core.publisher.Flux;

@Repository
public interface SKURepository extends ReactiveMongoRepository<SKU,String>{

	public Flux<SKU> findByProductID(String Product_ID);
}
