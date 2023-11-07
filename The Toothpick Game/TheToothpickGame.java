import java.util.Scanner;
import java.lang.*;

/**
 * The Toothpick Game is the the most amazing game EVER!
 * 
 * @author Ridwan Simjee
 */
public class TheToothpickGame
{
    public static final int EASY = 1, MEDIUM = 2, HARD = 3;
    private static boolean computerOpponent, randomMaxSelection;
    private static int compSkillLevel, maxToothpicksPerTurn, toothpicksRemaining, currentPlayer, player1Wins, player2Wins, winsNeeded;
    private static String player1Name, player2Name;
    public static void main (String [] args)
    {
        displayWelcomeBanner();
        getStartingInformation();           

        while (player1Wins != winsNeeded && player2Wins != winsNeeded)
            playOneGame();

        displayFinalStats();
    }

    /**
     * The displayWelcomeBanner method should be your take on a welcome message.
     * 
     * Be creative.
     */
    private static void displayWelcomeBanner(){
        System.out.println("$$\\      $$\\           $$\\                                                     $$\\                       $$\\     $$\\                       \n" +
                "$$ | $\\  $$ |          $$ |                                                    $$ |                      $$ |    $$ |                      \n" +
                "$$ |$$$\\ $$ | $$$$$$\\  $$ | $$$$$$$\\  $$$$$$\\  $$$$$$\\$$$$\\   $$$$$$\\        $$$$$$\\    $$$$$$\\        $$$$$$\\   $$$$$$$\\   $$$$$$\\        \n" +
                "$$ $$ $$\\$$ |$$  __$$\\ $$ |$$  _____|$$  __$$\\ $$  _$$  _$$\\ $$  __$$\\       \\_$$  _|  $$  __$$\\       \\_$$  _|  $$  __$$\\ $$  __$$\\       \n" +
                "$$$$  _$$$$ |$$$$$$$$ |$$ |$$ /      $$ /  $$ |$$ / $$ / $$ |$$$$$$$$ |        $$ |    $$ /  $$ |        $$ |    $$ |  $$ |$$$$$$$$ |      \n" +
                "$$$  / \\$$$ |$$   ____|$$ |$$ |      $$ |  $$ |$$ | $$ | $$ |$$   ____|        $$ |$$\\ $$ |  $$ |        $$ |$$\\ $$ |  $$ |$$   ____|      \n" +
                "$$  /   \\$$ |\\$$$$$$$\\ $$ |\\$$$$$$$\\ \\$$$$$$  |$$ | $$ | $$ |\\$$$$$$$\\         \\$$$$  |\\$$$$$$  |        \\$$$$  |$$ |  $$ |\\$$$$$$$\\       \n" +
                "\\__/     \\__| \\_______|\\__| \\_______| \\______/ \\__| \\__| \\__| \\_______|         \\____/  \\______/          \\____/ \\__|  \\__| \\_______|      \n" +
                "                                                                                                                                           \n" +
                "                                                                                                                                           \n" +
                "                                                                                                                                           \n" +
                "$$$$$$$$\\                   $$\\     $$\\                 $$\\           $$\\              $$$$$$\\                                             \n" +
                "\\__$$  __|                  $$ |    $$ |                \\__|          $$ |            $$  __$$\\                                            \n" +
                "   $$ | $$$$$$\\   $$$$$$\\ $$$$$$\\   $$$$$$$\\   $$$$$$\\  $$\\  $$$$$$$\\ $$ |  $$\\       $$ /  \\__| $$$$$$\\  $$$$$$\\$$$$\\   $$$$$$\\           \n" +
                "   $$ |$$  __$$\\ $$  __$$\\\\_$$  _|  $$  __$$\\ $$  __$$\\ $$ |$$  _____|$$ | $$  |      $$ |$$$$\\  \\____$$\\ $$  _$$  _$$\\ $$  __$$\\          \n" +
                "   $$ |$$ /  $$ |$$ /  $$ | $$ |    $$ |  $$ |$$ /  $$ |$$ |$$ /      $$$$$$  /       $$ |\\_$$ | $$$$$$$ |$$ / $$ / $$ |$$$$$$$$ |         \n" +
                "   $$ |$$ |  $$ |$$ |  $$ | $$ |$$\\ $$ |  $$ |$$ |  $$ |$$ |$$ |      $$  _$$<        $$ |  $$ |$$  __$$ |$$ | $$ | $$ |$$   ____|         \n" +
                "   $$ |\\$$$$$$  |\\$$$$$$  | \\$$$$  |$$ |  $$ |$$$$$$$  |$$ |\\$$$$$$$\\ $$ | \\$$\\       \\$$$$$$  |\\$$$$$$$ |$$ | $$ | $$ |\\$$$$$$$\\          \n" +
                "   \\__| \\______/  \\______/   \\____/ \\__|  \\__|$$  ____/ \\__| \\_______|\\__|  \\__|       \\______/  \\_______|\\__| \\__| \\__| \\_______|         \n" +
                "                                              $$ |                                                                                         \n" +
                "                                              $$ |                                                                                         \n" +
                "                                              \\__|                                                                                 ");
    }
    
