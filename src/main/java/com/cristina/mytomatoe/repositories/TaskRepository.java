package com.cristina.mytomatoe.repositories;

import com.cristina.mytomatoe.domain.MyUser;
import com.cristina.mytomatoe.domain.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

//No need for a implementation of this interface.
// Spring Data JPA creates an implementation when you run the application
//And generated queries based on the methods declared below! Nice!
public interface TaskRepository extends CrudRepository<Task, Long> {
    List<String> findByName(String name);
    Iterable<Task> findByCategory(String category);

    Iterable<Task> findByUser(MyUser user);




}
