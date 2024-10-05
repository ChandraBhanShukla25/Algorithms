package com.javapractice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        Person person1 = new Person(101,"Chandra");
        Person person2 = new Person(102,"Ankit");
        Person person3 = new Person(103,"Modi");

        List<Person> personList = Arrays.asList(person1,person2,person3);
        Comparator<Person> byName = Comparator.comparing(Person::name);
        System.out.println(personList);
        personList.sort(byName);
        System.out.println(personList);
    }


}