    /**
     * The getStartingInformation method, um, gets the starting information.
     * 
     * In the course of running, setGameParameters uses three helper
     * methods -- choosePlayers(), getWinsNeeded(), and choooseMaxToothpicksPerTurn()
     */
    private static void getStartingInformation()
    {
        choosePlayers();
        
        System.out.println();
        
        winsNeeded = getWinsNeeded();
        
        System.out.println();
        
        chooseMaxToothpicksPerTurn();
    }
    
    /**
     * The choosePlayers method gets player 1's name, determines whether the 
     * second player is human or computer.
     * 
     * If the second player is human, ask for their name and set that variable.
     * 
     * If the second player is a computer, have them choose a skill level to 
     * set that variable, and then set player 2's name variable to be the name
     * of that particular skill level for the computer.
     * 
     * Postcondition:  computerOpponent gets properly set;  
     * 
     *                 The player 1's name and player 2's name varaibles are set properly;  
     *                 
     *                 If playing against a computer then compSkillLevel is also
     *                 set properly.
     */
    private static void choosePlayers(){
        Scanner userInput = new Scanner(System.in);
        Scanner userInputText = new Scanner(System.in);
        System.out.print("Player 1, please enter your name: ");
        player1Name = userInputText.nextLine();
        System.out.print(player1Name + ", is player 2 going to be a human or computer opponent? ");
        String secondPlayer = userInputText.nextLine();
        while(!(secondPlayer.equalsIgnoreCase("human")) && !(secondPlayer.equalsIgnoreCase("computer"))){
            System.out.println("I'm sorry, " + player1Name + ", but that is an invalid choice.\nPlease either choose \"human\" or \"computer\".");
            System.out.print(player1Name + ", is player 2 going to be a human or computer opponent? ");
            secondPlayer = userInputText.nextLine();
        }
        if(secondPlayer.equalsIgnoreCase("human")){
            computerOpponent = false;
            System.out.print("Player 2, please enter your name: ");
        player2Name = userInputText.nextLine();
        }
        else{
            computerOpponent = true;
            System.out.println("************************\n* Computer Skill Level *\n************************");
            System.out.println("*1) BeetleJuice\n*2) Kim \n*3) Winston Zuo\n************************");
            System.out.print("\n"+player1Name + ", which computer do you want to take on? ");
            compSkillLevel = userInput.nextInt();
            while(compSkillLevel != 3 && compSkillLevel != 2 && compSkillLevel != 1) {
                System.out.print(player1Name+ ", that was not one of the options! Pick 1, 2, or 3. ");
                System.out.println("************************\n* Computer Skill Level *\n************************");
                System.out.println("*1) BeetleJuice\n*2) Kim\n *3) Winston Zuo\n************************");
                System.out.print("\n"+player1Name + ", which computer do you want to take on? ");
                compSkillLevel = userInput.nextInt();
            }
            if (compSkillLevel == EASY)
                player2Name = "BeetleJuice";
            else if (compSkillLevel == MEDIUM)
                player2Name = "Kim";
            else
                player2Name = "Winston Zuo";
        }
    }

    /**
     * The getWinsNeeded method asks player 1 how many games they are playing
     * in their series, and returns how many wins are needed for one player
     * to win the series.
     * 
     * @return an integer representing the number of wins needed in order for
     *         one player to win the whole series
     */
    private static int getWinsNeeded(){
        Scanner userInput = new Scanner(System.in);
        System.out.print(player1Name + ", will you be playing best out of 1, 3, 5, or 7? ");
        int bestOfHowMany = userInput.nextInt();
        while(bestOfHowMany != 1 && bestOfHowMany != 3 && bestOfHowMany != 5 && bestOfHowMany != 7){
            System.out.print("I'm sorry, " + player1Name + ", but that is an invalid choice. Please choose 1, 3, 5, or 7.");
            bestOfHowMany = userInput.nextInt();
        }
        return bestOfHowMany/2 + 1;
    }
    
