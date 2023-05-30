import java.util.Scanner;

public class App {
    public static double dollars = 1000;
    public static double bet = 0;
    public static double tip = 0;
    public static String guess = "";
    public static boolean won = false;

    public static final String unbold_reset= "\033[0;0m\u001B[0m";
    public static final String bold_cyan = "\033[0;1m\u001B[36m";
    public static final String bold_green = "\033[0;1m\u001B[32m";
    public static final String bold_red = "\033[0;1m\u001B[31m";
    public static final String bold_black = "\033[0;1m\u001B[30m";

    public static final String green = "\u001B[32m";
    public static final String red = "\u001B[31m";
    public static final String reset = "\u001B[0m";
    public static final String purple = "\u001B[35m";
    public static final String cyan = "\u001B[36m";
    public static final String black = "\u001B[30m";
    public static final String white = "\u001B[37m";

    public static final String black_background = "\u001B[40m";
    public static final String red_background = "\u001B[41m";
    public static final String green_background = "\u001B[42m";
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner (System.in);
        System.out.println(green + "Welcome to Casino" + reset);
        System.out.println(green + "You have " + red + "1,000$" + reset);
        System.out.println(green + "Your goal is to reach " + red + "2,000$." + green + " Good Luck!" + reset);
        System.out.println(purple + "-------------CASINO-------------"+ reset);
        System.out.println("Enter 1 = DICE");
        System.out.println("Enter 2 = ROULETTE");
        System.out.println("Enter 3 = JACKPOT");
        System.out.println("Enter 4 = HAZZARD DICE");
        System.out.println("Enter 5 = UNDER & OVER");
        System.out.println("Enter 6 or ANYTHING ELSE = " + red + "END" + reset);
        
            int whichGame = sc.nextInt();
            
