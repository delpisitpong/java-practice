import javax.swing.*;

public static String show_movie_list(Ticket[] tickets) {
    StringBuilder result = new StringBuilder();

    for (Ticket t : tickets) {
        result.append(t.getTicket_id()).append(": ").append(t.getMovie()).append("\n");
    }
    return result.toString();
}

public static Integer getSafeInt(String message) {
    while (true) {
        String input = JOptionPane.showInputDialog(null, message);

        if (input == null) return null;
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "Enter number only!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}

void main() {
    Ticket[] tickets = {
            new Ticket("T001", new Movie("Titanic", 120, "PG-13"), "12:00", "B7", 280),
            new Ticket("T002", new Movie("A Walk to Remember", 102, "PG"), "11:00", "G11", 240),
            new Ticket("T003", new Movie("Silent Hill", 125, "R-13"), "14:30", "H2", 240)
    };
    boolean loop = true;
    int confirm = JOptionPane.showConfirmDialog(null,
            "Do you want to book or use a ticket?",
            "Ticket",
            JOptionPane.YES_NO_OPTION);

    while (loop) {
        if (confirm != JOptionPane.YES_OPTION) break;
        String ticket_id = JOptionPane.showInputDialog(null,
                show_movie_list(tickets) +
                        "\nEnter a ticket id:");

        if (ticket_id == null) continue;
        Ticket selectedTicket = null;

        for (Ticket t : tickets) {
            if (t.getTicket_id().equalsIgnoreCase(ticket_id)) {
                selectedTicket = t;
                break;
            }
        }
        if (selectedTicket != null) {
            Integer menu = getSafeInt(selectedTicket.getTicket_id() +
                    ": " +
                    selectedTicket.getMovie().toString() +
                    "\n\nPress [1] to book a ticket" +
                    "\nPress [2] to use a ticket" +
                    "\nPress [3] to see ticket status" +
                    "\n\nEnter menu:");

            if (menu != null) {
                String output;
                switch (menu) {
                    case 1:
                        output = selectedTicket.bookTicket();
                        break;
                    case 2:
                        output = selectedTicket.useTicket();
                        break;
                    case 3:
                        output = "Ticket Status";
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid Menu.");
                        continue;
                }
                JOptionPane.showMessageDialog(null,
                        output +
                                "\n==================================================\n" +
                                selectedTicket +
                                "\n==================================================");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ticket ID not found!");
        }
        int again = JOptionPane.showConfirmDialog(null, "Do you want to continue?",
                "Ticket",
                JOptionPane.YES_NO_OPTION);

        if (again != JOptionPane.YES_OPTION) loop = false;
    }
}