    /**
     * The chooseMaxToothpicksPerTurn method asks player 1 how many toothpicks will be
     * the maximum number that they can choose per turn, or whether they
     * want the maximum randomly determined before the start of each game.
     * 
     * Postcondition:  A global boolean variable is set showing whether or not the max 
     *                 toothpicks per turn should be randomly determined before each
     *                 game.
     *                 
     *                 A global max toothpicks per turn variable is set with the 
     *                 correct maximum, but only if it is NOT being randomly determined
     *                 before each game.
     */
    private static void chooseMaxToothpicksPerTurn(){
        Scanner userInput = new Scanner(System.in);
        System.out.println(player1Name + ", what is the maximum number of toothpicks that a player can take per turn?");
        System.out.print("Enter 3, 4, 5, or 6 (or 0 to have it randomly chosen before each game): ");
        maxToothpicksPerTurn = userInput.nextInt();
        while(maxToothpicksPerTurn != 3 && maxToothpicksPerTurn != 4 && maxToothpicksPerTurn != 5 && maxToothpicksPerTurn != 6 && maxToothpicksPerTurn != 0){
            System.out.print("I'm sorry, " + player1Name +  ", but that is an invalid choice. Please choose 3, 4, 5, 6, or 0. ");
            maxToothpicksPerTurn = userInput.nextInt();
        }
        if (maxToothpicksPerTurn == 0){
            randomMaxSelection = true;
        }
        else{
            randomMaxSelection = false;
        }

    }
    
    /**
     * The playOneGame method plays a single round of the Toothpick Game from
     * start to finish.
     */
    private static void playOneGame()
    {
        initializeGame();           

        while (toothpicksRemaining > 0)
        {
            if (toothpicksRemaining == 1)
                System.out.println("\nThere is 1 toothpick remaining.");
            else
                System.out.println("\nThere are " + toothpicksRemaining + " toothpicks remaining.");        

            currentPlayerTakesTurn();

            if (toothpicksRemaining != 0)
                currentPlayer = (currentPlayer % 2) + 1; //switch current player
        }

        congratulateWinner();
    }
    
    /**
     * The initializeGame method will get a Toothpick Game ready to go.
     * 
     * A random number from 20 to 39 is generated for the number of toothpicks remaining.  
     * The result is printed to the screen.
     * 
     * A coin is flipped to see who will go first.  The result of the coin flip is 
     * output to the screen.
     * 
     * ***IF*** they have chosen to have a random amount of max toothpicks per turn, 
     * then that value needs to be generated and stored in the correct variable.
     * Only if that value was randomly generated will something be output to the screen.
     * 
     * Postcondition:  toothpicksRemaining, currentPlayer, and whatever you named the
     *                 variable holding the maximum number per turn are all properly set
     */
    private static void initializeGame(){
        toothpicksRemaining = (int)(Math.random()*20 + 20);
        System.out.println("\nMotherboard has decided that this game will be played with "+ toothpicksRemaining + " toothpicks.");
        int coinFlip = (int)(Math.random()*2 + 1);
        if(coinFlip == 1) {
            System.out.println("Motherboard has flipped a coin and........." + player1Name + " will go first");
            currentPlayer = coinFlip;
        }
        else {
            currentPlayer = 2;
            System.out.println("Motherboard has flipped a coin and........." + player2Name + " will go first");
        }
        if (randomMaxSelection){
            maxToothpicksPerTurn = (int)(Math.random()*4 + 3);
            System.out.println("Motherboard has determined that each player may take up to " + maxToothpicksPerTurn + " toothpicks per turn.");
        }
    }
    
    /**
     * The congratulateWinner method will congratulate the winner!
     * 
     * Postcondition:  After printing to the screen a relevant congratulations,
     *                 the appropriate player's win total has been incremented.
     */
    private static void congratulateWinner(){
        if (currentPlayer == 1) {
            player1Wins++;
            System.out.println("Nice win, " + player1Name + "!!!! ＼(＾O＾)／");
        }
        else {
            player2Wins++;
            System.out.println("Nice win, " + player2Name + "!!!! ＼(＾O＾)／");
        }
    }
    
