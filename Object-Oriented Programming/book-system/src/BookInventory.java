import javax.swing.*;

void main() {
    Book[] books = new Book[3];

    for (int i = 0; i < books.length; i++) {
        String input_title = JOptionPane.showInputDialog("Enter book title (Book " + (i + 1) + "):");

        if (input_title == null) {
            showEndMessage();
            return;
        }
        String input_totalStr = JOptionPane.showInputDialog("Enter the total number for: " + input_title);

        if (input_totalStr == null) {
            showEndMessage();
            return;
        }
        try {
            int input_totalBook = Integer.parseInt(input_totalStr);
            books[i] = new Book(input_title, input_totalBook);
            System.out.println(books[i].getTitle() +
                    " has " + books[i].getTotalBook() +
                    " books, can borrow " + books[i].getAvailableBook() + " books.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid number! Please try again.");
            i--;
        }
    }
}

private static void showEndMessage() {
    JOptionPane.showMessageDialog(null, "END PROGRAM");
}