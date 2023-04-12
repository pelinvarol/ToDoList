package com.pelinvarol.todolist.mapper;

import com.pelinvarol.todolist.entity.User;
import com.pelinvarol.todolist.model.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserMapper {

    public UserDto toDto(User user) {

        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .todos(user.getToDoList())
                .build();
    }

    public List<UserDto> listToDto(List<User> users){
        return users.stream().map(this::toDto).collect(Collectors.toList());
    }
}
