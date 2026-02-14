import javax.swing.*;

void main() {
    double sum = 0;
    int count = 0;
    boolean isAdding = true;

    while (isAdding) {
        boolean validInput = false;
        while (!validInput) {
            try {
                String input = JOptionPane.showInputDialog(null,
                        "Enter number #" + (count + 1) + ":\n(Or press Cancel to calculate result)",
                        "Average Calculation",
                        JOptionPane.QUESTION_MESSAGE);

                if (input == null) {
                    isAdding = false;
                    break;
                }

                double number = Double.parseDouble(input);
                sum += number;
                count++;
                validInput = true;
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null,
                        "Error: Please enter numbers only!",
                        "Invalid Input",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        if (isAdding) {
            int choice = JOptionPane.showConfirmDialog(null,
                    "Do you want to add another number?",
                    "Confirm",
                    JOptionPane.YES_NO_OPTION);

            if (choice == JOptionPane.NO_OPTION) {
                isAdding = false;
            }
        }
    }

    if (count > 0) {
        double average = sum / count;
        DecimalFormat df = new DecimalFormat("#,###.00");

        JOptionPane.showMessageDialog(null,
                "--- Calculation Summary ---\n" +
                        "Total numbers: " + count + "\n" +
                        "Total sum: " + df.format(sum) + "\n" +
                        "Average result: " + df.format(average),
                "Result",
                JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(null,
                "No data to calculate.",
                "Canceled",
                JOptionPane.WARNING_MESSAGE);
    }
}
