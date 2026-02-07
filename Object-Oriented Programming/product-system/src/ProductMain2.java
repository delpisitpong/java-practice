void main() {
    Product product1 = new Product();
    product1.name = "Pens";
    product1.price = 10.5;
    product1.quantity = 50;
    Product product2 = new Product();
    product2.name = "Notebooks";
    product2.price = 25.75;
    product2.quantity = 20;
    System.out.println("""
            Welcome to Mini Shop\
            
            ==============================\
            
            Press [1] to buy Pen\
            
            Press [2] to buy Notebook""");
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter a number: ");
    int amount = scanner.nextInt();

    while (true) {
        if (amount == 1) {
            System.out.println("==============================");
            System.out.print("How many Pens do you want to buy? ");
            int items = scanner.nextInt();
            product1.sell(items);
            System.out.println("==============================");
            product1.showInfo();
            break;
        } else if (amount == 2) {
            System.out.println("==============================");
            System.out.print("How many Notebook do you want to buy? ");
            int items = scanner.nextInt();
            product2.sell(items);
            System.out.println("==============================");
            product2.showInfo();
            break;
        } else {
            System.out.print("Invalid number! Enter a number, again: ");
            amount = scanner.nextInt();
        }
    }
}
