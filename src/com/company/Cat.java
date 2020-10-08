package com.company;

public class Cat extends Animal{

    int cost=100;






    public Cat(String name, String sex)
    {
        super(name, sex, 9);

    }



    @Override
    public int getCost() {
        return this.cost;
    }


}
