import javax.swing.*;
import java.text.DecimalFormat;

public class Calculator_Program {
    private JPanel cal_prog;
    private JButton cal_basic;
    private JButton cal_avg;
    private JPanel basic_cal;
    private JPanel avg_cal;
    private JLabel basic_cal_des;
    private JLabel avg_cal_des;

    public  Calculator_Program() {
        JFrame frame = new JFrame();
        frame.setContentPane(cal_prog);
        frame.setTitle("Calculator Program");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        cal_basic.addActionListener(_ -> {
            double firstNumber = 0, secondNumber = 0;
            boolean validInput = false;

            while (!validInput) {
                try {
                    String input1 = JOptionPane.showInputDialog("Input first number:");

                    if (input1 == null) {
                        JOptionPane.showMessageDialog(null, "Error, Closed program");
                        return;
                    }
                    firstNumber = Double.parseDouble(input1);
                    validInput = true;
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null, "Enter number only!");
                }
            }
            String operation = JOptionPane.showInputDialog("Enter operation (+, -, *, /):");

            if (operation == null) {
                JOptionPane.showMessageDialog(null, "Error, Closed program");
                return;
            }
            validInput = false;
            while (!validInput) {
                try {
                    String input2 = JOptionPane.showInputDialog("Input second number:");

                    if (input2 == null) {
                        JOptionPane.showMessageDialog(null, "Error, Closed program");
                        return;
                    }
                    secondNumber = Double.parseDouble(input2);
                    validInput = true;
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null, "Enter number only!");
                }
            }
            double result;

            switch (operation) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "*":
                    result = firstNumber * secondNumber;
                    break;
                case "/":
                    if (secondNumber == 0) {
                        JOptionPane.showMessageDialog(null, "Can not divided by Zero!");
                        return;
                    }
                    result = firstNumber / secondNumber;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Wrong operation");
                    return;
            }
            DecimalFormat df = new DecimalFormat("#,###.00");

            JOptionPane.showMessageDialog(null,
                    firstNumber + " " + operation + " " + secondNumber + " = " + df.format(result));
        });
        cal_avg.addActionListener(_ -> {
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
        });
    }

    static void main() {
        new Calculator_Program();
    }
}
