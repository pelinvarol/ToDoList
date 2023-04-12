package com.pelinvarol.todolist.model.dto;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ToDoItemDto {
    private Long id;
    private String toDoItem;
    private boolean isCompleted;
    private Long userId;
}
