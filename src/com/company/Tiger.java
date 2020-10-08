package com.company;

public class Tiger extends Animal{

    int cost=900;







    public Tiger(String name, String sex)
    {

        super(name, sex , 10);

    }



    @Override
    public int getCost() {
        return this.cost;
    }


}
