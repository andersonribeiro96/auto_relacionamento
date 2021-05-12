package com.dev.relacionamento.web.mapper;

import com.dev.relacionamento.domain.User;
import com.dev.relacionamento.web.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public static User dtoToEntity(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .nome(userDto.getNome()).build();
    }

    public static UserDto entityToDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .nome(user.getNome())
                .build();
    }

    public static List<User> listDtoToEntity(List<UserDto> userDtos) {

        List<User> users = new ArrayList<>();
        for (UserDto userDto : userDtos) {
            users.add(dtoToEntity(userDto));
        }
        return users;
    }

    public static List<UserDto> listEntityToDto(List<User> users){
        List<UserDto> userDtos = new ArrayList<>();
        for(User user : users){
            userDtos.add(entityToDto(user));
        }

        return userDtos;
    }

}
