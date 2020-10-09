package com.company;
import java.util.*;

public class Player {

    Random rand=new Random();
    Scanner scan=new Scanner(System.in);
    String name;
    String lastName;
    boolean canPairAnimals=false; //Variable to check if 2 animals match each other for reproducing
    String animalSexToPair="+";   //Variable to remember which class child of 2 animals will be
    String input="+";
    boolean canContinueToPlay=true;  //Variable to see if user needs to be eliminated
    int money=2000;
    ArrayList<Animal> animalsThatDied=new ArrayList<>();  //List of animals that died to remove them later




    //Two array lists for animals and food that player stores
   HashMap<Animal, Food> animals=new HashMap<>();
   HashMap<Food, Integer> foodForAnimals=new HashMap<>();


    //Constructor to set field variables

    public Player(String name, String lastName)
    {
        this.name=name;
        this.lastName=lastName;


    }



    //Checking if player has enough money and animals to continue to play
    public void checkIfPlayerCanContinueToPlay()
    {
        if(animals.size()==0 && money<=0)
        {
            canContinueToPlay=false;
        }


    }

    // Writing all resources the the player has: money, animals and food
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

                if(animal.isAlive==false)
                {

                }
                else {
                    System.out.println(animal.name + " (" + animal.getClass().getSimpleName() + " " + animal.animalGender.name().toLowerCase() + "" +
                            ", health left: " + (int) Math.round(animal.health * 100) + "%, age:" + animal.age + " )");
                }

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

    //Check if such animal exists in list of animals

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


                   if(animal1.health>=1.00)
                   {

                   System.out.println("This animal is already full!");


                   }

                   else{

                   animal1.health+=0.10;

                   int keyValue= foodForAnimals.get(food);
                   keyValue--;
                   foodForAnimals.put(food, keyValue);

                   System.out.println(animal1.name + " ate "+foodName + "!");
                   if(keyValue<=0)
                   {
                       System.out.println("you have no more "+food.getClass().getSimpleName().toLowerCase());
                       foodForAnimals.remove(food, foodForAnimals.get(food));

                   }


                       }

                    }


                    else
                    {
                        System.out.println(animal1.name+" can not eat such kind of food :(");
                        break;
                    }

                  }

                    else
                    {
                        System.out.println("You don't have such food!");
                        break;
                    }
                 }
               }
           }

                        System.out.println("Do you want to feed another animal? Write its name");
                        input=scan.nextLine();

                      }
                    }



        //Method to decrease every animal's health
        //Generate random percent number between 0.10 and 0.30 to decrease animal health with
        public void decreaseAnimalHealth()
        {


            for(Animal animal:animals.keySet())
            {


                    double randomNumber = 0.10 + (0.30 - 0.10) * rand.nextDouble();

                    double roundedRandomNumber = Math.round(randomNumber * 10) / 10.0;
                    animal.health -= roundedRandomNumber;
                    double health = Math.round(animal.health * 10) / 10.0;
                    animal.health = health;

                    //If animal dies, add it to list of dead animals
                    if(animal.health<=0)
                    {
                        animalsThatDied.add(animal);
                    }



            }
        }



        //Increasing animal age by +1
        public void increaseAnimalAge()
        {
            for(Animal animal:animals.keySet())
            {
                animal.age++;
                if(animal.age>=animal.maxAge)
                {
                    animalsThatDied.add(animal);
                    System.out.println(animal.name + " ("+animal.getClass().getSimpleName()+") reached maximum age!");
                }


            }
        }


        //Animals become sick with 20% chance
        public void animalBecomeIll()
        {
            boolean animalsAreIll=false;  //Boolean to indicate that someone of animals is sick
            for(Animal animal:animals.keySet())
            {
                int randomNumber=rand.nextInt(5);

                if(randomNumber==1)
                {
                    animalsAreIll=true;
                    animal.isIll=true;
                    animalsThatDied.add(animal);  //Animal gets added to list of potentially dead animals
                    System.out.println(animal.name + " is ill! You need to take it to vet!");
                }
            }


            //If someone of animals is ill ask user if he want to take animal to vet
            //If yes, ask name of animal he wants to take to vet
            if(animalsAreIll) {
                System.out.println("Sick animals are going to die! Do you want to take any animal to vet? yes/no");
                input = scan.nextLine().toLowerCase();
                if(input.equals("yes"))
                {
                    System.out.println("Choose animal you want to take to vet and write its name (Otherwise write word end to stop curing animals");

                    input=scan.nextLine().toLowerCase();

                    //As long as user does not write "end" check if user has animal with such name and if that animal is ill
                    while(!input.equals("end"))
                    {
                        {
                            for (Animal animal : animals.keySet()) {
                                if (input.equals(animal.name.toLowerCase()) && animal.isIll == true) {

                                    System.out.println("Vet cost for this animal is " + animal.vetCost + "$");

                                    //If user does not have anough money, he can not cure animal
                                    if (money < animal.vetCost) {
                                        System.out.println("You don't have enough money!");


                                    }

                                    //otherwise user pays for vet and animal becomes healthy with 50% chance
                                    else {

                                        money -= animal.vetCost;
                                        System.out.println("You successfully paid for vet! Now you have " + money + "$ left");
                                        int randomNumber = rand.nextInt(2);
                                        {
                                            if (randomNumber == 0) {
                                                System.out.println("But unfortunately, vet could no help the animal\n");


                                            }
                                            else {
                                                System.out.println("Yay! Animal is ok now :)\n");
                                                animalsThatDied.remove(animal);
                                            }
                                        }
                                    }


                                }

                            }
                        }


                        System.out.println("Do you want to try cure another animal? Write its name:");
                        input=scan.nextLine().toLowerCase();
                    }
                }



            }
        }





        //Checking of someone of animals has died and removing it from animal list
        public void seeIfAnimalDied() {


            if(animalsThatDied.size()>0) {
                animals.keySet().removeAll(animalsThatDied);
                System.out.println("Animal died! :(");
                animalsThatDied.clear();
            }

        }