    /**
     * The current player takes turn method determines who is supposed to be going
     * right now, and calls the appropriate method to make that happen.
     */
    private static void currentPlayerTakesTurn()
    {
        if (currentPlayer == 1)
            player1TakesTurn();
        else if (computerOpponent == false)
            player2TakesTurn();
        else if (compSkillLevel == EASY)
            easyComputerTakesTurn();
        else if (compSkillLevel == MEDIUM)
            mediumComputerTakesTurn();
        else if (compSkillLevel == HARD)
            hardComputerTakesTurn();
        else
        {
            System.out.println("It should have been impossible to get here");
            System.out.println("Something is definitely wrong.");
        }
    }    
    
    /**
     * The player1TakesTurn method lets player 1, um, take a turn.
     * 
     * Postcondition:  The pile of toothpicks does not go negative.
     */
    private static void player1TakesTurn(){
        Scanner userInput = new Scanner(System.in);
        System.out.print(player1Name + ", how many toothpicks would you like to grab? ");
        int toothpicksPicked = userInput.nextInt();
        while (toothpicksPicked < 1 || toothpicksPicked > maxToothpicksPerTurn || toothpicksPicked > toothpicksRemaining) {
            if (toothpicksPicked < 1) {
                System.out.println(player1Name + ", you have to pick at least 1 toothpick.");
                System.out.print("How many toothpicks would you like to grab? ");
                toothpicksPicked = userInput.nextInt();
            } else if (toothpicksPicked > maxToothpicksPerTurn) {
                System.out.println("Sorry, " + player1Name + ", you can't pick more than " + maxToothpicksPerTurn + " at a time.");
                System.out.print("How many toothpicks would you like to grab? ");
                toothpicksPicked = userInput.nextInt();
            } else if (toothpicksPicked > toothpicksRemaining) {
                System.out.println(player1Name + ", there's only " + toothpicksRemaining + " left.");
                System.out.print("How many toothpicks would you like to grab? ");
                toothpicksPicked = userInput.nextInt();
            }
        }
        toothpicksRemaining -= toothpicksPicked;
    }
    
    /**
     * The player2TakesTurn method lets player 2, well, take a turn.
     * 
     * Postcondition:  The pile of toothpicks does not go negative.
     */
    private static void player2TakesTurn(){
        Scanner userInput = new Scanner(System.in);
        System.out.print(player2Name + ", how many toothpicks would you like to grab? ");
        int toothpicksPicked = userInput.nextInt();
        while (toothpicksPicked < 1 || toothpicksPicked > maxToothpicksPerTurn || toothpicksPicked > toothpicksRemaining) {
            if (toothpicksPicked < 1) {
                System.out.println(player2Name + ", you have to pick at least 1 toothpick.");
                System.out.print("How many toothpicks would you like to grab? ");
                toothpicksPicked = userInput.nextInt();
            } else if (toothpicksPicked > maxToothpicksPerTurn) {
                System.out.println("Sorry, " + player2Name + ", you can't pick more than " + maxToothpicksPerTurn + " at a time.");
                System.out.print("How many toothpicks would you like to grab? ");
                toothpicksPicked = userInput.nextInt();
            } else if (toothpicksPicked > toothpicksRemaining) {
                System.out.println(player2Name + ", there's only " + toothpicksRemaining + " left.");
                System.out.print("How many toothpicks would you like to grab? ");
                toothpicksPicked = userInput.nextInt();
            }
        }
        toothpicksRemaining -= toothpicksPicked;
    }
    
    /**
     * The getRandomChoice method will return a random number of toothpicks
     * between 1 and the max per turn.  It will also never pick a random
     * number which will make the pile go negative.
     * 
     * @return an integer representing a randomly selected amount of toothpicks 
     *         from 1 to the max per turn (inclusive).  The number returned must
     *         also NOT be greater than the number of toothpicks left in the pile.
     */
    private static int getRandomChoice(){
        return (int)(Math.random()*(Math.min(toothpicksRemaining,maxToothpicksPerTurn)) + 1);
    }
    
    /**
     * The getOptimalChoice method will return the number of toothpicks that
     * needs to be taken to force a win, if it exists.
     * 
     * @return an integer representing the optimal number of toothpicks to take
     *         in order to force a win, if it exists;
     *         this will return -1 if it is impossible to force a win at this time
     */
    private static int getOptimalChoice(){
        int optimalChoice;
        if (toothpicksRemaining % (maxToothpicksPerTurn+1) == 0){
            optimalChoice = -1;
        }
        else {
            optimalChoice = toothpicksRemaining % (maxToothpicksPerTurn+1);
        }
        return optimalChoice;
    }
    
