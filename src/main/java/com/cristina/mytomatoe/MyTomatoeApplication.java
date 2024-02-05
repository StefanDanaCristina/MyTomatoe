package com.cristina.mytomatoe;

import com.cristina.mytomatoe.domain.Task;
import com.cristina.mytomatoe.repositories.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyTomatoeApplication {

	private static final Logger log = LoggerFactory.getLogger(MyTomatoeApplication.class);
	public static void main(String[] args) {

		SpringApplication.run(MyTomatoeApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(TaskRepository taskRepository){
		return (args) ->{
//			taskRepository.save(new Task(1L,"nap",5,"High" ,"Chores","InProgress"));
//			taskRepository.save(new Task(2L,"kinap cat",5,"High" ,"Chores","InProgress"));
//			taskRepository.save(new Task(3L,"reply to the Nigerian prince",5,"High" ,"Chores","InProgress"));
//			taskRepository.save(new Task(4L,"save world",5,"High" ,"Chores","InProgress"));

			taskRepository.save(new Task("nap2",5,"High" ,"Chores","InProgress"));

			//			taskRepository.save(new Task("kinap cat2",5,"High" ,"Chores","InProgress"));
//			taskRepository.save(new Task("reply to the Nigerian prince2",5,"High" ,"Chores","InProgress"));
//			taskRepository.save(new Task("save world2",5,"High" ,"Chores","InProgress"));



			log.info("Tasks found with foundAll():");
			log.info("----------------------------");
			taskRepository.findAll().forEach(task -> {
				log.info(task.getName());
				log.info("--");
			});
			log.info("----------------------------");
		};

	}

}
