package com.company;

public class Hamster extends Animal{


    int cost=25;



    public Hamster(String name, String sex)
    {
        super(name, sex, 8);

    }








    @Override
    public int getCost() {
        return this.cost;
    }
}
