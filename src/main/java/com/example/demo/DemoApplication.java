package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DemoApplication {

	@GetMapping("/")
	public String hello() {
		return "hello";
	}

	@GetMapping("/slow")
	public String slow(int sleep) {
		try {
			Thread.sleep(sleep * 1000);
		} catch (InterruptedException e) {
			return e.getMessage();
		}
		return "sleep";
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