//Method to get random sex(male/female) for animals
   public String randomSex()
    {
        int randomNumber=rand.nextInt(2);
        if(randomNumber==0)
        {
            return "male";
        }
        else
        {
            return "female";
        }
    }




    //Check if animals can reproduce
    public void checkIfAnimalsCanReproduce()
    {

        //If user has only one animal it's not enough for reproducing
        if (animals.size() <= 1)
        {
            System.out.println("You don't have enough animals to pair them");
        }
        else {

            //Checking if user has first animal
            System.out.println("Write name of animal you want to pair");
            String firstAnimalName=scan.nextLine().toLowerCase();
            for(Animal animal:animals.keySet())
            {

                if(animal.name.toLowerCase().equals(firstAnimalName)) {
                    System.out.println("You have this animal!");


                    //Checking if user has another animal
                    System.out.println("Write name of another animal you want to pair");
                    String secondAnimalName = scan.nextLine().toLowerCase();

                    for (Animal anotherAnimal : animals.keySet()) {


                        if (anotherAnimal.name.toLowerCase().equals(secondAnimalName))
                        {

                            //Checking if animals are same species
                            if(animal.getClass().getSimpleName().equals(anotherAnimal.getClass().getSimpleName()))
                            {
                                //Checking if animals have different sexes
                                if(!animal.animalGender.name().equals(anotherAnimal.animalGender.name()))
                                {
                                    this.canPairAnimals=true; //Animals can pair

                                    //Remembering the class of which new animal will be
                                    animalSexToPair= animal.getClass().getSimpleName().toLowerCase();
                                    break;

                                }

                                else{
                                    System.out.println("mating is not possible, animals have same sex!");
                                    break;
                                }
                            }

                            else
                            {
                                System.out.println("Mating is not possible, these are different species!");
                                break;
                            }
                        }

                    }
                }



            }
        }


    }





}

