package com.cristina.mytomatoe.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;



    String username;

    //One to many???
    @OneToMany(mappedBy = "user")
    Set<Task> tasks = new HashSet<>();;

    public Long getId() {
        return id;
    }
    public Set<Task> getTasks() {
        return tasks;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

}
