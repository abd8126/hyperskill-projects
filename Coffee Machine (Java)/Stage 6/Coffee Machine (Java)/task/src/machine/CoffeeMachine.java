#improved with less file size. lol

package machine;
import java.util.Scanner;

public class CoffeeMachine {
    //static method is created having arguments
    static int dollars = 550;
    static int water = 400;
    static int milk = 540;
    static int coffee_beans = 120;
    static int cups = 9;
    static int c = 0;

    public static void status(int water_required, int coffeeBeans_required, int cost, int cupsRequired, int milkRequired)
    {
        if (cups >= cupsRequired && coffee_beans >= coffeeBeans_required && milk >= milkRequired && water >= water_required) {
            System.out.println("I have enough resources, making you a coffee!");

            water = water - water_required;
            coffee_beans = coffee_beans - coffeeBeans_required;
            dollars = dollars + cost;
            cups = cups - cupsRequired;
            milk = milk - milkRequired;
        }
        else {
            if (water_required > water) {
                System.out.println("Sorry, not enough water!");
            }
            else if (milkRequired > milk) {
                System.out.println("Sorry, not enough milk!");
            }
            else if (coffeeBeans_required > coffee_beans) {
                System.out.println("Sorry, not enough coffee beans!");
            }
            else {
                System.out.println("Sorry, not enough cups!");
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // Initially Machine has :-->
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        String action;

        do {
            if (c > 0)
                System.out.println("\nWrite action (buy, fill, take, remaining, exit): ");
            action = sc.next();
            c = 1;

            switch (action) {

                case "remaining":
                    System.out.println("\nThe coffee machine has:\n" +
                            water + " of water\n" +
                            milk + " of milk\n" +
                            coffee_beans + " of coffee beans\n" +
                            cups + " of disposable cups\n" +
                            "$ " + dollars + " of money");
                    break;

                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                    String type = sc.next();

                    switch (type) {

                        case "1":    // In case of espresso.
                            status(250,16,4,1,0);
                            break;

                        case "2":    // In case of latte.
                            status(350,20,7,1,75);
                            break;

                        case "3":    // In case of cappuccino.
                            status(200,12,6,1,100);
                            break;

                        case "back" :
                            break;
                    }
                    break;

                case "fill":
                    System.out.println("Write how many ml of water do you want to add: ");
                    int waterAdded = sc.nextInt();
                    water = waterAdded + water;
                    System.out.println("Write how many ml of milk do you want to add: ");
                    int milkAdded = sc.nextInt();
                    milk = milkAdded + milk;
                    System.out.println("Write how many grams of coffee beans do you want to add: ");
                    int beansAdded = sc.nextInt();
                    coffee_beans = beansAdded + coffee_beans;
                    System.out.println("Write how many disposable cups of coffee do you want to add:");
                    int cupsAdded = sc.nextInt();
                    cups = cupsAdded + cups;

                    break;

                case "take":
                    System.out.println("I gave you $" + dollars);
                    dollars = 0;
                    break;

            }
        } while ( !(action.equals("exit")) );

    }
}
