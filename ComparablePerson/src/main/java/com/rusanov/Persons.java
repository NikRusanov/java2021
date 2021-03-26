package com.rusanov;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Persons {
    List<Person> persons;

    public Persons(List<Person> persons) {
        if(persons == null) throw  new IllegalArgumentException();
        this.persons = persons;
    }


    public List<Person> getPersonsSortByName() {
        return persons
                .stream()
                .sorted(Comparator.comparing(Person::getName))
                .collect(Collectors.toList());
    }

    public List<Person> getPersonsSortBySurname() {
        return persons
                .stream()
                .sorted(Comparator.comparing(Person::getSurname))
                .collect(Collectors.toList());
    }


    public List<Person> getPersonsSortByAge() {
        return persons.stream()
                .sorted(Comparator.comparingInt(Person::getAge))
                .collect(Collectors.toList());
    }


    public List<Person> getPersons() {
        return persons;
    }

}
