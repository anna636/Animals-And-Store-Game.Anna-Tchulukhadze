package com.company;
import java.util.*;

public class Player {

    String name;
    String lastName;
    boolean foundAnimal=false;
    String input="+";
    int money=1100;


    //Two array lists for animals and food that player stores
   HashMap<Animal, Food> animals=new HashMap<>();
   HashMap<Food, Integer> foodForAnimals=new HashMap<>();


    //Constructor to set field variables

    public Player(String name, String lastName)
    {
        this.name=name;
        this.lastName=lastName;

    }

    // writing all resources the the player has: money, animals and food
    public void seeResourcesOfPlayer()
    {



        if (money==0) //See all user's money
        {
            System.out.println("You have no money!");
        }
        else {
            System.out.println("Your money: " + money + "$\n");
        }




        System.out.println("Your animals:\n"); //See all user's animals
        if (animals.size()==0)
        {
            System.out.println("You have no animals yet\n");
        }
        else {

            for (Animal animal : animals.keySet()) {
                System.out.println(animal.name + " ("+animal.getClass().getSimpleName()+")");

            }
        }




        System.out.println("\nYour food:\n"); //See all user's food

        //If kg of any type of food equals 0, remove this type of food from list
        for (Food food:foodForAnimals.keySet()) {
           if(foodForAnimals.get(food)==0 )
           {
               foodForAnimals.remove(food, foodForAnimals.get(food));
           }
        }

        //If size of list for food for animals is zero, player doesn't have any types of food yet
        if (foodForAnimals.size()==0)
        {
            System.out.println("You have no food for animals yet\n");
        }

        //Otherwise print how many kg of what kind of food the player has
        else {

            for (Food food : foodForAnimals.keySet()) {
                System.out.println(foodForAnimals.get(food) + "kg of " + food.getClass().getSimpleName());
            }
        }

    }







    //Method to feed animals
    //As long as user input is not "end" user is asked for name of the animal he wants to feed
    public void feedAnimals()
    {

        Scanner scan=new Scanner(System.in);
        System.out.println("Type the name of animal you want to feed and type word end if you don't want to feed anymore");
        String input = scan.nextLine();

        while(!input.equals("end"))

        {

    //check if such animal exists in list of animals

        for(Animal animal1:animals.keySet())
        {

        if(animal1.name.toLowerCase().equals(input.toLowerCase()))

        {


    //If such animal exists, ask for what kind of food user wants to feed it
    //And check if user has such kind of food

        System.out.println("What type of food do you want to feed it? Seed/meat/catfood");
        String foodName = scan.nextLine().toLowerCase();


        for(Food food:foodForAnimals.keySet())

        {

        if (foodName.equals(food.getClass().getSimpleName().toLowerCase()))

        {


    //Check if animal can eat this kind of food
    //If animal's health is already 100% player can not feed it, otherwise animal's healthy gets +10 to health
    // And food type decreases with 1 kg

                   if(animals.get(animal1).getClass().getSimpleName().toLowerCase().equals(foodName))
                   {


                   if(animal1.health==100)
                   {

                   System.out.println("This animal is already full!");

                   }

                   else{

                   animal1.health+=10;

                   int keyValue= foodForAnimals.get(food);
                   keyValue--;
                   foodForAnimals.put(food, keyValue);

                   System.out.println(animal1.name + " ate "+foodName + "!");


                       }

                    }


                    else
                    {
                        System.out.println(animal1.name+" can not eat such kind of food :(");
                    }

                  }

                    else
                    {
                        System.out.println("You don't have such food!");
                    }
                 }
               }
           }

                        System.out.println("Do you want to feed another animal? Write it's name");
                        input=scan.nextLine();

                      }
                    }



        //Method to decrease every animal's health
        //Generate random number between 10 and 30 to decrease animal health with
        public void decreaseAnimalHealth()
        {
            Random rand=new Random();


            for(Animal animal:animals.keySet())
            {

             if(animal.health<=0)
                {
                    animal.isAlive=false;
                    animals.remove(animal, animals.get(animal));
                    System.out.println(animal.name + "(" + animal.getClass().getSimpleName()+") has died! :,(");



                }
                else {
                    int randomNumber = (rand.nextInt(3) + 1) * 10;
                    animal.health -= randomNumber;
                    System.out.println(animal.name + " health decrease with "+randomNumber);
                 System.out.println("Health is: " + animal.health);
                }
            }
        }



    }

