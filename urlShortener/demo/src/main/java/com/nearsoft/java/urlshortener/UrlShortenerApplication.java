package com.nearsoft.java.urlshortener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class UrlShortenerApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(UrlShortenerApplication.class, args);
	}
}
