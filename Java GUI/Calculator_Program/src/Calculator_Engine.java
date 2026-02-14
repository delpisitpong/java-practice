import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class Calculator_Engine extends Calculator_Program {
    public Calculator_Engine() {
        JFrame frame = new JFrame();
        frame.setContentPane(cal_prog);
        frame.getContentPane().setBackground(Color.decode("#000000"));
        frame.setTitle("Calculator Program");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // ======================================================================================================================================================
        // BASIC CALCULATION
        // ======================================================================================================================================================
        cal_basic.addActionListener(_ -> {
            DecimalFormat df = new DecimalFormat("#,###.00");

            while (true) {
                try {
                    String input1 = JOptionPane.showInputDialog(null,
                            "Enter first number:\n(Or press Cancel to exit)",
                            "Basic Mode", JOptionPane.QUESTION_MESSAGE);
                    if (input1 == null) break;
                    double num1 = Double.parseDouble(input1);

                    String[] operations = {"+", "-", "*", "/"};
                    String op = (String) JOptionPane.showInputDialog(null,
                            "Select Operation:",
                            "Basic Mode",
                            JOptionPane.QUESTION_MESSAGE, null, operations, operations[0]);
                    if (op == null) break;

                    String input2 = JOptionPane.showInputDialog(null,
                            "Enter second number:",
                            "Basic Mode",
                            JOptionPane.QUESTION_MESSAGE);
                    if (input2 == null) break;
                    double num2 = Double.parseDouble(input2);

                    if (op.equals("/") && num2 == 0) {
                        JOptionPane.showMessageDialog(null,
                                "Error: Cannot divide by zero!",
                                "Math Error",
                                JOptionPane.ERROR_MESSAGE);
                        continue;
                    }

                    double result = switch (op) {
                        case "+" -> num1 + num2;
                        case "-" -> num1 - num2;
                        case "*" -> num1 * num2;
                        case "/" -> num1 / num2;
                        default -> 0;
                    };

                    JOptionPane.showMessageDialog(null,
                            num1 + " " + op + " " + num2 + " = " + df.format(result),
                            "Result",
                            JOptionPane.INFORMATION_MESSAGE);

                    int choice = JOptionPane.showConfirmDialog(null,
                            "Do you want to calculate another?",
                            "Continue?",
                            JOptionPane.YES_NO_OPTION);
                    if (choice != JOptionPane.YES_OPTION) break;

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null,
                            "Invalid input! Please enter numbers only.",
                            "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }

            // Refresh the main UI to clear any visual artifacts after closing the dialog
            if (cal_prog != null) {
                cal_prog.revalidate(); // Recalculate the layout
                cal_prog.repaint();    // Redraw the components
            }
        });

        // ======================================================================================================================================================
        // FIND AVERAGE
        // ======================================================================================================================================================
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
            }

            // Refresh the main UI to clear any visual artifacts after closing the dialog
            if (cal_prog != null) {
                cal_prog.revalidate(); // Recalculate the layout
                cal_prog.repaint();    // Redraw the components
            }
        });

        // ======================================================================================================================================================
        // UNIT CONVERTER
        // ======================================================================================================================================================
        convert_unit.addActionListener(_ -> {
            double celsius = 0;
            boolean validInput = false;
            DecimalFormat df = new DecimalFormat("#,###.00");

            while (!validInput) {
                try {
                    String input = JOptionPane.showInputDialog("Enter Temperature in Celsius (°C):");
                    if (input == null) return;

                    celsius = Double.parseDouble(input);
                    validInput = true;
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null,
                            "Please enter a valid number!");
                }
            }

            double fahrenheit = (celsius * 9 / 5) + 32;

            JOptionPane.showMessageDialog(null,
                    celsius + " °C is equal to " + df.format(fahrenheit) + " °F");

            // Refresh the main UI to clear any visual artifacts after closing the dialog
            if (cal_prog != null) {
                cal_prog.revalidate(); // Recalculate the layout
                cal_prog.repaint();    // Redraw the components
            }
        });

        // ======================================================================================================================================================
        // VAT CALCULATION
        // ======================================================================================================================================================
        cal_financial.addActionListener(_ -> {
            double amount = 0;
            boolean validInput = false;
            DecimalFormat df = new DecimalFormat("#,###.00");

            while (!validInput) {
                try {
                    String input = JOptionPane.showInputDialog("Enter Product Price (Exclude VAT):");
                    if (input == null) return;

                    amount = Double.parseDouble(input);
                    if (amount < 0) throw new NumberFormatException();

                    validInput = true;
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null,
                            "Please enter a valid positive price!");
                }
            }

            double vat = amount * 0.07;
            double total = amount + vat;

            String message = "Price: " + df.format(amount) + "\n" +
                    "VAT (7%): " + df.format(vat) + "\n" +
                    "Total: " + df.format(total);

            JOptionPane.showMessageDialog(null,
                    message,
                    "Financial Result",
                    JOptionPane.INFORMATION_MESSAGE);

            // Refresh the main UI to clear any visual artifacts after closing the dialog
            if (cal_prog != null) {
                cal_prog.revalidate(); // Recalculate the layout
                cal_prog.repaint();    // Redraw the components
            }
        });
    }
}