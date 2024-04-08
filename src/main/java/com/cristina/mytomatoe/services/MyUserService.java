package com.cristina.mytomatoe.services;

import com.cristina.mytomatoe.domain.MyUser;

import java.util.Optional;

public interface MyUserService {
    Optional<MyUser> findById(Long id);
    Optional<MyUser> findByUserName(String username);
}
