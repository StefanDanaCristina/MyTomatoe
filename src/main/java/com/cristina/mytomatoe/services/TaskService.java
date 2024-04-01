package com.cristina.mytomatoe.services;

import com.cristina.mytomatoe.domain.MyUser;
import com.cristina.mytomatoe.domain.Task;
import com.cristina.mytomatoe.domain.TaskStatus;

import java.util.List;

public interface TaskService {
    List<Task> findAll();
    Iterable<Task> findAllByCategoryNonNegotiables();
    Iterable<Task> findAllExceptCategoryNonNegotiables();
   // void updateTask(String name, int duration, String category, String priority, String status);

}
