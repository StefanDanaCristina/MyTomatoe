package com.cristina.mytomatoe.domain;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int duration;
    private String priority; //enum
    private String category; //enum
    private String status; //enum

    @OneToOne
    private MyUser user;

    public Task( String name, int duration, String priority, String category, String status) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.priority = priority;
        this.category = category;
        this.status = status;
    }

    protected Task() { //used by JPA
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public String getPriority() {
        return priority;
    }

    public String getCategory() {
        return category;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                ", priority='" + priority + '\'' +
                ", category='" + category + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
