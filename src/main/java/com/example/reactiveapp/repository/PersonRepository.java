package com.example.reactiveapp.repository;

import com.example.reactiveapp.model.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonRepository {
    Mono<Person> register(Person person);
    Mono<Person> update(Person person);

    Flux<Person> list();
    Mono<Person> listById(Integer id);
    Mono<Void> delete(Integer id);
}
