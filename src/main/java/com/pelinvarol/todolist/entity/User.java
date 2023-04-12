package com.pelinvarol.todolist.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid", nullable = false)
    private Long id;
    @Column(name = "name",nullable=false)
    private String name;
    @Column(name = "surname",nullable=false)
    private String surname;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "password",nullable = false)
    private String password;

    @OneToMany(mappedBy = "user")
    private List<ToDo> toDoList;

}
