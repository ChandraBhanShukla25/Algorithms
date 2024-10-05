package com.javapractice;

public class Person {
    int id;
    String name;

    Person(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int id(){
        return id;
    }
    public String name(){
        return name;
    }

    public int hashcode(){
        return id;
    }

    public String toString(){
        return id+" : " + name;
    }
}
