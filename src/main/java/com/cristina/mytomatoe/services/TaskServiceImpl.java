package com.cristina.mytomatoe.services;

import com.cristina.mytomatoe.domain.Task;
import com.cristina.mytomatoe.domain.TaskStatus;
import com.cristina.mytomatoe.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> findAll() {
        List<Task> list = new ArrayList<>();
        Iterable<Task> iterable = taskRepository.findAll();
        for (Task task: iterable )
             list.add(task);
        return list;
    }

    @Override
    public Iterable<Task> findAllByCategoryNonNegotiables() {
        return taskRepository.findByCategory("NonNegotiables");
    }

    @Override
    public List<Task> findAllExceptCategoryNonNegotiables() {
        List<Task> list = new ArrayList<>();
        Iterable<Task> iterable = taskRepository.findAll();
        for (Task task: taskRepository.findAll() )
            if (task.getCategory()!="NonNegotiables") list.add(task);
        return list;
    }

}
