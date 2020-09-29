package com.company;

public abstract class  Animal {

    String name;
    Food food;
    int health=100;

    enum Sex{

        MALE,
        FEMALE
    }



    public void eat(Food food)
    {
        this.food=food;
        if(health<=90)
        {
            health+=10;
            System.out.println(name + " has eaten " + this.food.getClass().getSimpleName());
        }
        else{


            return;

        }

    }
}
