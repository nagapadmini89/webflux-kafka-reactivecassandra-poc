package com.mypoc.webfluxkafkareactivecassandrapoc.service;

import com.mypoc.webfluxkafkareactivecassandrapoc.model.User;
import com.mypoc.webfluxkafkareactivecassandrapoc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Flux<User> getAllUsers() {
        Flux<User> users = userRepository.findAll();
        return users;
    }

    public Mono<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    public Mono<User> save(User user) {
        return userRepository.save(user);
    }

    public Flux<User> getUsersFilterByAge(int age) {
        return userRepository.findByAgeGreaterThan(age);
    }
}
