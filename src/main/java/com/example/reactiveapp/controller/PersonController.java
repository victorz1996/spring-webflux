package com.example.reactiveapp.controller;

import com.example.reactiveapp.model.Person;
import com.example.reactiveapp.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/person")
@AllArgsConstructor
public class PersonController {
    private static final Logger log = LoggerFactory.getLogger(PersonController.class);

    private final PersonRepository personRepository;

    @GetMapping
    public Flux<Person> list(){
        return personRepository.list();
    }

    @GetMapping("/{id}")
    public Mono<Person> listById(@PathVariable("id") Integer id){
        return personRepository.listById(id);
    }

    @PostMapping
    public Mono<Person> create(@RequestBody Person person){
        return personRepository.register(person);
    }

    @PutMapping
    public Mono<Person> update(@RequestBody Person person){
        return personRepository.update(person);
    }

    @DeleteMapping ("/{id}")
    public Mono<Void> delete(@PathVariable("id") Integer id){
        return personRepository.listById(id)
                .flatMap(p -> personRepository.delete(p.getId()));
    }

}
