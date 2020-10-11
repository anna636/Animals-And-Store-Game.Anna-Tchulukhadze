package com.company.animals;
import java.util.*;

public abstract class  Animal {

    Scanner scan=new Scanner(System.in);
    public String name;
   public int cost;
   public double health=1.00;
   public Sex animalGender;
   public int age; //How old is an animal
   public final int maxAge; // Maximum age for animal
   public boolean isAlive=true;  //If animal is alive

    public final int vetCost; //Vet cost for animal
    public boolean isIll=false; //If animal is ill



    //Enum to set gender
   public enum Sex
    {

        MALE,
        FEMALE,

    }





    //Constructor for every animal
    public Animal(String name, String sex, int maxAge, int vetCost)
    {
        this.name=name;
        setEnumValue(sex);
        this.maxAge=maxAge;
        this.vetCost=vetCost;
    }





    //return cost of an animal
    public int getCost()
    {
       return this.cost;
    }



    //Set default value "female" if user input is incorrect
    private void setEnumValue(String sex1)
    {
        String defaultSex="female";
        if(sex1.toLowerCase().equals("male") ||sex1.toLowerCase().equals("female") )
        {
            animalGender=Sex.valueOf(sex1.toUpperCase());
        }
        else
        {
            animalGender=Sex.valueOf(defaultSex.toUpperCase());
        }

    }




}
