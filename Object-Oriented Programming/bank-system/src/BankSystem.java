static void line() {
    System.out.println(ChangeColor.PURPLE + "=".repeat(60) + ChangeColor.RESET);
}

static void printError(String msg) {
    System.out.println(ChangeColor.RED + msg + ChangeColor.RESET);
}

// ============================== OPEN ACCOUNT ==============================
static BankAccount openAccount(Scanner sc) {
    while (true) {
        try {
            System.out.print(ChangeColor.YELLOW + "Enter your choice: " + ChangeColor.RESET);
            int choice = Integer.parseInt(sc.nextLine());

            if (choice == 1) {
                line();
                System.out.print(ChangeColor.YELLOW + "Enter account name: " +  ChangeColor.RESET);
                String accountNumber = sc.nextLine();
                BankAccount account = new BankAccount(accountNumber);
                line();
                System.out.println();
                System.out.println(ChangeColor.CYAN + "Account successfully created" + ChangeColor.RESET);
                System.out.println();
                return account;

            } else if (choice == 2) {
                line();
                System.out.println(ChangeColor.CYAN
                        + "\n"
                        + "Thank you for using our service."
                        + ChangeColor.RESET);
                return null;

            } else {
                printError("Wrong choice, try again.");
            }
        } catch (NumberFormatException e) {
            printError("Invalid input! Please enter a number.");
        }
    }
}

// ============================== MENU ==============================
static void showMenu() {
    line();
    System.out.println();
    System.out.println(ChangeColor.CYAN + "Please select an option" + ChangeColor.RESET);
    System.out.println(ChangeColor.CYAN
            + "Press[1] = Deposit | Press[2] = Withdraw | Press[3] = Exit"
            + ChangeColor.RESET);
    System.out.println();
    line();
}

// ============================== DEPOSIT ==============================
static void handleDeposit(Scanner sc, BankAccount account) {
    while (true) {
        try {
            line();
            System.out.print(ChangeColor.YELLOW + "Enter your amount to deposit: " + ChangeColor.RESET);
            double amount = Double.parseDouble(sc.nextLine());
            account.deposit(amount);
            return;
        } catch (NumberFormatException e) {
            printError("Invalid amount! Please enter a number.");
        } catch (BankException e) {
            printError("Transaction Error: " + e.getMessage());
        }
    }
}

// ============================== WITHDRAW ==============================
static void handleWithdraw(Scanner sc, BankAccount account) {
    boolean loop = true;
    while (loop) {
        try {
            line();
            System.out.print(ChangeColor.YELLOW + "Enter your amount to withdraw: " + ChangeColor.RESET);
            double amount = Double.parseDouble(sc.nextLine());
            account.withdraw(amount);
            return;
        } catch (NumberFormatException e) {
            printError("Invalid amount! Please enter a number.");
        } catch (BankException e) {
            printError("Transaction Error: " + e.getMessage());
            loop = false;
        }
    }
}

// ============================== MAIN ==============================
void main() {
    Scanner sc = new Scanner(System.in);

    line();
    System.out.println();
    System.out.println(ChangeColor.CYAN + "Do you want to open account?" + ChangeColor.RESET);
    System.out.println(ChangeColor.CYAN + "Press[1] = Yes | Press[2] = No" + ChangeColor.RESET);
    System.out.println();
    line();

    BankAccount account = openAccount(sc);
    if (account == null) return;

    boolean running = true;
    while (running) {
        try {
            showMenu();
            System.out.print(ChangeColor.YELLOW + "Enter your choice: " + ChangeColor.RESET);
            int choice = Integer.parseInt(sc.nextLine());

            if (choice == 1) {
                handleDeposit(sc, account);

            } else if (choice == 2) {
                handleWithdraw(sc, account);

            } else if (choice == 3) {
                line();
                System.out.println(ChangeColor.CYAN
                        + "\n"
                        + "Thank you for using our service."
                        + ChangeColor.RESET);
                running = false;

            } else {
                printError("Wrong choice, try again.");
            }

        } catch (NumberFormatException e) {
            printError("Invalid choice! Please enter a number.");
        }
    }
}