package com.mypoc.webfluxkafkareactivecassandrapoc.service.impl;

import com.mypoc.webfluxkafkareactivecassandrapoc.model.User;
import com.mypoc.webfluxkafkareactivecassandrapoc.repository.UserRepository;
import com.mypoc.webfluxkafkareactivecassandrapoc.service.KafkaService;
import com.mypoc.webfluxkafkareactivecassandrapoc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.ExecutionException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private KafkaService kafkaService;

    public Flux<User> getAllUsers() {
        Flux<User> users = userRepository.findAll();
        return users;
    }

    public Mono<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    public Mono<User> save(User user) throws ExecutionException, InterruptedException {
        kafkaService.sendDataToKafkaTopic(user);
        return userRepository.save(user);
    }

    public Flux<User> getUsersFilterByAge(int age) {
        return userRepository.findByAgeGreaterThan(age);
    }
}
