package CoffeeShop;

import java.util.Scanner;
import  java.util.ArrayList;

public class CoffeeShop {
    static Scanner sc = new Scanner(System.in);

    public static Espresso orderEspresso() {
        System.out.print("Enter a size: ");
        String size = sc.next();
        Espresso espresso = new Espresso(size);
        System.out.print("Press 'y' or 'Y' for adding a shot: ");
        String answer = sc.next();

        if (answer.equalsIgnoreCase("Y")) {
            System.out.print("How many shots for adding in Espresso: ");
            int shot = sc.nextInt();
            espresso.addShot(shot);
        }
        return espresso;
    }

    public static Frappuccino orderFrappuccino() {
        System.out.print("Enter a size: ");
        String size = sc.next();
        System.out.print("Do you would like to add whipped cream [y/Y]? ");
        String answer = sc.next();
        boolean whip = (answer.equalsIgnoreCase("Y"));
        return new Frappuccino("Frappuccino", size, whip);
    }

    static void main() {
        ArrayList<Drink> orders = new ArrayList<>();
        int espressoCount = 0;
        int frappuccinoCount = 0;

        while (true) {
            System.out.print("""
                    ==================================================\
                    
                    Press 1 for ordering Espresso\
                    
                    Press 2 for ordering Frappuccino\
                    
                    ==================================================\
                    
                    Enter an option:\s""");
            int menu = sc.nextInt();

            if (menu == 1) {
                Espresso espresso = orderEspresso();
                orders.add(espresso);
                espressoCount++;
                System.out.println(espresso);
            } else if (menu == 2) {
                Frappuccino frappuccino = orderFrappuccino();
                orders.add(frappuccino);
                frappuccinoCount++;
                System.out.println(frappuccino);
            } else {
                break;
            }
            System.out.print("Do you want to order more [y/Y]? ");
            String more = sc.next();

            if (!(more.equalsIgnoreCase("Y")))
                break;
        }
        double total = 0;

        for (Drink drink : orders) {
            total += drink.calculateFinalPrice();
        }
        System.out.println("==================================================");
        System.out.println("You ordered " + espressoCount + " Espresso");
        System.out.println("You ordered " + frappuccinoCount +" Frappuccino");
        System.out.println("Total price: " + total );
        System.out.println("==================================================");
    }
}
