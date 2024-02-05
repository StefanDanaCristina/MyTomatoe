package com.cristina.mytomatoe.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    //One to many???
    @OneToMany
    List<Task> tasks;
}
