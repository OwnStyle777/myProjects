package machine;

import java.util.Scanner;

public class CoffeMachineApp {

    static int water = 400;
    static int milk = 540;
    static int coffeeBeans = 120;
    static int money = 550;
    static int cups = 9;
    //these methods make specific type of caffe, remove resources and add money
    public static void getEspresso(){
        if(water >= 250 && coffeeBeans >= 16 && cups >= 1) {
            water -= 250;
            coffeeBeans -= 16;
            cups -= 1;
            money += 4;
        }
    }
    public static void getLatte(){
        if(water >= 350 && coffeeBeans >= 20 && milk >= 75 && cups >= 1) {
            water -= 350;
            milk -= 75;
            coffeeBeans -= 20;
            cups -= 1;
            money += 7;
        }
    }
    public static void getCappuccino(){
        if(water >= 200 && coffeeBeans >= 12 && milk >=100 && cups >= 1) {
            water -= 200;
            milk -= 100;
            coffeeBeans -= 12;
            cups -= 1;
            money += 6;
        }
    }
   //these methods checking if are available resources for coffee
    public static boolean checkResourcesForEspresso(){
        if (water < 250 && coffeeBeans >= 16 && cups >= 1){
            System.out.println("Sorry, not enough water");
            return false;
        }
        if (water  >= 250 && coffeeBeans < 16 && cups >= 1){
            System.out.println("Sorry, not enough coffee beans");
            return false;
        }
        if (water  >= 250 && coffeeBeans >= 16 && cups < 1){
            System.out.println("Sorry, not enough cups");
            return false;
        }
        return true;
    }

    public static boolean checkResourcesLatte(){
        if (water < 350 && milk >= 75 && coffeeBeans >= 20 && cups >= 1){
            System.out.println("Sorry, not enough water");
            return false;
        }
        if (water  >= 350 && milk >= 75 && coffeeBeans < 16 && cups >= 1){
            System.out.println("Sorry, not enough coffee beans");
            return false;
        }
        if (water  >= 250 &&  milk >= 75 && coffeeBeans >= 16 && cups < 1){
            System.out.println("Sorry, not enough cups");
            return false;
        }
        if (water >= 350 && milk < 75 && coffeeBeans >= 20 && cups >= 1){
            System.out.println("Sorry, not enough milk");
            return false;
        }
        return true;
    }

    public static boolean checkResourcesCappuccino(){
        if (water < 200 && milk >= 100 && coffeeBeans >= 12 && cups >= 1){
            System.out.println("Sorry, not enough water");
            return false;
        }
        if (water  >= 200 && milk >= 100 && coffeeBeans < 12 && cups >= 1){
            System.out.println("Sorry, not enough coffee beans");
            return false;
        }
        if (water  >= 200 &&  milk >= 100 && coffeeBeans >= 12 && cups < 1){
            System.out.println("Sorry, not enough cups");
            return false;
        }
        if (water >= 200 && milk < 100 && coffeeBeans >= 12 && cups >= 1){
            System.out.println("Sorry, not enough milk");
            return false;
        }
        if ((water < 200 && milk < 100 && cups < 1 && coffeeBeans < 12) ||(water >= 200 && milk < 100 && cups < 1 && coffeeBeans < 12) || (water >= 200 && milk >= 100 && cups < 1 && coffeeBeans < 12)){
            System.out.println("Sorry, not enough resources");
            return false;
        }
        return true;
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
      // logic of the program
        while (!exit) {

            System.out.println("Write action (buy, fill, take, remaining, exit): ");

            String usersOption = scanner.nextLine();

            if (usersOption.equals("fill")) {
                System.out.println("Write how many ml of water you want to add:");
                int waterAdded = scanner.nextInt();
                scanner.nextLine();
                water += waterAdded;

                System.out.println("Write how many ml of milk you want to add:");
                int milkAdded = scanner.nextInt();
                scanner.nextLine();
                milk += milkAdded;

                System.out.println("Write how many grams of coffee beans you want to add: ");
                int coffeeBeansAdded = scanner.nextInt();
                scanner.nextLine();
                coffeeBeans += coffeeBeansAdded;

                System.out.println("Write how many disposable cups you want to add: ");
                int cupsAdded = scanner.nextInt();
                scanner.nextLine();
                cups += cupsAdded;
            }
            else if (usersOption.equals("buy")) {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu");
                String caffeType = scanner.nextLine();
                if (caffeType.equals("1")){
                    if(checkResourcesForEspresso()){
                        System.out.println("I have enough resources, making you a coffee!");
                        getEspresso();}
                }
                else if (caffeType.equals("2")) {
                    if (checkResourcesCappuccino()) {
                        System.out.println("I have enough resources, making you a coffee!");
                        getLatte();
                    }
                }
                else if (caffeType.equals("3")) {
                    if (checkResourcesLatte()){
                        System.out.println("I have enough resources, making you a coffee!");
                        getCappuccino();
                    }
                }
                else if (caffeType.equals("back")){

                }
            }
            else if (usersOption.equals("take")) {

                System.out.println("I gave you " + money);
                money -= money;

            }
            else  if (usersOption.equals("remaining")){
                System.out.println("The coffee machine has:");
                System.out.println(water + " ml of water");
                System.out.println(milk + " ml of milk");
                System.out.println(coffeeBeans + " g of coffee beans");
                System.out.println(cups + " disposable cups");
                System.out.println("$" + money + " of money");
            }
            else if (usersOption.equals("exit")){
                exit = true;
            }
        }
    }
}
