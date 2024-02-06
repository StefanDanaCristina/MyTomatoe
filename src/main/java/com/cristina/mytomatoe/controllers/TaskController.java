package com.cristina.mytomatoe.controllers;

import com.cristina.mytomatoe.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TaskController {

    private TaskRepository taskRepository;

    @Autowired
    public void setTaskRepository(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @RequestMapping("/")
    public String getIndex(Model model){
        model.addAttribute("tasks",taskRepository.findAll());
        return "index";
    }
}
