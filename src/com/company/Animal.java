package com.company;
import java.util.*;

public abstract class  Animal {

    Scanner scan=new Scanner(System.in);
    String name;
   protected int cost;
   protected double health=1.00;
   protected Sex animalGender;
   protected int age; //How old is an animal
   protected boolean isAlive=true;  //If animal is alive
    protected final int maxAge; // Maximum age for animal



    //Enum to set gender
    enum Sex
    {

        MALE,
        FEMALE
    }





    //Constructor for every animal
    public Animal(String name, String sex, int maxAge)
    {
        this.name=name;
        animalGender=Sex.valueOf(sex.toUpperCase());
        this.maxAge=maxAge;
    }





    //return cost of an animal
    public int getCost()
    {
       return this.cost;
    }







}
