package com.cristina.mytomatoe.services;

import com.cristina.mytomatoe.domain.MyUser;
import com.cristina.mytomatoe.repositories.MyUserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class MyUserImpl implements MyUserService {
    private final MyUserRepository myUserRepository;

    public MyUserImpl(MyUserRepository myUserRepository) {
        this.myUserRepository = myUserRepository;
    }

    @Override
    public Optional<MyUser> findById(Long id) {
       return  myUserRepository.findById(id);
    }

    @Override
    public Optional<MyUser> findByUserName(String username) {
        return myUserRepository.findByUsername(username);
//        Optional<MyUser> myUserOptional = myUserRepository.findByUsername(username);
//        if (myUserOptional.isPresent()){
//            return myUserOptional.get();
//        }
//        return null;
    }
}
