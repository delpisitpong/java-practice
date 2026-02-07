import javax.swing.*;

void main() {
    int Chicken_Wing = 99;
    int Pork_with_Leek = 89;
    int Beef_Tongue = 109;

    while (true) {
        int sum = 0;
        int start = JOptionPane.showConfirmDialog(null,
                "Do you want to order menu?",
                "Yakitori Shop",
                JOptionPane.YES_NO_OPTION);

        if (start == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "END PROGRAM!!");
            break;
        }
        while (true) {
            int input = Integer.parseInt(JOptionPane.showInputDialog("""
                    Yakitori Menu
                    [1] Chicken Wing 99 B.
                    [2] Pork with Leek 89 B.
                    [3] Beef Tongue 109 B.
                    [0] Exit and Calculate
                    Enter menu number:"""));

            switch (input) {
                case 1 -> sum += Chicken_Wing;
                case 2 -> sum += Pork_with_Leek;
                case 3 -> sum += Beef_Tongue;
                case 0 -> JOptionPane.showMessageDialog(null,
                        "Total price is " + sum + " Baht.");
                default -> JOptionPane.showMessageDialog(null,
                        "Invalid menu number. Please try again.");
            }
            if (input == 0) {
                break;
            }
        }
    }
}