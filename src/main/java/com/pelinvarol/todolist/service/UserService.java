package com.pelinvarol.todolist.service;

import com.pelinvarol.todolist.entity.User;
import com.pelinvarol.todolist.mapper.UserMapper;
import com.pelinvarol.todolist.model.dto.UserDto;
import com.pelinvarol.todolist.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<UserDto> getAllUsers() {
        return userMapper.listToDto(userRepository.findAll());
    }

    public UserDto getUserById(Long id) {
        return userMapper.toDto(userRepository.findById(id).orElseThrow());
    }

    public void deleteUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        userRepository.delete(user);
    }

    public Optional<User> loadUserByUsername(String username) throws UsernameNotFoundException {
        return findByEmail(username);
    }

}
