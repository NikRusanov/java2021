package com.rusanov;

public class Person implements Comparable<Person>{

    private String name;
    private String surname;
    private int age;

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person person) {
        int compareResult = this.name.compareTo(person.getSurname());
        if (compareResult == 0) {
            compareResult = this.surname.compareTo(person.getName());
        }
        return compareResult;
    }
}

