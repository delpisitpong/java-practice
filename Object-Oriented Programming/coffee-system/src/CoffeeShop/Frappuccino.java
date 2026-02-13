package CoffeeShop;

public class Frappuccino extends Drink {
    private final boolean whipped;

    public Frappuccino(String drinkName, String size, boolean whipped) {
        super(drinkName, 40, size);
        this.whipped = whipped;
    }

    @Override
    public double calculateFinalPrice() {
        return this.getBasePrice() + (whipped ? 15 : 0) + this.getSizeExtra();
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n" + (whipped ? "Add whipped 15 Baht" : "") +
                "\nTotal price = " + this.calculateFinalPrice() +
                "\n==================================================";
    }
}
