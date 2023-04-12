package com.pelinvarol.todolist.repository;

import com.pelinvarol.todolist.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {

    List<ToDo> findByUserId(Long userId);


}
