package com.company;
import java.util.*;

public abstract class  Animal {

    Scanner scan=new Scanner(System.in);
    String name;
   protected int cost=0;
   protected double health=1.00;
   protected Sex animalGender;
   protected boolean isAlive=true;  //if animal is alive



    //Enum to set gender
    enum Sex
    {

        MALE,
        FEMALE
    }





    //Constructor for every animal
    public Animal(String name, String sex)
    {
        this.name=name;
        animalGender=Sex.valueOf(sex.toUpperCase());
    }





    //return cost of an animal
    public int getCost()
    {
       return this.cost;
    }







}
