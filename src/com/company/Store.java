package com.company;
import java.util.*;

public class Store {

    Scanner scan=new Scanner(System.in);
    String input="+";

    //Two lists for availabe type of foods and animals that player can buy

    ArrayList<Food> foodTypes=new ArrayList<Food>(Arrays.asList(new Seed(), new Meat(), new Catfood()));
    ArrayList<Animal> animalTypes=new ArrayList<Animal>(Arrays.asList(new Cat("", "male"), new Tiger("","male"),
                                                                      new Budgie("", "male"),
                                                                      new Fish("", "male"),
                                                                      new Hamster("", "male")));





        //Method to buy food
        public void buyFood(Player player) {


        System.out.println("What kind of food do you want to buy? Price per kg is:\nSeed - 5$,  Catfood- 3$, Meat - 6$,"+
                "\nWrite one food at a time or write word end if you don't want to buy more food");

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

                    player.foodForAnimals.add(food);
                    player.money-= food.getCost();
                    System.out.println("Bought!");
                    break;


                }

            }

            System.out.println("What another food do you want to buy?");
            input = scan.nextLine().toLowerCase();
        }


    }




    //Method to buy animals

    public void buyAnimal(Player player)
    {

        System.out.println("What kind of animals do you want to buy?\nHamster - 25$,  Fish - 20$, Cat - 300$, Tiger - 900$, Budgie - 50$ " +
                "\nWrite one animal at a time or write word end if you don't want to buy more animals");


        input = scan.nextLine().toLowerCase();


            while(!input.equals("end")) {



                    switch (input) {

                        case "hamster":



                            if (25 > player.money) {
                                System.out.println("You don't have enough money!");

                            } else {
                                System.out.println("What sex do you want it to be?");
                                String sex = scan.nextLine();
                                System.out.println("What name do you want it to have?");
                                String name = scan.nextLine();
                                player.money -= 25;

                                player.animals.add(new Hamster(name, sex));

                            }
                            break;

                        case "fish":

                            if (20 > player.money) {
                                System.out.println("You don't have enough money!");

                            } else {
                                System.out.println("What sex do you want it to be?");
                                String sex = scan.nextLine();
                                System.out.println("What name do you want it to have?");
                                String name = scan.nextLine();
                                player.money -= 20;

                                player.animals.add(new Fish(name, sex));

                            }
                            break;

                        case "cat":

                            if (300 > player.money) {
                                System.out.println("You don't have enough money!");

                            } else {
                                System.out.println("What sex do you want it to be?");
                                String sex = scan.nextLine();
                                System.out.println("What name do you want it to have?");
                                String name = scan.nextLine();
                                player.money -= 300;

                                player.animals.add(new Fish(name, sex));

                            }
                            break;

                        case "tiger":

                            if (900 > player.money) {
                                System.out.println("You don't have enough money!");

                            } else {
                                System.out.println("What sex do you want it to be?");
                                String sex = scan.nextLine();
                                System.out.println("What name do you want it to have?");
                                String name = scan.nextLine();
                                player.money -= 900;

                                player.animals.add(new Fish(name, sex));

                            }
                            break;

                        case "budgie":

                            if (50 > player.money) {
                                System.out.println("You don't have enough money!");

                            } else {
                                System.out.println("What sex do you want it to be?");
                                String sex = scan.nextLine();
                                System.out.println("What name do you want it to have?");
                                String name = scan.nextLine();
                                player.money -= 50;

                                player.animals.add(new Fish(name, sex));

                            }
                            break;


                        default:
                            System.out.println("There is no such animal");



                    }
                    System.out.println("What another animal do you want to buy?");
                input = scan.nextLine().toLowerCase();
                }
            }





    }




