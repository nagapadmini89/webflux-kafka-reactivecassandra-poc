package com.mypoc.webfluxkafkareactivecassandrapoc.repository;

import com.mypoc.webfluxkafkareactivecassandrapoc.model.User;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import reactor.core.publisher.Flux;

public interface UserRepository extends ReactiveCassandraRepository<User, Integer> {

    Flux<User> findByAgeGreaterThan(int age);
}
