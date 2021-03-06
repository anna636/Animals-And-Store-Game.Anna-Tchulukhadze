package com.company;

import com.company.animals.*;
import com.company.food.Catfood;
import com.company.food.Meat;
import com.company.food.Seed;

import java.util.*;

import static com.company.dialogs.Dialogs.*;

public class Game {

    Random rand=new Random();
    Scanner scan=new Scanner(System.in);
    String input;
    int amountOfPlayers; //Variable for how many users will be playing this game
    int rounds; //Variable for how many rounds this game will have
    ArrayList<Player> players=new ArrayList<>(amountOfPlayers); //Arraylist to store all users and their information

    Store myStore=new Store();  //New store to buy food, animals and sell animals





    public Game()
    {
        main();
    }



    //Main game method
    public void main()
    {

        askForAmountOfRounds();

        askForAmountOfPlayers();

        askPlayersForNames();

        System.out.println("\n".repeat(20)+  "-".repeat(50) + "Now you cat begin the game!"+"-".repeat(50)
        +"\n"+" ".repeat(50)+"✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿" + " ".repeat(50));

        chooseWhatToDo();





    }






    //asking for how many users are going to play this game

    public void askForAmountOfPlayers() {
        amountOfPlayers=promptInt("How many players will play this game? Max amount of players is 4", 1, 4);

    }



    //asking all users for their names and last names

    public void askPlayersForNames()
    {
        int i=0;
        while(i<amountOfPlayers)
        {
            System.out.println("Player number " + (i + 1 )+" write your name:");
            String name=scan.next();
            System.out.println("And your last name:");
            String lastName=scan.next();
            players.add(new Player(name, lastName));
            i++;


        }

    }



    //Asking user for how many rounds they want to have
    //If input is not between 5 and 30, ask user again
        public void askForAmountOfRounds()
        {
            rounds=promptInt("How many rounds do you want to play? Choose between 5 to 30", 5, 30);

    }



//Method to place new animals after mating to user's animal list
//User chooses names for new animals

public void placeNewAnimalsInUserList(Player player)
{
    switch(player.animalSexToPair)
    {

        //Cats give 2 babies
        case"cat":
            System.out.println("Mating succeeded! You have 2 new cats! Choose name for first one:");
            scan.nextLine();
            String firstName=scan.nextLine();
            player.animals.put(new Cat(firstName, player.randomSex()), new Catfood());
            System.out.println("And name for second one:");
            String secondName=scan.nextLine();
            player.animals.put(new Cat(secondName, player.randomSex()), new Catfood());
            break;



            //Tiger gives one baby
        case "tiger":
            System.out.println("Mating succeeded! You have 1 new tiger! Choose name for it:");
            scan.nextLine();
            String tigerName=scan.nextLine();
            player.animals.put(new Tiger(tigerName, player.randomSex()), new Meat());
            break;


            //Hamster gives 1 baby
        case "hamster":
            System.out.println("Mating succeeded! You have 1 new hamster! Choose name for it:");
            scan.nextLine();
            String hamsterName=scan.nextLine();
            player.animals.put(new Hamster(hamsterName, player.randomSex()), new Seed());
            break;


            //Fish gives 4 babies
        case "fish":
            System.out.println("Mating succeeded! You have 4 new fishes!");
            System.out.println("Choose name for new fish:");
            scan.nextLine();
            String fishName1 = scan.nextLine();
            player.animals.put(new Fish(fishName1, player.randomSex()), new Seed());

            for(int i=0; i<3; i++) {

                System.out.println("Choose name for next new fish:");

                String fishName2 = scan.nextLine();
                player.animals.put(new Fish(fishName2, player.randomSex()), new Seed());

            }
            break;


            //Budgie gives 2 babies
        case "budgie":
            System.out.println("Mating succeeded! You have 2 new budgies! Choose name for first one:");
            scan.nextLine();
            String budgieName1=scan.nextLine();
            player.animals.put(new Budgie(budgieName1, player.randomSex()), new Seed());
            System.out.println("And name for second one:");
            String budgieName2=scan.nextLine();
            player.animals.put(new Budgie(budgieName2, player.randomSex()), new Seed());
            break;


    }
}





