package com.alura.forum;

import static java.lang.String.valueOf;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AluraForumApplication {

	@Value("${PORT:8080}")
	private static int port;
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(AluraForumApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", valueOf(port)));
		app.run(args);


	}

}
