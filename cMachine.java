package machine;

import java.util.Scanner;

public class cMachine {
    int waterR=0, milkR=0, coffeeR=0, cupsR=0, changeR=0;

    public cMachine() {
        this.waterR=400;
        this.milkR=540;
        this.coffeeR=120;
        this.cupsR=9;
        this.changeR=550;
    }

    public void createEspresso() {
        if(this.waterR>=250 && this.cupsR>=1 && this.coffeeR>=16){
            this.waterR-=250;
            this.cupsR-=1;
            this.coffeeR-=16;
            this.changeR+=4;
        } else {
            System.out.println("I have not enough resources, making you a coffee!");
        }
    }

    public void createLatte() {
        if(this.waterR>=350 && this.cupsR>=1 && this.milkR>=75 && this.coffeeR>=20){
            this.waterR-=350;
            this.cupsR-=1;
            this.coffeeR-=20;
            this.changeR+=7;
            this.milkR-=75;
        } else {
            System.out.println("I have not enough resources, making you a coffee!");
        }
    }
    public void createCappuccino() {
        if(this.waterR>=200 && this.cupsR>=1 && this.milkR >=100 && this.coffeeR>=12){
            this.waterR-=200;
            this.cupsR-=1;
            this.coffeeR-=12;
            this.changeR+=6;
            this.milkR-=100;
        } else {
            System.out.println("I have not enough resources, making you a coffee!");
        }
    }

    public void printStatusMessage() {
        System.out.println("The coffee machine has:\n" +
                this.waterR+ " ml of water\n" +
                this.milkR+ " ml of milk\n" +
                this.coffeeR+ " g of coffee beans\n" +
                this.cupsR+ " disposable cups\n" +
                "$"+this.changeR+ " of money\n\n");
    }

    public void general(String userInput) {

        Scanner scanner =new Scanner(System.in);

        //fill action
        if(userInput.contains("fill")){
            System.out.println("Write how many ml of water you want to add:");
            int fill = Integer.parseInt(scanner.next());
            waterR+=fill;
            System.out.println("Write how many ml of milk you want to add:");
            fill = Integer.parseInt(scanner.next());
            milkR+=fill;
            System.out.println("Write how many grams of coffee beans you want to add:");
            fill = Integer.parseInt(scanner.next());
            coffeeR+=fill;
            System.out.println("Write how many ml disposable cups you want to add:");
            fill = Integer.parseInt(scanner.next());
            cupsR+=fill;
            //take action
        } else if (userInput.contains("take")) {
            System.out.println("I gave you $"+ changeR);
            changeR=0;

            //buy action
        } else if (userInput.contains("buy")){
            System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
            String secondInput = scanner.next();
            if(secondInput.contains("1")){
                createEspresso();
            } else if (secondInput.contains("2")) {
                createLatte();
            } else if (secondInput.contains("3")) {
                createCappuccino();
            }

            //retrieve remaining resourses
        } else if (userInput.contains("remaining")) {
            printStatusMessage();
        }
    }
}
