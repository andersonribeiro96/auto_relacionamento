package com.dev.relacionamento.service;

import com.dev.relacionamento.domain.User;
import com.dev.relacionamento.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User followUsers(Long idUser, Long idFollow){
        User owner = seacherUser(idUser);
        User follow = seacherUser(idFollow);
        owner.followUsers(follow);
       return userRepository.save(owner);
    }


    public List<User> myFollowers(Long id){
        User user = seacherUser(id);
        return new ArrayList<>(user.getFollowers());
    }

    public List<User> whoIFollow(Long id){
        User user = seacherUser(id);
        return new ArrayList<>(user.getFollowing());
    }


    public User seacherUser(Long id){
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }





}
