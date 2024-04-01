package com.cristina.mytomatoe.controllers;

import com.cristina.mytomatoe.domain.MyUser;
import com.cristina.mytomatoe.domain.Task;
import com.cristina.mytomatoe.domain.TaskStatus;
import com.cristina.mytomatoe.services.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class TaskController {

    private TaskService taskService;
    @Autowired
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping("/")
    public String getIndex(Model model){
        model.addAttribute("tasks", taskService.findAllExceptCategoryNonNegotiables());
        model.addAttribute("statusEnums", TaskStatus.values());
        log.info("HOOOOOOOOMMMEEEEE");
        return "home";
    }
    @RequestMapping("/dailyNonNegotiables")
    public String getDailyNonNegotiables(Model model){
        model.addAttribute("tasks", taskService.findAllByCategoryNonNegotiables());
        model.addAttribute("statusEnums", TaskStatus.values());
        return "dropDown";
    }

    @PostMapping("/submitMyCurrentTasks")
    public String editTask(Model model, @RequestParam("name") String name, @RequestParam("duration") String duration, @RequestParam("category") String category,
                           @RequestParam("priority") String priority, @RequestParam("selectedValue") String selectedValue,
                           @RequestParam("taskID") String taskID, @RequestParam("userID") String userID){
        model.addAttribute("tasks", taskService.findAllExceptCategoryNonNegotiables());
        model.addAttribute("statusEnums", TaskStatus.values());
        log.info("GET THE INPUT FROM USER: name=" + name+" duration: "+duration+ " category: "+category+" priority: "+priority +
                " selectedValue: "+selectedValue+ " taskID: "+taskID + " userID: " + userID );
        /*yUser user =  taskService.findAllByUserId(userID)
        Task task1 = Task.builder()
                .name(name)
                .duration(duration)
                .priority(priority)
                .category(category)
                .status(status)
                .user(taskService.findAllByUserId(userID))
                .frequency("None")
                .build();

         */
        return "redirect:/home";
    }
}
