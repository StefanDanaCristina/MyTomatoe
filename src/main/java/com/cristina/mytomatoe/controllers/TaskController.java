package com.cristina.mytomatoe.controllers;

import com.cristina.mytomatoe.domain.TaskStatus;
import com.cristina.mytomatoe.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TaskController {

    private TaskService taskService;
    @Autowired
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping("/")
    public String getIndex(Model model){
        model.addAttribute("tasks", taskService.findAllExceptCategoryNonNegotiables());
        return "home";
    }
    @RequestMapping("/dailyNonNegotiables")
    public String getDailyNonNegotiables(Model model){
        model.addAttribute("tasks", taskService.findAllByCategoryNonNegotiables());
        model.addAttribute("statusEnums", TaskStatus.values());
        return "dropDown";
    }
}
