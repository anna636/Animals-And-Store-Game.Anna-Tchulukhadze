package com.company;
import java.util.*;

public class Store {

    Scanner scan=new Scanner(System.in);

    String input="+";






    // method to buy animals

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

