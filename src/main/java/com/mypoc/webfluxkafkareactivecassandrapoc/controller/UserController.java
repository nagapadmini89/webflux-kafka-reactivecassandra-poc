package com.mypoc.webfluxkafkareactivecassandrapoc.controller;


import com.mypoc.webfluxkafkareactivecassandrapoc.model.User;
import com.mypoc.webfluxkafkareactivecassandrapoc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/list")
    public Flux<User> getAllUsers() {
        Flux<User> employees = userService.getAllUsers();
        return employees;
    }

    @GetMapping("/{id}")
    public Mono<User> getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public Mono<User> addUser(@RequestBody User user) {
        Mono<User> savedData = userService.save(user);
        return savedData;
    }

    @GetMapping("/filterByAge/{age}")
    public Flux<User> getUserFilterByAge(@PathVariable int age) {
        return userService.getUsersFilterByAge(age);
    }
}
