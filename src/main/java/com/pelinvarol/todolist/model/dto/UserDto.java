package com.pelinvarol.todolist.model.dto;

import com.pelinvarol.todolist.entity.ToDo;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class UserDto {
    private long id;
    private String name;
    private String surname;
    private List<ToDo> todos;
}
