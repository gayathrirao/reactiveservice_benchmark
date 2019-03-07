package com.sapient.benchmark.repository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.sapient.benchmark.domain.Product;

import reactor.core.publisher.Mono;

@Repository

public interface ProductRepository extends ReactiveMongoRepository<Product,String> {
	Mono<Product> findByProductID(String productID);
}
