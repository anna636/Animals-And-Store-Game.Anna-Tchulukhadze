package com.company;

public class Fish extends Animal {

    int cost=20;
    Seed allowedFood;



    public Fish(String name, String sex)
    {
        super(name, sex, 4);

    }



    @Override
    public int getCost() {
        return this.cost;
    }

}
