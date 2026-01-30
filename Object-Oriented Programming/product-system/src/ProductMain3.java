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

    for (Product product : products) {
        IO.println("Name : " + product.name);
        IO.println("Price : " + product.price + " Baht/Item");
        IO.println("Stock : " + product.quantity + " Item");
        IO.println("Stock Value : " + product.stockValue() + " Baht");
        IO.println("==============================");
    }
}