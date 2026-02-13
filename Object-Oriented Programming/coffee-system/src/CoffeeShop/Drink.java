package CoffeeShop;

abstract public class Drink implements Priceable {
    private final String drinkName;
    private final double basePrice;
    private final String size;

    public Drink(String drinkName, double basePrice, String size) {
        this.drinkName = drinkName;
        this.basePrice = basePrice;
        this.size = size;
    }

    abstract public double calculateFinalPrice();

    @Override
    public double getBasePrice() {
        return this.basePrice;
    }

    @Override
    public double getSizeExtra() {
        if (this.size.equalsIgnoreCase("S")) {
            return 0;
        } else if (this.size.equalsIgnoreCase("M")) {
            return 10;
        } else if (this.size.equalsIgnoreCase("L")) {
            return 15;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return "==================================================" +
                "\nYour order: " + this.drinkName + " (Size: " + this.size.toUpperCase() + ")";
    }
}
