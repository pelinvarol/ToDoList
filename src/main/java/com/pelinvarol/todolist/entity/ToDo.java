package com.pelinvarol.todolist.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="todos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "to_do_id", nullable = false)
    private Long id;
    @Column(name="to_do_item",nullable=false)
    private String toDoItem;
    @Column(name="is_completed",nullable=false)
    private boolean isCompleted = false;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="user_id",referencedColumnName="userid")
    private User user;


}
