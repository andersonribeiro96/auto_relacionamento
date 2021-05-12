package com.dev.relacionamento.web.rest;

import com.dev.relacionamento.domain.User;
import com.dev.relacionamento.service.UserService;
import com.dev.relacionamento.web.dto.UserDto;
import com.dev.relacionamento.web.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResouce {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll(){
        List<User> users = userService.findAll();
        return ResponseEntity.ok(UserMapper.listEntityToDto(users));
    }

    @GetMapping(value = "/{idOwner}/followers/{idFollow}")
    public ResponseEntity<UserDto> followUsers(@PathVariable Long idOwner, @PathVariable Long idFollow){
        User user = userService.followUsers(idOwner, idFollow);
        return ResponseEntity.ok(UserMapper.entityToDto(user));
    }

    @GetMapping(value = "/{id}/followers")
    public ResponseEntity<List<UserDto>> myFollowers(@PathVariable Long id){
        List<User> users = userService.myFollowers(id);
        return ResponseEntity.ok(UserMapper.listEntityToDto(users));
    }

    @GetMapping(value = "/{id}/following")
    public ResponseEntity<List<UserDto>> whoIFollow(@PathVariable Long id){
        List<User> users = userService.whoIFollow(id);
        return ResponseEntity.ok(UserMapper.listEntityToDto(users));
    }



}