            switch (whichGame) {
                case 1 -> dice();
                case 2 -> roulette();
                case 3 -> jackpot();
                case 4 -> hazzardDice();
                case 5 -> underAndOver();
                default -> end();
            }
    }
    //---------------------------------------------------------------
    public static void start() {
        if(won == true){
            dollars = 1000;
            won = false;
        }
        Scanner sc = new Scanner (System.in);
        System.out.println(purple + "-------------CASINO-------------"+ reset);
        System.out.println("Enter 1 = DICE");
        System.out.println("Enter 2 = ROULETTE");
        System.out.println("Enter 3 = JACKPOT");
        System.out.println("Enter 4 = HAZZARD DICE");
        System.out.println("Enter 5 = UNDER & OVER");
        System.out.println("Enter 6 or ANYTHING ELSE = " + red + "END" + reset);

            int whichGame = sc.nextInt();

            switch (whichGame) {
                case 1 -> dice();
                case 2 -> roulette();
                case 3 -> jackpot();
                case 4 -> hazzardDice();
                case 5 -> underAndOver();
                default -> end();
            }
    }
    //-------DICE-------
    public static void dice() {
        Scanner sc = new Scanner (System.in);
        boolean tooMuch = true;
        System.out.println(purple + "------------DICE------------" + reset);
        System.out.println(bold_cyan +"You have 2 DICE and your task is to roll the SAME numbers" + unbold_reset);
        System.out.println("WIN = 1.6 x BET");
        System.out.println("LOSE = 0.8 x BET");
        while(tooMuch){
            System.out.print(bold_cyan + "Write how much you want to BET: " + reset);
            bet = sc.nextInt();
            tooMuch = false;
            if(bet > dollars){
                tooMuch = true;
                System.out.println("You don't have enough money, try again");
            }
        }
        int cube1 = (int)Math.floor(Math.random() * 6) + 1;
        int cube2 = (int)Math.floor(Math.random() * 6) + 1;
        System.out.println(green + "First cube rolled " + bold_green + cube1 + unbold_reset + green + " and second cube rolled " + bold_green + cube2 + unbold_reset + reset);
        if(cube1 == cube2){
            System.out.println(bold_green + "---YOU WON!---" + unbold_reset);
            dollars = dollars + 1.6 * bet ;
        }else{
            System.out.println(bold_red + "---YOU LOST---" + unbold_reset);
            dollars = dollars - 0.8 * bet ;
        }
        if(dollars >= 2000){
            win();
        }
        System.out.println(bold_cyan + "Current cash = " + unbold_reset + bold_green + dollars + "$" + unbold_reset);
        System.out.println("Enter 1 = Try Again");
        System.out.println("Enter 2 or ANYTHING ELSE = Back to CASINO");
        int again = sc.nextInt();
    
            switch (again) {
                case 1 -> dice();
                case 2 -> start();
                default -> start();
            }
        }
    //-------ROULETTE-------
    public static void roulette() {
        Scanner sc = new Scanner (System.in);
        String win = "red";
        boolean tooMuch = true;
        boolean notExist = true;
        System.out.println(purple + "----------ROULETTE------------" + reset);
        System.out.println(bold_cyan + "There are 37 parts - 18 of them are BLACK and 18 of them are RED and 1 is GREEN. Guess where the ball will land." + unbold_reset);
        System.out.println("WIN = 1.3 x BET");
        System.out.println("WIN when you guess GREEN = 3.5 x BET");
        System.out.println("LOSE = 0.4 x BET");
        while(tooMuch){
            System.out.print(bold_cyan + "Write how much you want to BET: " + reset);
            bet = sc.nextInt();
            tooMuch = false;
            if(bet > dollars){
                tooMuch = true;
                System.out.println("You don't have enough money, try again");
            }
        }
        while(notExist){
            System.out.print("Write which color (" + bold_green + " GREEN " + reset + "/" + bold_red + " RED " + reset + "/" + bold_black + " BLACK " + reset + "): ");
            guess = sc.next();
            notExist = false;
            if(guess.toUpperCase().equals("BLACK") || guess.toUpperCase().equals("RED") || guess.toUpperCase().equals("GREEN") ){
            }else{
                notExist = true;
                System.out.println("Wrong COLOR, try again");
            }
        }
        int ball = (int)Math.floor(Math.random() * 38);
        for (int i = 0; i <= 37; i++) {
            if(i == 0){
                System.out.print(green_background + "  " + i + " " + reset);
            }else if(i % 2 == 0){
                if(i <= 9){
                    System.out.print(black_background + "  " + i + " " + reset);
                }else{
                    System.out.print(black_background + " " + i + " " + reset);
                }
            }else{
                if(i <= 9){
                    System.out.print(red_background + "  " + i + " " + reset);
                }else{
                    System.out.print(red_background + " " + i + " " + reset);
                }
            }
        }
        System.out.println();
        for (int i = 0; i <= 37; i++) {
            if(i == 0){
                if(i == ball){
                    System.out.print(green_background + "  O " + reset);
                }else{
                    System.out.print(green_background + "    " + reset);
                }
            }else if(i % 2 == 0){
                if(i == ball){
                    System.out.print(black_background + "  O " + reset);
                }else{
                    System.out.print(black_background + "    " + reset);
                }
            }else{
                if(i == ball){
                    System.out.print(red_background + "  O " + reset);
                }else{
                    System.out.print(red_background + "    " + reset);
                }
            }
        }
        System.out.println();
        System.out.println(bold_cyan + "BALL fell to the: " + ball + reset);
            if(ball == 0){
                System.out.println("Selected Color: " + bold_green + "GREEN"  + reset);
                win = "GREEN";
            }else if(ball % 2 == 0){
                System.out.println("Selected Color: " + bold_black +"BLACK" + reset);
                win = "BLACK";
            }else{
                System.out.println("Selected Color: " + bold_red + "RED" + reset);
                win = "RED";
            }
        if(guess.toUpperCase().equals(win)){
            System.out.println(bold_green + "---YOU WON!---" + unbold_reset);
            if(win.equals("BLACK") || win.equals("RED")){
                dollars = dollars + 1.3 * bet ;
            }else{
                dollars = dollars + 3.5 * bet ;
            } 
        }else{
            System.out.println(bold_red + "---YOU LOST---" + unbold_reset);
            dollars = dollars - 0.4 * bet ;
        }
        if(dollars >= 2000){
            win();
        }
        System.out.println(bold_cyan + "Current cash = " + unbold_reset + bold_green + dollars + "$" + unbold_reset);
        System.out.println("Enter 1 = Try Again");
        System.out.println("Enter 2 or ANYTHING ELSE = Back to CASINO");
        int again = sc.nextInt();
    
            switch (again) {
                case 1 -> roulette();
                case 2 -> start();
                default -> start();
            }
        }
    //-------JACKPOT-------
    public static void jackpot(){
        Scanner sc = new Scanner (System.in);
        boolean tooMuch = true;
        String apple = bold_red + " O " + reset;
        String cross = bold_cyan + " X " + reset;
        String seven = bold_green + " " + 7 + " " + reset;
        System.out.println(purple + "----------JACKPOT------------" + reset);
        System.out.println(bold_cyan + "Get 3 matching symbols and win" + unbold_reset);
        System.out.println("WIN = 1.6 x BET");
        System.out.println("WIN when you hit JACKPOT = 2.5 x BET");
        System.out.println("LOSE = 0.6 x BET");
        while(tooMuch){
            System.out.print(bold_cyan + "Write how much you want to BET: " + reset);
            bet = sc.nextInt();
            tooMuch = false;
            if(bet > dollars){
                tooMuch = true;
                System.out.println("You don't have enough money, try again");
            }
        }
        String firstValue = "";
        String secondValue = "";
        String thirdValue = "";
        int jackpot1 = (int)Math.floor(Math.random() * 3) + 1;
        int jackpot2 = (int)Math.floor(Math.random() * 3) + 1;
        int jackpot3 = (int)Math.floor(Math.random() * 3) + 1;
        switch(jackpot1){
            case 1 -> firstValue = apple;
            case 2 -> firstValue = cross;
            case 3 -> firstValue = seven;
        }
        switch(jackpot2){
            case 1 -> secondValue = apple;
            case 2 -> secondValue = cross;
            case 3 -> secondValue = seven;
        }
        switch(jackpot3){
            case 1 -> thirdValue = apple;
            case 2 -> thirdValue = cross;
            case 3 -> thirdValue = seven;
        }
        if(firstValue == seven && secondValue == seven && thirdValue == seven){
            System.out.println(bold_green + "---YOU WON JACKPOT!---" + unbold_reset);
            dollars = dollars + 2.5 * bet;
        }else if(jackpot1 == jackpot2 && jackpot1 == jackpot3 && firstValue != seven){
            System.out.println(bold_green + "---YOU WON!---" + unbold_reset);
            dollars = dollars + 1.6 * bet;
        }else{
            System.out.println(bold_red + "---YOU LOST---" + unbold_reset);
            dollars = dollars - 0.6 * bet;
        }
        System.out.println(firstValue + secondValue + thirdValue);
        if(dollars >= 2000){
            win();
        }
        System.out.println(bold_cyan + "Current cash = " + unbold_reset + bold_green + dollars + "$" + unbold_reset);
        System.out.println("Enter 1 = Try Again");
        System.out.println("Enter 2 or ANYTHING ELSE = Back to CASINO");
        int again = sc.nextInt();
    
            switch (again) {
                case 1 -> jackpot();
                case 2 -> start();
                default -> start();
            }
        }    
        //-------HAZZARD DICE-------
        public static void hazzardDice() {
            Scanner sc = new Scanner (System.in);
            boolean tooMuch = true;
            boolean dices = true;
            System.out.println(purple + "------------HAZZARD DICE------------" + reset);
            System.out.println(bold_cyan +"We roll 2 dice and you have to guess what sum you get" + unbold_reset);
            System.out.println("WIN = 1.4 x BET");
            System.out.println("LOSE = 0.6 x BET");
            while(tooMuch){
                System.out.print(bold_cyan + "Write how much you want to BET: " + reset);
                bet = sc.nextInt();
                tooMuch = false;
                if(bet > dollars){
                    tooMuch = true;
                    System.out.println("You don't have enough money, try again");
                }
            }
            while(dices){
                System.out.print(bold_cyan + "Write your GUESS (2 - 12): " + reset);
                tip = sc.nextInt();
                dices = false;
                if(tip < 2 || tip > 12){
                    dices = true;
                    System.out.println("You didn't guess a number between 2 - 12, try again");
                }
            }
            int cube1 = (int)Math.floor(Math.random() * 6) + 1;
            int cube2 = (int)Math.floor(Math.random() * 6) + 1;
            System.out.println(green + "First cube rolled " + bold_green + cube1 + unbold_reset + green + " and second cube rolled " + bold_green + cube2 + unbold_reset + reset);
            int total = cube1 + cube2;
            System.out.println(bold_cyan + "Total SUM is: " + total + reset);
            if(total == tip){
                System.out.println(bold_green + "---YOU WON!---" + unbold_reset);
                dollars = dollars + 1.4 * bet ;
            }else{
                System.out.println(bold_red + "---YOU LOST---" + unbold_reset);
                dollars = dollars - 0.6 * bet ;
            }
            if(dollars >= 2000){
                win();
            }
            System.out.println(bold_cyan + "Current cash = " + unbold_reset + bold_green + dollars + "$" + unbold_reset);
            System.out.println("Enter 1 = Try Again");
            System.out.println("Enter 2 or ANYTHING ELSE = Back to CASINO");
            int again = sc.nextInt();
        
                switch (again) {
                    case 1 -> hazzardDice();
                    case 2 -> start();
                    default -> start();
                }
            }
            //-------UNDER & OVER-------
        public static void underAndOver() {
            Scanner sc = new Scanner (System.in);
            boolean tooMuch = true;
            boolean notExist = true;
            System.out.println(purple + "------------UNDER & OVER------------" + reset);
            System.out.println(bold_cyan + "Guess whether you will dial a number greater than or less than 50 (1 - 100)" + unbold_reset);
            System.out.println("WIN = 1.5 x BET");
            System.out.println("LOSE = 0.5 x BET");
            while(tooMuch){
                System.out.print(bold_cyan + "Write how much you want to BET: " + reset);
                bet = sc.nextInt();
                tooMuch = false;
                if(bet > dollars){
                    tooMuch = true;
                    System.out.println("You don't have enough money, try again");
                }
            }
            while(notExist){
                System.out.print("Write LESS or MORE: ");
                guess = sc.next();
                notExist = false;
                if(guess.toUpperCase().equals("LESS") || guess.toUpperCase().equals("MORE")){
                }else{
                    notExist = true;
                    System.out.println("Wrong GUESS, try again");
                }
            }
            int num = (int)Math.floor(Math.random() * 100) + 1;
            System.out.println(bold_cyan + "You dialed a number: " + num + reset);
            if(num > 50 && guess.toUpperCase().equals("MORE")){
                System.out.println(bold_green + "---YOU WON!---" + unbold_reset);
                dollars = dollars + 1.5 * bet ;
            }else{
                System.out.println(bold_red + "---YOU LOST---" + unbold_reset);
                dollars = dollars - 0.5 * bet ;
            }
            if(dollars >= 2000){
                win();
            }
            System.out.println(bold_cyan + "Current cash = " + unbold_reset + bold_green + dollars + "$" + unbold_reset);
            System.out.println("Enter 1 = Try Again");
            System.out.println("Enter 2 or ANYTHING ELSE = Back to CASINO");
            int again = sc.nextInt();
        
                switch (again) {
                    case 1 -> underAndOver();
                    case 2 -> start();
                    default -> start();
                }
            }
            //----------WIN----------
            public static void win() {
                Scanner sc = new Scanner (System.in);
                System.out.println(purple + "-------------YOU WON-------------"+ reset);
                System.out.println(green + "You have " + red + dollars + "$" + reset);
                System.out.println("Enter 1 = PLAY AGAIN");
                System.out.println("Enter 2 or ANYTHING ELSE = END");

                won = true;

                int whichGame = sc.nextInt();
        
                    switch (whichGame) {
                        case 1 -> start();
                        default -> end();
                    }
            }
            //--------------------END-------------------
            public static void end() {
                Scanner sc = new Scanner (System.in);
                System.out.println(purple + "Thanks for Playing :)"+ reset);
                System.exit(0);
            }
    }