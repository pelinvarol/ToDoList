package com.pelinvarol.todolist.service;

import com.pelinvarol.todolist.entity.ToDo;
import com.pelinvarol.todolist.entity.User;
import com.pelinvarol.todolist.mapper.ToDoMapper;
import com.pelinvarol.todolist.model.dto.ToDoItemDto;
import com.pelinvarol.todolist.model.dto.UserDto;
import com.pelinvarol.todolist.repository.ToDoRepository;
import com.pelinvarol.todolist.repository.UserRepository;
import com.pelinvarol.todolist.request.ToDoRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ToDoService {

    private final ToDoRepository toDoRepository;
    private final UserRepository userRepository;
    private final ToDoMapper toDoMapper;

    public ToDoItemDto getToDoById(Long id) {
        ToDo toDo = toDoRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("ToDoItem not found with id: " + id));
        return toDoMapper.toDto(toDo);
    }

    public List<ToDoItemDto> getToDoItemsByUserId(Long userId) {
        List<ToDo> toDoList = toDoRepository.findByUserId(userId);
        return toDoList.stream()
                .map(toDoMapper::toDto)
                .collect(Collectors.toList());
    }

    public void deleteToDoItem(Long id) {
        ToDo toDo = toDoRepository.findById(id).orElseThrow();
        toDoRepository.delete(toDo);
    }

    public ToDoItemDto updateToDoItem(ToDoItemDto toDoItemDto) {
        ToDo toDo = toDoRepository.findById(toDoItemDto.getId()).orElseThrow(()
                -> new EntityNotFoundException("To-Do not found by id: " + toDoItemDto.getId()));
        toDo.setToDoItem(toDoItemDto.getToDoItem());
        toDo.setCompleted(toDoItemDto.isCompleted());
        ToDo newToDo = toDoRepository.save(toDo);
        return toDoMapper.toDto(newToDo);
    }


    public void createToDo(Long userId, ToDoRequest toDoRequest) throws Exception {
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found"));
        toDoRepository.save(toDoMapper.createToDo(user, toDoRequest));
    }



}
