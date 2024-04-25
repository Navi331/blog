package com.socialmedia.post_service;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(exclude={MongoAutoConfiguration.class})
public class PostService implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(PostService.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		System.out.println("PostService");
	}
}
