import javax.swing.*;

void main() {
    double pound = Double.parseDouble(JOptionPane.showInputDialog("How many pound do you want?"));
    String flavor = JOptionPane.showInputDialog("Enter a flavor birthday cake:");
    String message = JOptionPane.showInputDialog("Enter a message on cake:");
    BirthdayCake cake = new BirthdayCake(message, pound, flavor, 400);

    while (true) {
        int choice = JOptionPane.showConfirmDialog(null,
                cake + "\n" + "\nConfirm this order?",
                "Select an Option",
                JOptionPane.YES_NO_CANCEL_OPTION);

        if (choice == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, cake);
            break;
        } else if (choice == JOptionPane.NO_OPTION) {
            cake.changeMessage(JOptionPane.showInputDialog("Enter a new message for changing:"));
        } else {
            cake.changeMessage(JOptionPane.showInputDialog("Enter a new message for changing:"));
        }
    }
}
