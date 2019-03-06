package com.sapient.benchmark;

import java.util.Random;
import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SpringBootApplication
@EnableMongoRepositories
public class ReactiveService
//extends AbstractReactiveMongoConfiguration
{

	public static void main(String[] args) {
		SpringApplication.run(ReactiveService.class, args);
	}
	
	/*	 
	    @Bean
	    public MongoClient mongoClient() {
	        return MongoClients.create();
	    }
	 
	    @Override
	    protected String getDatabaseName() {
	        return "benchmark";
	    }


		@Override
		public MongoClient reactiveMongoClient() {
			 return MongoClients.create();
		}*/
	
	
}