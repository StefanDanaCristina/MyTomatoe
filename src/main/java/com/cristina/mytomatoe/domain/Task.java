package com.cristina.mytomatoe.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.UUID;

@Setter
@Getter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String name;

    private int duration;

    @NonNull
    private String priority; //enum

    @NonNull
    private String category; //enum

    @NonNull
    private String status; //enum

    @ManyToOne
    //@JoinColumn(name="user_id", nullable=false) //specifies the FK column in task Table
    @JoinTable(name = "task_user", joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private MyUser user;

    private String frequency; //enum

    public Task(@NonNull String name, int duration, @NonNull String priority, @NonNull String category, @NonNull String status, MyUser user, String frequency) {
        this.name = name;
        this.duration = duration;
        this.priority = priority;
        this.category = category;
        this.status = status;
        this.user = user;
        this.frequency = frequency;
    }

/*    public Task(String name, int duration, String priority, String category, String status, MyUser user, String frequency) {
        //this.name = name;
        this.duration = duration;
        this.priority = priority;
        this.category = category;
        this.status = status;
        this.user = user;
        this.frequency = frequency;
    }*/
}
