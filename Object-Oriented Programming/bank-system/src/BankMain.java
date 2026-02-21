import java.util.Scanner;

public class BankMain extends BankService {
    static void main() {
        Scanner sc = new Scanner(System.in);



        // ====================================================================================================
        // HAS NOTING TO DO WITH JUST RAINBOW
        // ====================================================================================================
        printRainbow();
        System.out.println();
        System.out.println();



        line1();
        System.out.println();
        System.out.println(Color.YELLOW + "Do you want to open account?" + Color.RESET);
        System.out.println(Color.YELLOW + "Press[1] = Yes | Press[2] = No" + Color.RESET);
        System.out.println();
        line1();

        BankAccount account = openAccount();

        if (account == null) {
            return;
        }

        boolean running = true;
        while (running) {
            try {
                showMenu();
                System.out.println();
                System.out.print("Enter your choice: ");
                int choice = Integer.parseInt(sc.nextLine());

                if (choice == 1) {
                    handleDeposit(sc, account);

                } else if (choice == 2) {
                    handleWithdraw(sc, account);

                } else if (choice == 3) {
                    line1();
                    System.out.println(Color.YELLOW
                            + "\n"
                            + "Thank you for using our service."
                            + Color.RESET);
                    System.out.println();
                    line1();
                    System.out.println();
                    System.out.println();
                    printRainbow();
                    running = false;

                } else {
                    printError("Wrong choice, try again.");
                    System.out.println();
                }
            } catch (NumberFormatException e) {
                printError("Invalid choice! Please enter a number.");
                System.out.println();
            }
        }
    }
}