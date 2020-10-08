package com.company;

public class Budgie extends Animal{

    int cost=50;




    public Budgie(String name, String sex)
    {
        super(name, sex, 8);

    }


    @Override
    public int getCost() {
        return this.cost;
    }


}
