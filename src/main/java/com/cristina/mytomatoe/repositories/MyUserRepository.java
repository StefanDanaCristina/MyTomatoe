package com.cristina.mytomatoe.repositories;

import com.cristina.mytomatoe.domain.MyUser;
import org.springframework.data.repository.CrudRepository;

public interface MyUserRepository extends CrudRepository<MyUser,Long> {

}
