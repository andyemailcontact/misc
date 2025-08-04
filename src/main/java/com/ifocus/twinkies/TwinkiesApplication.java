package com.ifocus.twinkies;

import com.ifocus.twinkies.configuration.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableConfigurationProperties(Info.class)
public class TwinkiesApplication {
	@Autowired

	public static void main(String[] args) {
		SpringApplication.run(TwinkiesApplication.class, args);
	}

	/*
	Spring calls the methods annotated with @PostConstruct only once, just after the initialization of bean properties. Keep in mind that these methods will run even if there’s nothing to initialize.
	The method annotated with @PostConstruct can have any access level, but it can’t be static.
	One possible use of @PostConstruct is populating a database. For instance, during development, we might want to create some default users:
	 */
	@PostConstruct
	public void init() {
		System.out.println("I'm done");
	}


}
