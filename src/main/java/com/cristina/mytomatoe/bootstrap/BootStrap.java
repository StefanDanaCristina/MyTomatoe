package com.cristina.mytomatoe.bootstrap;

import com.cristina.mytomatoe.MyTomatoeApplication;
import com.cristina.mytomatoe.domain.MyUser;
import com.cristina.mytomatoe.domain.Task;
import com.cristina.mytomatoe.domain.TaskStatus;
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
        MyUser savedUser = myUserRepository.save(myUser);

        Task task1 = Task.builder()
                    .name("nap")
                    .duration(5)
                    .priority("High")
                    .category("Chores")
                    .status(TaskStatus.DONE)
                    .user(myUser)
                    .frequency("None")
                .build();

        Task task2 = Task.builder()
                .name("kinap cat")
                .duration(5)
                .priority("High")
                .category("Chores")
                .status(TaskStatus.NOT_STARTED)
                .user(myUser)
                .frequency("None")
                .build();

        Task task3 = Task.builder()
                .name("reply to the Nigerian prince")
                .duration(5)
                .priority("High")
                .category("Chores")
                .status(TaskStatus.IN_PROGRESS)
                .user(myUser)
                .frequency("None")
                .build();

        Task task4 = Task.builder()
                .name("save world")
                .duration(5)
                .priority("High")
                .category("Chores")
                .status(TaskStatus.IN_PROGRESS)
                .user(myUser)
                .frequency("None")
                .build();

        //MyUser savedUser = myUserRepository.save(myUser);
        Task savedTask1 = taskRepository.save(task1);
        Task savedTask2 = taskRepository.save(task2);
        Task savedTask3 = taskRepository.save(task3);
        Task savedTask4 = taskRepository.save(task4);

        savedUser.getTasks().add(savedTask1);
        savedUser.getTasks().add(savedTask2);
        savedUser.getTasks().add(savedTask3);
        savedUser.getTasks().add(savedTask4);


        Task task5 = Task.builder()
                    .name("NonNegotiables1")
                    .duration(5)
                    .priority("High")
                    .category("NonNegotiables")
                    .status(TaskStatus.IN_PROGRESS)
                    .user(myUser)
                    .frequency("Daily")
                .build();

        Task task6 = Task.builder()
                .name("NonNegotiables2")
                .duration(5)
                .priority("High")
                .category("NonNegotiables")
                .status(TaskStatus.DONE)
                .user(myUser)
                .frequency("Monthly")
                .build();

        Task task7 = Task.builder()
                .name("NonNegotiables3")
                .duration(5)
                .priority("High")
                .category("NonNegotiables")
                .status(TaskStatus.NOT_STARTED)
                .user(myUser)
                .frequency("Yearly")
                .build();

        Task task8 = Task.builder()
                .name("NonNegotiables4")
                .duration(5)
                .priority("High")
                .category("NonNegotiables")
                .status(TaskStatus.IN_PROGRESS)
                .user(myUser)
                .frequency("Daily")
                .build();

        //MyUser savedUser = myUserRepository.save(myUser);
        Task savedTask5 = taskRepository.save(task5);
        Task savedTask6 = taskRepository.save(task6);
        Task savedTask7 = taskRepository.save(task7);
        Task savedTask8 = taskRepository.save(task8);

        savedUser.getTasks().add(savedTask5);
        savedUser.getTasks().add(savedTask6);
        savedUser.getTasks().add(savedTask7);
        savedUser.getTasks().add(savedTask8);

        myUserRepository.save(savedUser);


        //userRepository.save(myUser);
        //taskRepository.save(new Task("nap2",5,"High" ,"Chores",TaskStatus.IN_PROGRESS));

        //			taskRepository.save(new Task("kinap cat2",5,"High" ,"Chores",TaskStatus.IN_PROGRESS));
//			taskRepository.save(new Task("reply to the Nigerian prince2",5,"High" ,"Chores",TaskStatus.IN_PROGRESS));
//			taskRepository.save(new Task("save world2",5,"High" ,"Chores",TaskStatus.IN_PROGRESS));


        log.info("Tasks found with foundAll():");
        log.info("----------------------------");
        taskRepository.findAll().forEach(task -> {
            log.info(task.getName());
            log.info("--");
        });
        log.info("----------------------------");

        log.info(String.valueOf(taskRepository.count()));
        log.info(String.valueOf(myUserRepository.count()));
    }

}
