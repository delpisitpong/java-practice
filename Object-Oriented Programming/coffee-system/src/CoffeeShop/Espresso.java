package CoffeeShop;

public class Espresso extends Drink {
    private int shot;

    public Espresso(String size) {
        super("Espresso", 35, size);
        this.shot = 0;
    }

    public void addShot(int shot) {
        this.shot = shot;
    }

    public int getShot() {
        return this.shot;
    }

    @Override
    public double calculateFinalPrice() {
        return this.getBasePrice() + (this.shot * 15) + this.getSizeExtra();
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n" + ((this.getShot() != 0) ? "Add " + this.shot + " shot" : "" ) +
                "\nTotal price = " + this.calculateFinalPrice() + " Baht" +
                "\n==================================================";
    }
}
