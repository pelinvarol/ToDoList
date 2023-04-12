package com.pelinvarol.todolist.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ToDoRequest {
    private String toDoItem;
}
