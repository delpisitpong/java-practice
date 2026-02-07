public class Brownie extends Bakery{
    private boolean isFudgy;
    private final int piece;

    public Brownie(int piece, String flavor, double unitPrice) {
        super(flavor, unitPrice);
        this.piece = piece;
    }

    public void isFudgy() {
        if (!isFudgy) {
            this.isFudgy = true;
        }
    }

    public boolean isPackingBox() {
        return this.piece >= 6;
    }

    public int getBoxNumber() {
        if (isPackingBox()) {
            return this.piece / 6;
        }
        return 0;
    }

    public int getBagNumber() {
        return this.piece % 6;
    }

    @Override
    public int getPackingCost() {
        if (isPackingBox()) {
            return getBoxNumber() * super.getPackingCost();
        }
        return 0;
    }

    @Override
    public double calculateTotalPrice() {
        if (isFudgy) {
            return (getUnitPrice() * this.piece) + getPackingCost() + (getBagNumber() * 0.5) + 20;
        } else {
            return (getUnitPrice() * this.piece) + getPackingCost() + (getBagNumber() * 0.5);
        }
    }

    public String toString() {
        return super.toString() +
                "\nBrownie (" + getFlavor() + ") with " +
                (isPackingBox() ? getBagNumber() + " Box " : " " ) + getBagNumber() + " Bag" +
                "\nTotal price of Brownie = " + calculateTotalPrice();
    }
}
