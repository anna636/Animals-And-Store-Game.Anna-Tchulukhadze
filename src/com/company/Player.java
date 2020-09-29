package com.company;
import java.util.*;

public class Player {

    String name;
    String lastName;
    int age;
    int money=1100;


    //Two array lists for animals and food that player stores
    ArrayList<Animal> animals=new ArrayList<>();
    ArrayList<Food> foodForAnimals=new ArrayList<>();


    //Constructor to set field variables

    public Player(String name, String lastName, int age)
    {
        this.name=name;
        this.lastName=lastName;
        this.age=age;
    }
}
