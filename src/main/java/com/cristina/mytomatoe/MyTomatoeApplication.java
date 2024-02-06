package com.cristina.mytomatoe;

import com.cristina.mytomatoe.domain.MyUser;
import com.cristina.mytomatoe.domain.Task;
import com.cristina.mytomatoe.repositories.MyUserRepository;
import com.cristina.mytomatoe.repositories.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class MyTomatoeApplication {

	private static final Logger log = LoggerFactory.getLogger(MyTomatoeApplication.class);
	public static void main(String[] args) {

		SpringApplication.run(MyTomatoeApplication.class, args);
	}


}
