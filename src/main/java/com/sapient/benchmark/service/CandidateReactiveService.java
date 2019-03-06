package com.sapient.benchmark.service;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.sapient.benchmark.domain.Candidate;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CandidateReactiveService {
	@Autowired
	ReactiveMongoTemplate template;
	
	public Mono<Candidate> findById(String id) {
        return template.findById(id, Candidate.class);
    }
	public Mono<Candidate> findByEmailID(String emailID)
	{
		return template.findOne( new Query(where("emailID").in(emailID)), Candidate.class);
	}
    public Flux<Candidate> findAll() {
        return template.findAll(Candidate.class);
    } 
    public Mono<Candidate> save(Mono<Candidate> candidate) {
        return template.save(candidate);
    }
}
