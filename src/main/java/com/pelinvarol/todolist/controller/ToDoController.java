package com.pelinvarol.todolist.controller;

import com.pelinvarol.todolist.entity.ToDo;
import com.pelinvarol.todolist.entity.User;
import com.pelinvarol.todolist.mapper.ToDoMapper;
import com.pelinvarol.todolist.model.dto.ToDoItemDto;
import com.pelinvarol.todolist.repository.ToDoRepository;
import com.pelinvarol.todolist.repository.UserRepository;
import com.pelinvarol.todolist.request.ToDoRequest;
import com.pelinvarol.todolist.service.ToDoService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.MDC;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/todos")
public class ToDoController {

    private final ToDoService toDoService;
    private final UserRepository userRepository;
    private final ToDoRepository toDoRepository;
    private final ToDoMapper toDoMapper;

    @GetMapping("/{id}")
    public ToDoItemDto getToDoItemById(@PathVariable Long id) {
        return toDoService.getToDoById(id);
    }

    @GetMapping("/users/{userId}")
    public List<ToDoItemDto> getToDoItemByUserId(@PathVariable Long userId) {
        return toDoService.getToDoItemsByUserId(userId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteToDoItem(@PathVariable Long id) {
        toDoService.deleteToDoItem(id);
        return ResponseEntity.ok("To-Do Item is deleted successfully!");
    }

    @PutMapping("/{id}")
    public ToDoItemDto updateToDoItem(@RequestBody ToDoItemDto toDoItemDto) {
        return toDoService.updateToDoItem(toDoItemDto);
    }

    @PostMapping("/create/users/{userId}")
    public ResponseEntity<String> createToDo(@PathVariable Long userId, @RequestBody ToDoRequest toDoRequest) throws  Exception {
        toDoService.createToDo(userId, toDoRequest);
        return ResponseEntity.ok("To do is added successfully!");

    }
}
