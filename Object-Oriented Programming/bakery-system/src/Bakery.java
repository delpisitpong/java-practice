public class Bakery {
    private final String flavor;
    private final double unitPrice;
    private final int packingCost = 5;

    public Bakery(String flavor, double unitPrice) {
        this.flavor = flavor;
        this.unitPrice = unitPrice;
    }

    public String getFlavor() {
        return this.flavor;
    }

    public double getUnitPrice() {
        return this.unitPrice;
    }

    public String toString() {
        return "Thank you for your order!";
    }

    public int getPackingCost() {
        return this.packingCost;
    }

    public double calculateTotalPrice() {
        return this.unitPrice + this.packingCost;
    }
}
