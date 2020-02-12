package com.mypoc.webfluxkafkareactivecassandrapoc.service;

import com.mypoc.webfluxkafkareactivecassandrapoc.model.User;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.ExecutionException;

@Component
public interface UserService {

    public Flux<User> getAllUsers();

    public Mono<User> getUserById(int id);

    public Mono<User> save(User user) throws ExecutionException, InterruptedException ;

    public Flux<User> getUsersFilterByAge(int age);
}
