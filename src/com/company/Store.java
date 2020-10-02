package com.company;
import java.util.*;

public class Store {

    Scanner scan=new Scanner(System.in);



    String input="+";
    //Two lists for available type of foods and animals that player can buy

    ArrayList<Food> foodTypes=new ArrayList<Food>(Arrays.asList(new Seed(), new Meat(), new Catfood()));
    ArrayList<Animal> animalTypes=new ArrayList<Animal>(Arrays.asList(new Cat("", "male"), new Tiger("","male"),
                                                                      new Budgie("", "male"),
                                                                      new Fish("", "male"),
                                                                      new Hamster("", "male")));





        //Method to buy food
        public void buyFood(Player player) {


        System.out.println("What kind of food do you want to buy? Price per kg is:\nSeed - 5$,  Catfood- 3$, Meat - 6$,"+
                "\nWrite one food at a time or write word end  after you bought what you wanted if you don't want to buy more food");

        input=scan.nextLine();

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

                    if(player.foodForAnimals.containsKey(food))
                    {
                       int keyValue= player.foodForAnimals.get(food);
                       keyValue++;
                       player.foodForAnimals.put(food, keyValue);
                        System.out.println("Bought 1 kg of "+food.getClass().getSimpleName());
                    }


                    else {


                        player.foodForAnimals.put(food, 1);
                        player.money -= food.getCost();
                        System.out.println("Bought!");

                    }




                }
                else{

                 }

            }

            System.out.println("What another food do you want to buy?");
            input = scan.nextLine().toLowerCase();
        }


    }




    //Method to buy animals

    public void buyAnimal(Player player)
    {
        System.out.println("What kind of animals do you want to buy?\nHamster - 25$,  Fish - 20$, Cat - 100$, Tiger - 900$, Budgie - 50$ " +
                "\nWrite one animal at a time or write word end after you bought what you wanted if you don't want to buy more animals");

       String input =scan.nextLine();

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
                        System.out.println(myAnimal.getCost());
                        System.out.println("What will be it's name?");
                       String name = scan.nextLine();
                        System.out.println("What will be it's sex? male/female");
                       String sex = scan.nextLine();

                        player.animals.add(myAnimal);
                        myAnimal.changeNameAndSex(name, sex);
                        player.money -= myAnimal.getCost();
                        System.out.println("Bought!");
                    }




                }

                else {


                    continue;

                }



            }



            System.out.println("What another animal do you want to buy?");
            input = scan.nextLine().toLowerCase();



        }


        }


    }




