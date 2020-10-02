package com.company;
import java.util.*;

public class Player {

    String name;
    String lastName;

    int money=200 ;


    //Two array lists for animals and food that player stores
    ArrayList<Animal> animals=new ArrayList<>();
    HashMap<Food, Integer> foodForAnimals=new HashMap<>();


    //Constructor to set field variables

    public Player(String name, String lastName)
    {
        this.name=name;
        this.lastName=lastName;

    }

    // writing all resources the the player has: money, animals and food
    public void seeRsourcesOfPlayer()
    {



        if (money==0)
        {
            System.out.println("You have no money!");
        }
        else {
            System.out.println("Your money: " + money + "$\n");
        }

        //animals
        System.out.println("Your animals:");
        if (animals.size()==0)
        {
            System.out.println("You have no animals yet\n");
        }
        else {

            for (Animal animal : animals) {
                System.out.print(animal.name + " ("+animal.getClass().getSimpleName()+")");

            }
        }

        //food
        System.out.println("Your food:");

        //if kg of any type of food equals 0, remove this type of food from list
        for (Food food:foodForAnimals.keySet()) {
           if(foodForAnimals.get(food)==0 )
           {
               foodForAnimals.remove(food, foodForAnimals.get(food));
           }
        }

        //if size of list for food for animals is zero, player doesn't have any types of food yet
        if (foodForAnimals.size()==0)
        {
            System.out.println("You have no food for animals yet\n");
        }

        //otherwise print how many kg of what kind of food the player has
        else {

            for (Food food:foodForAnimals.keySet()) {
                System.out.println(foodForAnimals.get(food)+ "kg of "+food.getClass().getSimpleName() );
            }
        }





    }
}
