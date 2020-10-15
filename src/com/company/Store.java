package com.company;

import com.company.animals.*;
import com.company.food.*;
import java.util.*;

import static com.company.dialogs.Dialogs.*;

public class Store {

    Scanner scan=new Scanner(System.in);



    String input="+";
    //Two lists for available type of foods and animals that player can buy

    ArrayList<Food> foodTypes=new ArrayList<>(Arrays.asList(new Seed(), new Meat(), new Catfood()));
    ArrayList<Animal> animalTypes=new ArrayList<>(Arrays.asList(new Cat("", "male"), new Tiger("","male"),
                                                                      new Budgie("", "male"),
                                                                      new Fish("", "male"),
                                                                      new Hamster("", "male")));






       //Method to buy food
    public void buyFood(Player player) {


    System.out.println("What kind of food do you want to buy? Price per kg is:\nSeed - 5$,  Catfood- 3$, Meat - 6$,"+
                "\nWrite one food at a time or write word 'end'  after you bought what you wanted if you don't want to buy more food");

    input=prompt(" ");

        //As long as player doesn't write end: if player has not enough money he will not be able to buy food
        //If player has enough money and input name matches food class name, player can buy food and his money will decrease

    while(!input.equals("end")) {

    for (Food food : foodTypes)
     {




     if (player.money<food.getCost())

     {
          System.out.println("You don't have enough money!");
          break;

      }


      else if (input.toLowerCase().equals(food.getClass().getSimpleName().toLowerCase()))

      {

          int amountOfFood=promptInt("How many kilograms do you want to buy?", 1, (int)Math.round(player.money/food.getCost()));

      if(player.foodForAnimals.containsKey(food))

     {
        int keyValue= player.foodForAnimals.get(food);
        keyValue+=amountOfFood;
        player.foodForAnimals.put(food, keyValue);
         player.money -= food.getCost()*amountOfFood;
         System.out.println("Bought " +amountOfFood+"kg of "+food.getClass().getSimpleName());
         System.out.println("Money left: "+player.money +"$");
     }


     else {


         player.foodForAnimals.put(food, amountOfFood);
         player.money -= food.getCost()*amountOfFood;
         System.out.println("Bought " +amountOfFood+"kg of "+food.getClass().getSimpleName());
          System.out.println("Money left "+player.money+"$");

     }
          }
      }

      input = prompt("Want to buy more? Write what food you want to buy or type 'end' to stop");
        }


    }




    //Method to buy animals

    public void buyAnimal(Player player)
    {
        System.out.println("What kind of animals do you want to buy?\nHamster - 25$(max age: 8 years),  Fish - 20$(max age: 4 years), " +
                "Cat - 100$(max age: 9 years), Tiger - 900$(max age: 10 years), Budgie - 50$(max age: 8 years) " +
                "\nWrite one animal at a time or write word 'end' after you bought what you wanted if you don't want to buy more animals");

       String input =prompt("");

       //As long as user input is not "end": if player's money is lower than the cost for an animal player can not buy the animal
       // Otherwise player gives name and sex for the animal he wants to buy and his money decreases

        while(!input.equals("end")) {


            for(Animal myAnimal:animalTypes)
            {


                if (input.toLowerCase().equals(myAnimal.getClass().getSimpleName().toLowerCase()))

                {
                    if (player.money<myAnimal.getCost())

                    {
                        System.out.println("You don't have enough money!");

                    }
                    else {
                        System.out.println("It will cost you "+myAnimal.getCost()+"$");
                        String name = prompt("What will be its name?");
                        String sex = prompt("What will be its sex? male/female");


                        switch(myAnimal.getClass().getSimpleName().toLowerCase())
                        {
                            case "cat" -> player.animals.put(new Cat(name, sex), new Catfood());


                            case "tiger" -> player.animals.put(new Tiger(name, sex), new Meat());


                            case "fish" -> player.animals.put(new Fish(name, sex), new Seed());


                            case "budgie" -> player.animals.put(new Budgie(name, sex), new Seed());


                            case "hamster" -> player.animals.put(new Hamster(name, sex), new Seed());

                        }

                        player.money -= myAnimal.getCost();
                        System.out.println("Bought new animal!");
                        System.out.println("Money left "+player.money +"$");
                    }
                }
            }
            input = prompt("Do you want to buy another animal? Write what animal you want to buy or write 'end' to stop");

        }


        }





        //Selling animals
        //User gets animal cost mutliplied by animal health minus animal age mutliplied by two
        // and the animal gets removed from user's list
        public void sellAnimal(Player newPlayer)
        {

           input=prompt("Write name of animal you want to sell or write word 'end' if you don't want to sell animals").toLowerCase();
            while(!input.toLowerCase().equals("end"))
            {
                for(Animal animal:newPlayer.animals.keySet())
                {
                    if(animal.name.toLowerCase().equals(input))
                    {

                        int cost=(int) Math. round(animal.health * animal.getCost()) - (animal.age*2);
                        System.out.println("You get "+cost +"$ from selling");
                        newPlayer.animals.remove(animal, newPlayer.animals.get(animal));
                        newPlayer.money+=cost;
                    }
                }

                input=prompt("Do you want to sell another animal? Write its name or type 'end' to stop").toLowerCase();

            }
        }
    }




