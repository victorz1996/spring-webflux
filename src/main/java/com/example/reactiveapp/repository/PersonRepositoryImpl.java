package com.example.reactiveapp.repository;

import com.example.reactiveapp.controller.PersonController;
import com.example.reactiveapp.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepositoryImpl implements PersonRepository{

    private static final Logger log = LoggerFactory.getLogger(PersonRepositoryImpl.class);

    @Override
    public Mono<Person> register(Person person) {
        log.info(person.toString());
        return Mono.just(person);
    }

    @Override
    public Mono<Person> update(Person person) {
        log.info(person.toString());
        return Mono.just(person);
    }

    @Override
    public Flux<Person> list() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1,"Victor"));
        persons.add(new Person(2,"Manuel"));
        persons.add(new Person(3,"Carlos"));

        return Flux.fromIterable(persons);
    }

    @Override
    public Mono<Person> listById(Integer id) {
        return Mono.just(new Person(id, "Nuevo"));
    }

    @Override
    public Mono<Void> delete(Integer id) {
        return Mono.empty();
    }
}
