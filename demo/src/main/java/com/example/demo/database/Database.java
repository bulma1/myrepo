package com.example.demo.database;


import com.example.demo.models.Person;
import com.example.demo.repository.PersonRepository;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.slf4j.Logger;

@Configuration
public class Database {
    //logger
    private static final Logger logger = LoggerFactory.getLogger(Database.class);
    @Bean
    CommandLineRunner initDatabase(PersonRepository personRepository){


        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                //Person person1 = new Person(1L,"bo",20);
                //Person person2 = new Person(2L,"ben",24);
                //logger.info("Insert data: "+personRepository.save(person1));
                //logger.info("Insert data: "+personRepository.save(person2));




            }
        };
    }
}
