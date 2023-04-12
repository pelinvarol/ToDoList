package com.pelinvarol.todolist.mapper;

import com.pelinvarol.todolist.entity.ToDo;
import com.pelinvarol.todolist.entity.User;
import com.pelinvarol.todolist.model.dto.ToDoItemDto;
import com.pelinvarol.todolist.repository.UserRepository;
import com.pelinvarol.todolist.request.ToDoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ToDoMapper {
    private final UserRepository userRepository;

    public ToDoItemDto toDto(ToDo todo) {

        return ToDoItemDto.builder()
                .id(todo.getId())
                .toDoItem(todo.getToDoItem())
                .isCompleted(todo.isCompleted())
                .userId(todo.getUser().getId())
                .build();
    }

    public ToDo createToDo(User user, ToDoRequest toDoRequest) {
        return ToDo.builder()
                .toDoItem(toDoRequest.getToDoItem())
                .user(user)
                .build();
    }

}
