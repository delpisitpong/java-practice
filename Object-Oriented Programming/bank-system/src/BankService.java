import java.util.Scanner;

public class BankService extends Format{
    // ====================================================================================================
    // OPEN ACCOUNT
    // ====================================================================================================
    static BankAccount openAccount() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter your choice: ");
                int choice = Integer.parseInt(sc.nextLine());

                if (choice == 1) {
                    line1();
                    System.out.print("Enter account name: ");
                    String accountName = sc.nextLine();
                    BankAccount account = new BankAccount(accountName);
                    line1();
                    System.out.println();
                    System.out.println(Color.YELLOW + "Account successfully created" + Color.RESET);
                    System.out.println(Color.YELLOW + "Account name: " + accountName + Color.RESET);
                    System.out.println();
                    return account;

                } else if (choice == 2) {
                    System.out.println();
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
                    return null;

                } else {
                    printError("Wrong choice, try again.");
                }
            } catch (NumberFormatException e) {
                printError("Invalid input! Please enter a number.");
            }
        }
    }

    // ====================================================================================================
    // MENU
    // ====================================================================================================
    static void showMenu() {
        line1();
        System.out.println();
        System.out.println(Color.YELLOW + "Please select an option" + Color.RESET);
        System.out.println(Color.YELLOW + "Press[1] = Deposit | Press[2] = Withdraw | Press[3] = Exit" + Color.RESET);
        System.out.println();
        line1();
    }

    // ====================================================================================================
    // DEPOSIT
    // ====================================================================================================
    static void handleDeposit(Scanner sc, BankAccount account) {
        while (true) {
            try {
                System.out.println();
                line1();
                System.out.println();
                System.out.print("Enter your amount to deposit: ");
                double amount = Double.parseDouble(sc.nextLine());
                account.deposit(amount);
                return;
            } catch (NumberFormatException e) {
                printError("Invalid amount! Please enter a number.");
                System.out.println();
            } catch (BankException e) {
                printError("Transaction Error: " + e.getMessage());
                System.out.println();
            }
        }
    }

    // ====================================================================================================
    // WITHDRAW
    // ====================================================================================================
    static void handleWithdraw(Scanner sc, BankAccount account) {
        boolean loop = true;

        while (loop) {
            try {
                System.out.println();
                line1();
                System.out.println();
                System.out.print("Enter your amount to withdraw: ");
                double amount = Double.parseDouble(sc.nextLine());
                account.withdraw(amount);
                return;
            } catch (NumberFormatException e) {
                printError("Invalid amount! Please enter a number.");
                System.out.println();
            } catch (BankException e) {
                printError("Transaction Error: " + e.getMessage());
                System.out.println();
                loop = false;
            }
        }
    }
}