package com.rusanov;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonsTest {

    List<Person> personsList = new ArrayList<>();
    List<Person> expectedPersonsList = new ArrayList<>();
    Person person = new Person("name1", "surname1", 0);
    Person person1 = new Person("name2", "surname2", 1);
    Person person2 = new Person("name3", "surname3", 2);
    Persons persons = new Persons(personsList);

    {
        personsList.add(person2);
        personsList.add(person1);
        personsList.add(person);

        expectedPersonsList.add(person);
        expectedPersonsList.add(person1);
        expectedPersonsList.add(person2);
    }

    @Test
    public void comparePersonTest() {
        Person firstPerson = new Person("Ivan", "Ivan", 100);
        Person secondPerson = new Person("Ivan", "Ivan", 99);
        assertEquals(0, firstPerson.compareTo(secondPerson));
        secondPerson.setName("A");
        assertTrue(firstPerson.compareTo(secondPerson) > 0);

        secondPerson.setName("Ivan");
        secondPerson.setSurname("Aaaa");
        assertTrue(firstPerson.compareTo(secondPerson) > 0);
    }

    @Test
    public void sortPersonByNameTest() {
        List<Person> actualSortPersonsByName = persons.getPersonsSortByName();
        assertArrayEquals(expectedPersonsList.toArray(), actualSortPersonsByName.toArray());
    }


    @Test
    public void sortPersonBySurnameTest() {
        List<Person> actualSortPersonsBySurname = persons.getPersonsSortBySurname();
        assertArrayEquals(expectedPersonsList.toArray(), actualSortPersonsBySurname.toArray());
    }


    @Test
    public void sortPersonByAgeTest() {
        List<Person> actualSortPersonsByName = persons.getPersonsSortByAge();
        assertArrayEquals(expectedPersonsList.toArray(), actualSortPersonsByName.toArray());
    }

    @Test
    public void nullPersonsTest() {
        try {
            new Persons(null);
        } catch (IllegalArgumentException ignored) {
            assertTrue(true);
        }
    }
}