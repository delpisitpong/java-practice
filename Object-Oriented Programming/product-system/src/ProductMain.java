import javax.swing.*;

void main() {
    JOptionPane.showMessageDialog(null,
            "Welcome to Product Stock System");
    Product product = new Product();
    product.name = JOptionPane.showInputDialog("Enter product name: ");
    product.price = Double.parseDouble(JOptionPane.showInputDialog("Enter product price per item: "));
    product.quantity = Integer.parseInt(JOptionPane.showInputDialog("Enter product stock: "));
    product.showInfo();
    int addItem = JOptionPane.showConfirmDialog(null,
            "Do you want to add more item?",
            "Select an Option",
            JOptionPane.YES_NO_CANCEL_OPTION);

    if (addItem == JOptionPane.YES_OPTION) {
        product.addStock(Integer.parseInt(JOptionPane.showInputDialog("How many items to add in stock?")));
    }
    int changePice = JOptionPane.showConfirmDialog(null,
            "Do you want to change price?",
            "Select an Option",
            JOptionPane.YES_NO_CANCEL_OPTION);

    if (changePice == JOptionPane.YES_OPTION) {
        product.changePrice(Double.parseDouble(JOptionPane.showInputDialog("How much is the new price per item?")));
    }
    product.showInfo();
}
