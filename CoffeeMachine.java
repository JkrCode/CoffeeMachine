package machine;
import java.util.Scanner;

public class CoffeeMachine {


    public static void main(String[] args) {
        cMachine machine = new cMachine();
        Scanner scanner = new Scanner(System.in);
        String userInput = "0";

        while (!userInput.contains("exit")){
            System.out.println("Write action (buy, fill, take, remaining, exit)");
            userInput=scanner.nextLine();

            machine.general(userInput);

        }
    }
}


