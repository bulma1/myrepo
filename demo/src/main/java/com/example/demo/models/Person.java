package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "Person")
public class Person {
    // primary key
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO) //auto-increment
    private Long id;
    //validate = constraint
    @Column(nullable = false,unique = true,length = 300)
    // allowed variables can't null 
    private String name;
    private int age;

    public Person(  Long id,String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public Person(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

