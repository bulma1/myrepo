package com.example.demo.controller;

import com.example.demo.models.Person;
import com.example.demo.models.ResponseObject;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/Persons")

public class PersonController {
    @GetMapping("")
        //http://localhost:9090/api/v1/Persons
    List<Person>  getAllPersons(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable Long id){
        Optional<Person> foundPerson = repository.findById(id);
        return foundPerson.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("OK","Query person successfully !!",foundPerson)
                ):
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("Failed","Cannot find person with id ="+id,"")
                );
    }
    @Autowired
    private PersonRepository repository;
    //INSERT NEW VALUES
    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertPerson(@RequestBody Person newPerson){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Okayyy","Insert person successfully",repository.save(newPerson))
        );
    }
    //UPDATE
    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updatePerson(@RequestBody Person newPerson , @PathVariable Long id){
        Person updatePerson =  repository.findById(id)
                .map(person -> {
                    person.setAge(newPerson.getAge());
                    person.setName(newPerson.getName());
                    return repository.save(person);
                }).orElseGet(()->{
                    newPerson.setId(id);
                    return repository.save(newPerson);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Ok la","Update person successfullyy",updatePerson)
        );
    }
    //DELETE
    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> deletePerson(@PathVariable Long id){
        boolean exists = repository.existsById(id);
        if(exists){
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("OK","Delete successfully !!","")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failedddd !! ","Cannot find person to delete","")
        );
    }





}
