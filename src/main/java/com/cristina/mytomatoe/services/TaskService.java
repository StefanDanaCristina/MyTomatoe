package com.cristina.mytomatoe.services;

import com.cristina.mytomatoe.domain.Task;

import java.util.List;

public interface TaskService {
    List<Task> findAll();
    Iterable<Task> findAllByCategoryNonNegotiables();
    Iterable<Task> findAllExceptCategoryNonNegotiables();

}