    /**
     * The easyComputerTakesTurn method will always take a random number of 
     * toothpicks and then output their choice to the screen after calling
     * getEasyTurnDescription.
     */
    private static void easyComputerTakesTurn(){
        int toothpicksGrabbed = getRandomChoice();
        toothpicksRemaining -= toothpicksGrabbed;
        System.out.println(getEasyTurnDescription(toothpicksGrabbed));
    }
    
    /**
     * getEasyTurnDescription will return a randomly selected String showing
     * what the Easy Computer decided to do this turn.  The method will be 
     * randomly choosing from at least four different possible Strings.
     * 
     * The String returned will reflect the easy computer's personality. 
     * 
     * @param  num  an integer representing the number of toothpicks which
     *              is supposed to be taken this turn
     * @return a String which describes what the easy computer does this turn
     */
    private static String getEasyTurnDescription(int toothpicksGrabbed){
        String whatToSay;
        String toothpickOrToothpicks;
        int randomStringChoice = (int)(Math.random()*4+1);
        if (toothpicksGrabbed == 1)
            toothpickOrToothpicks = "toothpick";
        else
            toothpickOrToothpicks = "toothpicks";
        if (randomStringChoice == 1)
            whatToSay = "BeetleJuice forgot how to count entirely.\nHe ended up grabbing " + toothpicksGrabbed + " " + toothpickOrToothpicks + ".";
        else if (randomStringChoice == 2)
            whatToSay = "BeetleJuice mistook the toothpicks for carrots.\nHe went to eat " + toothpicksGrabbed + " of them and spat the " + toothpickOrToothpicks + " out.";
        else if(randomStringChoice == 3)
            whatToSay = "BeetleJuice is busy learning how to use a spoon. \nDistracted, he grabs " +toothpicksGrabbed + " " + toothpickOrToothpicks + ".";
        else
            whatToSay = "BeetleJuice dozes off and knocks the pile.\n" + toothpicksGrabbed + " "+ toothpickOrToothpicks+" falls out.";
        return whatToSay;
    }
    
    /**
     * The mediumComputerTakesTurn method will sometimes take a random amount
     * of toothpicks and sometimes take the optimal amount.  Once determined,
     * it will use getMediumTurnDescription in order to determine what to 
     * print to the screen.
     */
    private static void mediumComputerTakesTurn(){
        int toothpicksGrabbed;
        int flipCoin = (int)Math.random()*2+1;
        if(flipCoin ==1)
            toothpicksGrabbed = getRandomChoice();
        else {
            toothpicksGrabbed = getOptimalChoice();
            if (toothpicksGrabbed == -1)
                toothpicksGrabbed = getRandomChoice();
        }
        toothpicksRemaining -= toothpicksGrabbed;
        System.out.println(getMediumTurnDescription(toothpicksGrabbed));
    }
    
    
    /**
     * getMediumTurnDescription will return a randomly selected String showing
     * what the Medium Computer decided to do this turn.  The method will be 
     * randomly choosing from at least four different possible Strings.
     * 
     * The String returned will reflect the easy computer's personality. 
     * 
     * @param  num  an integer representing the number of toothpicks which
     *              is supposed to be taken this turn
     * @return a String which describes what the medium computer does this turn
     */
    private static String getMediumTurnDescription(int toothpicksGrabbed){
        String whatToSay;
        String toothpickOrToothpicks;
        int randomStringChoice = (int)(Math.random()*4+1);
        if (toothpicksGrabbed == 1)
            toothpickOrToothpicks = "toothpick";
        else
            toothpickOrToothpicks = "toothpicks";
        if(randomStringChoice == 1)
            whatToSay = ("Kim is consulting his analytics advisor.\nHe choses " +toothpicksGrabbed +" "+toothpickOrToothpicks + ".");
        else if(randomStringChoice == 2)
            whatToSay = "Kim calls Dennis Rodman for advise.\nHe takes " + toothpicksGrabbed + " " + toothpickOrToothpicks + ".";
        else if(randomStringChoice == 3)
            whatToSay = "Kim is called to sign off a new agreement.\nHe rashly grabs " + toothpicksGrabbed + " " + toothpickOrToothpicks + ".";
        else
            whatToSay = "Kim has no clue what's going on.\nHe makes a random choice and picks up " + toothpicksGrabbed + " " + toothpickOrToothpicks + ".";
        return whatToSay;
    }
    