    //Player chooses between 4 different alternatives per round
    public void chooseWhatToDo()
    {
        int i=0;
        while(i<rounds)
        {
            System.out.print("-".repeat(20)+"Round "+ (i+1) + "-".repeat(20));
            int j=0;


            while(j<players.size()) {


                //Check if the player has money and animals to continue to play
                //If not, player gets eliminated and amount of players decreases by 1
                //If only one user is left, he/she wins
                players.get(j).checkIfPlayerCanContinueToPlay();
                if(players.get(j).canContinueToPlay==false) {

                    System.out.println("\n" + players.get(j).name + " has been eliminated because of lack of money and animals!");
                    players.remove(players.get(j));
                    amountOfPlayers -= 1;
                    if (j == players.size()) {

                        j = 0;

                    }


                    if (amountOfPlayers == 1) {
                        System.out.println(players.get(0).name + " won! Everyone else has been eliminated");
                        i = 31;
                        break;

                    }


                }

                


                System.out.println("\n\n\n\n~~Now it's "+ players.get(j).name + "'s turn!~~\n");





                players.get(j).animalBecomeIll(); //See if some of animals become ill and if user wants to take them to vet
                players.get(j).seeIfAnimalDied(); //Checking if some animal died and write that to user

                players.get(j).seeResourcesOfPlayer();  // Writing all the food, animals (that are alive) and money that the player has




                System.out.println("\nYou have 5 choices:\n1. Buy animals\n2. Buy food " +
                        "\n3. Feed your animals\n4. Try to mate 1 pair of animals\n5. Sell one of several animals to the shop\nIf you" +
                        " have no money and no animals you get eliminated!");

                String choice = scan.next();

                switch (choice) {

                    //User buys animals
                    case "1":

                        myStore.buyAnimal(players.get(j));
                        break;


                    //User buys food
                    case "2":

                        myStore.buyFood(players.get(j));
                        break;


                    //User feeds animals if he has at least 1 animal and at least 1 kf of any food
                    case "3":

                        if (players.get(j).animals.size() == 0 || players.get(j).foodForAnimals.size() == 0) {
                            System.out.println("You don't have enough of resources too feed animals!");
                        } else {

                            players.get(j).feedAnimals();
                        }
                        break;


                        //User tries mating 1 pair of animals
                    case "4":

                      players.get(j).checkIfAnimalsCanReproduce();
                      if(players.get(j).canPairAnimals==true) {

                          int randomNumber=rand.nextInt(2);
                          if(randomNumber==0) {
                              placeNewAnimalsInUserList(players.get(j));

                          }
                          else
                          {
                              System.out.println("Mating did not succeeded :(");
                          }
                      }

                        break;





                    case"5":

                        myStore.sellAnimal(players.get(j));
                        break;



                }






                players.get(j).increaseAnimalAge(); //Increasing user's animal age for every round
                players.get(j).decreaseAnimalHealth();  //Decreasing player's animal health for every round and if animal dies, write that to user
                                                        //in the beginning of next round

                j++; //After one user has done what he wanted, it's time for new user to choose what to do

                }


            //If this is the last round, check who wins
            if(i==rounds-1)
            {

                System.out.println("==".repeat(30));
                System.out.println("Game is over! Now let's see who wins...\n");

                seeWhoWins();
                break;

            }
            i++; //After all users have chosen what to do, new round begins

            }



        }





        //Method to check who wins
        public void seeWhoWins()
        {
            //Sell all animals of each user and increase their money
            for(Player player:players)
            {

                var keysToDelete = new ArrayList<Animal>();
                for(var animal: player.animals.keySet()){

                    int cost=(int) Math.round(animal.health * animal.getCost()) - (animal.age*2);
                    player.money+=cost;
                }

                for(var key : keysToDelete){
                    player.animals.remove(key);
                }

            }

            //Compare user's money to each other
            //The one who has most money left wins
            players.sort(new Comparator<Player>() {
                @Override
                public int compare(Player o1, Player o2) {
                    return Integer.valueOf(o2.money).compareTo(o1.money);
                }
            });

            System.out.println("Wow! "+players.get(0).name + " "+ players.get(0).lastName+" won! Money count: "+ players.get(0).money+"$");






        }



    }





