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
    System.out.println("welcome to MINI SHOP!!");
    System.out.println("==================================================");
    System.out.println("Press [1] to buy Pens (items = " + products[0].quantity + ")");
    System.out.println("Press [2] to buy Pencils (items = " + products[1].quantity + ")");
    System.out.println("Press [3] to buy Markers (items = " + products[2].quantity + ")");
    System.out.println("Press [4] to buy Highlighters (items = " + products[3].quantity + ")");
    System.out.println("==================================================");
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter a number: ");
    int amount = sc.nextInt();

    while (true) {
        if (amount == 1) {
            System.out.println("==================================================");
            System.out.print("How many Pens do you want to buy? ");
            int buy = sc.nextInt();

            if (buy <= 20) {
                products[0].sell(buy);
                System.out.println("==================================================");
                products[0].showInfo();
            } else {
                System.out.println("""
                        Not enough item in stock ...\
                        
                        
                        """);
                products[0].showInfo();
            }
            break;
        } else if (amount == 2) {
            System.out.println("==================================================");
            System.out.print("How many Pencils do you want to buy? ");
            int buy = sc.nextInt();

            if (buy <= 35) {
                products[1].sell(buy);
                System.out.println("==================================================");
                products[1].showInfo();
            } else {
                System.out.println("""
                        Not enough item in stock ...\
                        
                        
                        """);
                products[1].showInfo();
            }
            break;
        } else if (amount == 3) {
            System.out.println("==================================================");
            System.out.print("How many Markers do you want to buy? ");
            int buy = sc.nextInt();

            if (buy <= 10) {
                products[2].sell(buy);
                System.out.println("==================================================");
                products[2].showInfo();
            } else {
                System.out.println("""
                        Not enough item in stock ...\
                        
                        
                        """);
                products[2].showInfo();
            }
            break;
        } else if (amount == 4) {
            System.out.println("==================================================");
            System.out.print("How many Highlighters do you want to buy? ");
            int buy = sc.nextInt();

            if (buy <= 40) {
                products[3].sell(buy);
                System.out.println("==================================================");
                products[3].showInfo();
            } else {
                System.out.println("""
                        Not enough item in stock ...\
                        
                        
                        """);
                products[3].showInfo();
            }
            break;
        } else {
            System.out.print("Invalid number! Enter a number, again: ");
            amount = sc.nextInt();
        }
    }
}