    /**
     * The hardComputerTakesTurn method will always try to do the optimal choice.
     * 
     * Sometimes there is no optimal choice, so it will resort to a random
     * amount instead.  
     * 
     * Once the method determines what its choice is, it will use 
     * getHardTurnDescription in order to determine what to print to the screen.
     * Unlike the Easy Computer and the Medium Computer, this computer player will
     * know whether it is playing optimally or not, so when it calls
     * getHardTurnDescription, it will also include a boolean variable 
     * relaying whether this turn he will be forcing a win or not.
     */
    private static void hardComputerTakesTurn(){
        int toothpicksGrabbed = getOptimalChoice();
        boolean optimalDecision = true;
        if (toothpicksGrabbed == -1) {
            toothpicksGrabbed = getRandomChoice();
            optimalDecision = false;
        }
        toothpicksRemaining -= toothpicksGrabbed;
        System.out.println(getHardTurnDescription(toothpicksGrabbed, optimalDecision));
    }
    
    /**
     * getHardTurnDescription will return a randomly selected String showing
     * what the Hard Computer decided to do this turn.
     *
     * Unlike the Easy and Medium computers, however, we are building in a little 
     * extra here because the Hard computer knows whether or not it is forcing a
     * win.  
     * 
     * The computer will have four random Strings to choose from if he is happy, 
     * and four random Strings to choose from if happy is false.
     * 
     * @param  num  an integer representing the number of toothpicks which
     *              is supposed to be taken this turn
     * @param  happy  a boolean representing whether the computer is happy with its
     *                selection this turn (it is forcing a win) or not (it had to 
     *                pick randomly).
     * @return a String which describes what the hard computer does this turn
     */
    private static String getHardTurnDescription(int toothpicksGrabbed, boolean optimalDecision){
        String whatToSay;
        String toothpickOrToothpicks;
        int randomStringChoice = (int)(Math.random()*4+1);
        if (toothpicksGrabbed == 1)
            toothpickOrToothpicks = "toothpick";
        else
            toothpickOrToothpicks = "toothpicks";
        if(optimalDecision) {
            if (randomStringChoice == 1)
                whatToSay = "Winston smirks, he knows he has this in the bag. He dramatically takes " + toothpicksGrabbed + " " + toothpickOrToothpicks + ".";
            else if (randomStringChoice == 2)
                whatToSay = "Winston chuckles in your face, as he grabs " + toothpicksGrabbed + " " +toothpickOrToothpicks + ".";
            else if (randomStringChoice == 3)
                whatToSay = "Winston remarks \"This is too simple\", as he proceeds to take " + toothpicksGrabbed + " " +toothpickOrToothpicks + ".";
            else
                whatToSay = "Winston demolishes you as he takes " +toothpicksGrabbed + " " +toothpickOrToothpicks + ".";
        }
        else{
            if (randomStringChoice == 1)
                whatToSay = "Winston carefully surveys your face as he slips out " + toothpicksGrabbed + " " +toothpickOrToothpicks + ".";
            else if (randomStringChoice == 2)
                whatToSay = "Winston cautiously picks " +toothpicksGrabbed + " " +toothpickOrToothpicks + ".";
            else if (randomStringChoice == 3)
                whatToSay = "Lost in a trance, Winston carelessly takes " +toothpicksGrabbed + " " +toothpickOrToothpicks + ".";
            else
                whatToSay = "Unfazed, Winston twiddles his fingers as he grabs " +toothpicksGrabbed + " " +toothpickOrToothpicks + ".";
        }
        return whatToSay;
    }
    /**
     * The displayFinalStats method shows the results of the series of games.
     */
    private static void displayFinalStats(){
        String player1GameOrGames;
        String player2GameOrGames;
        displayFinalStatsBanner();
        if (player1Wins == 1)
            player1GameOrGames = "game";
        else
            player1GameOrGames = "games";
        if (player2Wins ==1)
            player2GameOrGames = "game";
        else
            player2GameOrGames = "games";
        System.out.println(player1Name + " won " + player1Wins +" " + player1GameOrGames +".");
        System.out.println(player2Name + " won " + player2Wins +" "+ player2GameOrGames + ".");
    }
    
    /**
     * The displayFinalStatsBanner method displays a nice-looking banner to be used at the top
     * of the output for displayFinalStats.
     * 
     * That's all.
     *
     */
    private static void displayFinalStatsBanner(){
        System.out.println("\n**************************\n* Overall Series Results *\n**************************");
    }


}
