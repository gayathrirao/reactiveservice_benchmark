package com.sapient.benchmark.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.sapient.benchmark.domain.Candidate;

@Repository
public interface CandidateRepository extends ReactiveMongoRepository<Candidate,String>  {
	

}
