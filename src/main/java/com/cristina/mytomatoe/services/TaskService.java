package com.cristina.mytomatoe.services;

import com.cristina.mytomatoe.domain.MyUser;
import com.cristina.mytomatoe.domain.Task;
import com.cristina.mytomatoe.domain.TaskStatus;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Task> findAll();
    Iterable<Task> findAllByCategoryNonNegotiables();
    Iterable<Task> findAllExceptCategoryNonNegotiables();

    Iterable<Task> findByUserName(String myUser);

    Task save(Task task);

    Optional<Task> findById(Long id);

   // void updateTask(String name, int duration, String category, String priority, String status);

}
