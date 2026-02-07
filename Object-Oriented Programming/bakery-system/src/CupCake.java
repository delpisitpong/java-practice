public class CupCake extends Bakery {
    private final int piece;

    public CupCake(int piece, String flavor, double unitPrice) {
        super(flavor, unitPrice);
        this.piece = piece;
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
        return (getUnitPrice() * this.piece) + getPackingCost() + (getBagNumber() * 0.5);
    }

    public String toString() {
        return super.toString() +
                "\nCupCake (" + getFlavor() + ") with " +
                (isPackingBox() ? getBagNumber() + " Box " : " " ) + getBagNumber() + " Bag" +
                "\nTotal price of CupCake = " + calculateTotalPrice();
    }
}
