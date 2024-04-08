package com.cristina.mytomatoe.controllers;

import com.cristina.mytomatoe.domain.MyUser;
import com.cristina.mytomatoe.domain.Task;
import com.cristina.mytomatoe.domain.TaskStatus;
import com.cristina.mytomatoe.services.MyUserService;
import com.cristina.mytomatoe.services.TaskService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@Slf4j
@RequestMapping("/")
public class TaskController {

    private TaskService taskService;



    private MyUserService myUserService;

    @Autowired
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

   @Autowired
    public void setMyUserService(MyUserService myUserService) {
        this.myUserService = myUserService;
    }

    @RequestMapping("/home")
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

    @PostMapping("/submitEditedCurrentTask")
    public String editTask(Model model, HttpServletRequest request, @RequestParam("name") String name, @RequestParam("duration") String duration,
                           @RequestParam("category") String category,
                           @RequestParam("priority") String priority, @RequestParam("selectedValue") String taskStatus,
                           @RequestParam("taskID") Long taskID, @RequestParam("userID") String userID,
                           @RequestParam("username")String username){
        model.addAttribute("tasks", taskService.findAllExceptCategoryNonNegotiables());
        model.addAttribute("statusEnums", TaskStatus.values());
//        log.info("GET THE INPUT FROM USER: name=" + name+" duration: "+duration+ " category: "+category+" priority: "+priority +
//                " selectedValue: "+taskStatus+ " taskID: "+taskID + " userID: " + userID + " username: "+username);
        Optional<Task> taskOptional= taskService.findById(taskID);
        if(taskOptional.isPresent()){
            Task taskToBeEdited = taskOptional.get();
            if (name!= null && !name.isEmpty()){
                taskToBeEdited.setName(name);
            }
            if (duration!= null && !duration.isEmpty()){
                taskToBeEdited.setDuration(Integer.parseInt(duration));
            }
            if (category!= null && !category.isEmpty()){
                taskToBeEdited.setCategory(category);
            }
            if (priority!= null && !priority.isEmpty()){
                taskToBeEdited.setPriority(priority);
            }
            if (taskStatus!= null && !taskStatus.isEmpty()){
                taskToBeEdited.setStatus(TaskStatus.valueOf(taskStatus));
            }
            taskService.save(taskToBeEdited);
            return "redirect:" + "/home";

        }
        else return "TO DO ERROR HANDLING";

//        Task task1 = Task.builder()
//                .name(name)
//                .duration(Integer.parseInt(duration))
//                .category(category)
//                .priority(priority)
//                .status(TaskStatus.valueOf(taskStatus))
//                .user()
//                .build();
        //taskService.save(task1);
       // String referer = request.getHeader("Referer");

    }
    @PostMapping("/submitNewCurrentTask")
    public String addTask(Model model, HttpServletRequest request, @RequestParam("name") String name,
                           @RequestParam("duration") String duration, @RequestParam("category") String category,
                           @RequestParam("priority") String priority, @RequestParam("selectedValue") String taskStatus
//                          ,
//                           @RequestParam("taskID") Long taskID,
//                           @RequestParam("userID") String userID,
//                           @RequestParam("username")String username
    ){
        model.addAttribute("tasks", taskService.findAllExceptCategoryNonNegotiables());
        model.addAttribute("statusEnums", TaskStatus.values());
        //TO DO
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        // Get the username from the authentication object
//        String username = authentication.getName();
//
//        // Add the username to the model
//        model.addAttribute("username", username);

       Optional<MyUser> myUser = myUserService.findByUserName("Cris");//fetch the first user from db
       Task task1 = Task.builder()
                .name(name)
                .duration(Integer.parseInt(duration))
                .category(category)
                .priority(priority)
                .status(TaskStatus.valueOf(taskStatus))
                .user(myUser.get()) //HARCODED User; TO DO Authentication
                .build();
        taskService.save(task1);
        return "redirect:" + "/home";

    }
}
