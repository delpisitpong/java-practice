void main() {
    Scanner sc = new Scanner(System.in);

    System.out.println("Birthday Cake's Details");
    System.out.print("Enter a message on cake: ");
    String message = sc.nextLine();
    System.out.print("Enter a flavor: ");
    String flavor = sc.next();
    System.out.print("How many pounds: ");
    double pound = sc.nextDouble();
    BirthdayCake order1 = new BirthdayCake(message, pound, flavor, 350);
    System.out.println(order1);

    // ====================================================================================================
    System.out.println();
    // ====================================================================================================

    System.out.println("Cup Cake's Details");
    System.out.print("Enter a flavor: ");
    String cupcake_flavor = sc.next();
    System.out.print("How many pieces: ");
    int cupcake_piece = sc.nextInt();
    CupCake order2 = new CupCake(cupcake_piece, cupcake_flavor, 65);
    System.out.println(order2);

    // ====================================================================================================
    System.out.println();
    // ====================================================================================================

    System.out.println("Brownie's Details");
    System.out.print("Enter a flavor: ");
    String brownie_flavor = sc.next();
    System.out.print("How many pieces: ");
    int brownie_piece = sc.nextInt();
    System.out.print("""
            Would you like fudgy brownies?\
            
            Press 1 to confirm\
            
            Press 2 to skip\
            
            Select an option:\s""");
    int choice = sc.nextInt();
    Brownie order3 = new Brownie(brownie_piece, brownie_flavor, 100);

    if (choice == 1) {
        order3.isFudgy();
    }
    System.out.println(order3);

    // ====================================================================================================
    System.out.println();
    // ====================================================================================================

    System.out.println("Total price = " + (order1.calculateTotalPrice() +
            order2.calculateTotalPrice() +
            order3.calculateTotalPrice()));
}
