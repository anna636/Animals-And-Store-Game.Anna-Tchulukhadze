package com.company;
import java.util.*;

public class Game {

    Random rand=new Random();
    Scanner scan=new Scanner(System.in);
    int amountOfPlayers;
    ArrayList<Player> players=new ArrayList<>(amountOfPlayers);
    Store myStore=new Store();

    int rounds;
    String input;



    public Game()
    {
        //main();
    }
    public void main()
    {

       askForAmountOfRounds();

        askForAmountOfPlayers();

        askPlayersForNames();

        System.out.println("\n".repeat(20)+  "-".repeat(50) + "Now we cat begin the game!"+"-".repeat(50)
        +"\n"+" ".repeat(50)+"✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿" + " ".repeat(50));

        chooseWhatToDo();





    }






    //asking for how many users are going to play this game

    public void askForAmountOfPlayers() {



            System.out.println("How many players will play this game? Max amount of players: 4");
            while(!"1234".contains(amountOfPlayers+"")) {

                try {
                    amountOfPlayers = scan.nextInt();

                   if (amountOfPlayers < 1 || amountOfPlayers > 4) {
                        System.out.println("Please write number only from 1 to 4");
                    }
                }
                //catching error if user input is not an integer
                catch(Exception e)
                {
                    System.out.println("Please write only integer \n"+e);


                }

                return;
            }

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
        public void askForAmountOfRounds()

        {

        ArrayList<Integer> amountOfRoundsPossible=new ArrayList<>();
        for(int i=5; i<31; i++)
       {

           amountOfRoundsPossible.add(i);

       }
        System.out.println("How many rounds do you want to play? Minimum: 5 Maximum: 30");
        while(!amountOfRoundsPossible.contains(rounds))
        {
            rounds = scan.nextInt();
            if (!amountOfRoundsPossible.contains(rounds)) {

                System.out.println("Please write number only between 5 to 30");
           }

       }

    }




public void placeNewAnimalsInUserList(Player player)
{
    switch(player.animalSexToPair)
    {
        case"cat":
            System.out.println("Mating succeeded! You have 2 new cats! Choose name for first one:");
            scan.nextLine();
            String firstName=scan.nextLine();
            player.animals.put(new Cat(firstName, player.randomSex()), new Catfood());
            System.out.println("And name for second one:");
            String secondName=scan.nextLine();
            player.animals.put(new Cat(secondName, player.randomSex()), new Catfood());
            break;



        case "tiger":
            System.out.println("Mating succeeded! You have 1 new tiger! Choose name for it:");
            scan.nextLine();
            String tigerName=scan.nextLine();
            player.animals.put(new Tiger(tigerName, player.randomSex()), new Meat());
            break;


        case "hamster":
            System.out.println("Mating succeeded! You have 1 new hamster! Choose name for it:");
            scan.nextLine();
            String hamsterName=scan.nextLine();
            player.animals.put(new Hamster(hamsterName, player.randomSex()), new Seed());
            break;

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
            while(j<amountOfPlayers) {

                System.out.println("\nNow is " + players.get(j).name + "'s turn!");

                // writing all the food, animals and money that the player has

                players.get(j).decreaseAnimalHealth();
                players.get(j).seeResourcesOfPlayer();


                System.out.println("\nYou have 5 choices:\n1. Buy animals\n2. Buy food " +
                        "\n3. Feed your animals\n4. Try to mate 1 pair of animals\n5. Sell one of several animals to the shop");

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


                    //User feeds animals if he has at least 1 animal and at least 1 kf of food
                    case "3":

                        if (players.get(j).animals.size() == 0 || players.get(j).foodForAnimals.size() == 0) {
                            System.out.println("You don't have enough of resources too feed animals!");
                        } else {

                            players.get(j).feedAnimals();
                        }
                        break;


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
                        break;







                }





                j++;

                }



            i++;
            }



        }



    }





