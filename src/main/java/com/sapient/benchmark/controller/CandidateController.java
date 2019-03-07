package com.sapient.benchmark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.*;

import com.sapient.benchmark.domain.Candidate;
import com.sapient.benchmark.service.CandidateReactiveService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
public class CandidateController {
	
	@Autowired
	CandidateReactiveService repo;
	
	@GetMapping("candidate/email1/{email}")
	public Mono<Candidate> getByEmail(@PathVariable("email") String emailid)
	{
		Mono<Candidate> candidate = repo.findByEmailID(emailid);
		log.info("Email id returned for "+"emailid " + emailid + candidate);
		return candidate;
	}
	
	@RequestMapping(value = "candidate/email/{email}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Mono<Candidate>> findById(@PathVariable("email") String emailid) {
		Mono<Candidate> candidate = repo.findByEmailID(emailid);
		log.info("Email id returned for "+" emailid "+emailid + candidate);
        HttpStatus status = (candidate != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
        return new ResponseEntity<Mono<Candidate>>(candidate, status);
    }
	
	
	@GetMapping(value="candidate/all",produces=MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Candidate> getall()
	{
		Flux<Candidate> candidate = repo.findAll();
		return candidate;
	}

}
