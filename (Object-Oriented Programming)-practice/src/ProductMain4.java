public static void setting_product(Product... products) {
    String[] names = {"Pens", "Pencils", "Markers", "Highlighters"};
    double[] prices = {25.5, 17.25, 30, 35};
    int[] quantities = {20, 35, 10, 40};

    for (int i = 0; i < products.length; i++) {
        products[i] = new Product();
        products[i].name = names[i];
        products[i].price = prices[i];
        products[i].quantity = quantities[i];
    }
}
void main() {
    Product[] products = new Product[4];
    setting_product(products);

    IO.println("welcome to MINI SHOP!!");
    IO.println("--------------------------------");
    IO.println("Press [1] to buy Pens (items = " + products[0].quantity + ")");
    IO.println("Press [2] to buy Pencils (items = " + products[1].quantity + ")");
    IO.println("Press [3] to buy Markers (items = " + products[2].quantity + ")");
    IO.println("Press [4] to buy Highlighters (items = " + products[3].quantity + ")");
    IO.println("--------------------------------");

    Scanner sc = new Scanner(System.in);

    IO.print("Enter a number: ");
    int amount = sc.nextInt();

    while (true) {
        if (amount == 1) {
            IO.println("-------------------------------------");
            IO.print("How many Pens do you want to buy? ");
            int buy = sc.nextInt();

            if (buy <= 20) {
                IO.println("Sold " + buy + " items");
                IO.println("-------------------------------------");
            } else {
                IO.println("""
                        Not enough item in stock ...\
                        
                        
                        """);
            }
            products[0].showInfo();
            break;
        } else if (amount == 2) {
            IO.println("-------------------------------------");
            IO.print("How many Pens do you want to buy? ");
            int buy = sc.nextInt();

            if (buy <= 20) {
                IO.println("Sold " + buy + " items");
                IO.println("-------------------------------------");
                products[0].showInfo();
            } else {
                IO.println("""
                        Not enough item in stock ...\
                        
                        
                        """);
                products[1].showInfo();
            }
            break;
        } else if (amount == 3) {
            IO.println("-------------------------------------");
            IO.print("How many Pens do you want to buy? ");
            int buy = sc.nextInt();

            if (buy <= 20) {
                IO.println("Sold " + buy + " items");
                IO.println("-------------------------------------");
                products[0].showInfo();
            } else {
                IO.println("""
                        Not enough item in stock ...\
                        
                        
                        """);
                products[2].showInfo();
            }
            break;
        } else if (amount == 4) {
            IO.println("-------------------------------------");
            IO.print("How many Pens do you want to buy? ");
            int buy = sc.nextInt();

            if (buy <= 20) {
                IO.println("Sold " + buy + " items");
                IO.println("-------------------------------------");
            } else {
                IO.println("""
                        Not enough item in stock ...\
                        
                        
                        """);
            }
            products[0].showInfo();
            break;
        } else {
            IO.print("Invalid number! Enter a number, again: ");
            amount = sc.nextInt();
        }
    }
}
