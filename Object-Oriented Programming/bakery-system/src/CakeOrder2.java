import java.util.Scanner;

public class CakeOrder2 {
    Scanner sc = new Scanner(System.in);
    boolean loop = true;
    int flavor_number;
    String flavor;

    public void selectFlavor() {
        System.out.println("Press 1 for Chocolate");
        System.out.println("Press 2 for Vanilla");
        System.out.println("Press 3 for Strawberry");
        System.out.println("Press 4 for Lemon");
        System.out.println("Press 5 for Red Velvet");

        while (loop) {
            System.out.print("Enter a flavor number: ");
            flavor_number = sc.nextInt();

            if (flavor_number == 1) {
                flavor = "Chocolate";
                break;
            } else if (flavor_number == 2) {
                flavor = "Vanilla";
                break;
            } else if (flavor_number == 3) {
                flavor = "Strawberry";
                break;
            } else if (flavor_number == 4) {
                flavor = "Lemon";
                break;
            } else if (flavor_number == 5) {
                flavor = "Red Velvet";
                break;
            }
        }
    }

    // ====================================================================================================
    // MAIN METHOD
    // ====================================================================================================
    static void main() {
        int choice;
        Scanner sc = new Scanner(System.in);
        CakeOrder2 bakery = new CakeOrder2();
        String message;
        double pound;
        int piece;

        System.out.println("Press 1 to order Birthday Cake");
        System.out.println("Press 2 to order Cup Cake");
        System.out.println("Press 3 to order Brownie");
        System.out.print("Enter an option: ");
        choice = sc.nextInt();

        if (choice == 1) {
            System.out.println();
            bakery.selectFlavor();
            System.out.println();
            System.out.print("Enter a message: ");
            message = sc.next();
            System.out.print("How many pound: ");
            pound = sc.nextDouble();
            System.out.println();
            BirthdayCake order1 = new BirthdayCake(message, pound, bakery.flavor, 350);
            System.out.println(order1);
        } else if (choice == 2) {
            System.out.println();
            bakery.selectFlavor();
            System.out.println();
            System.out.print("How many pieces: ");
            piece = sc.nextInt();
            System.out.println();
            CupCake order2 = new CupCake(piece, bakery.flavor, 70);
            System.out.println(order2);
        } else if (choice == 3) {
            System.out.println();
            bakery.selectFlavor();
            System.out.println();
            System.out.print("How many pieces: ");
            piece = sc.nextInt();
            System.out.print("""
                        Would you like fudgy brownies?\
                        
                        Press 1 to confirm\
                        
                        Press 2 to skip\
                        
                        Select an option:\s""");
            int want_fudgy = sc.nextInt();
            System.out.println();
            Brownie order3 = new Brownie(piece, bakery.flavor, 100);
            if (want_fudgy == 1) {
                order3.isFudgy();
            }
            System.out.println(order3);
        } else {
            System.out.println("Wrong option!! Try again!!");
        }
    }
}
