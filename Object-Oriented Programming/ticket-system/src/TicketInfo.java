import javax.swing.*;

public static String select_showtime() {
    int input_time = Integer.parseInt(JOptionPane.showInputDialog("""
            Titanic (PG-13, 120 mins\
            
            Press 1 to select show time = 13:00\
            
            Press 2 to select show time = 14:00\
            
            Press 3 to select show time = 15:00\
            
            Enter a number:"""));

    return switch (input_time) {
        case 1 -> "13:00";
        case 2 -> "14:00";
        case 3 -> "15:00";
        default -> "Error time";
    };
}

public static String select_seat_number() {
    String input_row = JOptionPane.showInputDialog("Select seat row [A-G]:");
    String input_number = JOptionPane.showInputDialog("Select seat number [1-12]:");
    return input_row.toUpperCase() + input_number;
}

void main() {
    Movie movie = new Movie("Titanic", 120, "PG-13");
    String show_time = select_showtime();
    String seat_number = select_seat_number();
    Ticket ticket = new Ticket("T001", movie, show_time, seat_number, 240);
    JOptionPane.showMessageDialog(null, ticket.toString());
}
