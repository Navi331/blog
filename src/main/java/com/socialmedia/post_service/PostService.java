package com.socialmedia.post_service;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PostService implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(PostService.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

	}
}
