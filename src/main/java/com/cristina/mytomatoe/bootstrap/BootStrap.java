package com.cristina.mytomatoe.bootstrap;

import com.cristina.mytomatoe.MyTomatoeApplication;
import com.cristina.mytomatoe.domain.MyUser;
import com.cristina.mytomatoe.domain.Task;
import com.cristina.mytomatoe.repositories.MyUserRepository;
import com.cristina.mytomatoe.repositories.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrap implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(BootStrap.class);
    private final MyUserRepository myUserRepository;
    private final TaskRepository taskRepository;


    public BootStrap(MyUserRepository myUserRepository, TaskRepository taskRepository) {
        this.myUserRepository = myUserRepository;
        this.taskRepository = taskRepository;
    }



    @Override
    public void run(String... args) throws Exception {
        MyUser myUser = new MyUser();
        Task task1 = new Task("nap", 5, "High", "Chores", "InProgress", myUser);
        Task task2 = new Task("kinap cat", 5, "High", "Chores", "InProgress", myUser);
        Task task3 = new Task("reply to the Nigerian prince", 5, "High", "Chores", "InProgress", myUser);
        Task task4 = new Task("save world", 5, "High", "Chores", "InProgress", myUser);

        MyUser savedUser = myUserRepository.save(myUser);
        Task savedTask1 = taskRepository.save(task1);
        Task savedTask2 = taskRepository.save(task2);
        Task savedTask3 = taskRepository.save(task3);
        Task savedTask4 = taskRepository.save(task4);

        savedUser.getTasks().add(savedTask1);
        savedUser.getTasks().add(savedTask2);
        savedUser.getTasks().add(savedTask3);
        savedUser.getTasks().add(savedTask4);
        myUserRepository.save(savedUser);


        //userRepository.save(myUser);
        //taskRepository.save(new Task("nap2",5,"High" ,"Chores","InProgress"));

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

        log.info(String.valueOf(taskRepository.count()));
        log.info(String.valueOf(myUserRepository.count()));
//			log.info("Users found with foundAll():");
//			log.info("----------------------------");
//			userRepository.findAll().forEach(user -> {
//				log.info(user.getUsername());
//				user.getTasks().forEach(task->{log.info(task.getName());
//				log.info("-");
//				});
//				log.info("--");
//			});
//			log.info("----------------------------");
    }

}
