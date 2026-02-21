import javax.swing.*;

void main() {
    int number = 0;
    boolean is_loop = true;

    while (is_loop) {
        try {
            number = Integer.parseInt(JOptionPane.showInputDialog("Enter a number:"));
            is_loop = false;
        } catch (NumberFormatException err) {
            JOptionPane.showMessageDialog(null,
                    "Error: " + err.getMessage(),
                    "Error Message",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    JOptionPane.showMessageDialog(null, "You entered number = " + number);
}
