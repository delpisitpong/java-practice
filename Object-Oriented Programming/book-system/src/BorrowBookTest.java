import javax.swing.*;

void main() {
    Book book = new Book("C# Programming", 5);
    boolean validInput = false;

    while (!validInput) {
        int star_or_end = JOptionPane.showConfirmDialog(null,
                "Do you want to borrow books?",
                "Borrow Book",
                JOptionPane.YES_NO_OPTION);

        if (star_or_end == JOptionPane.YES_OPTION) {
            if (book.getAvailableBook() != 0) {
                book.borrowBook();
                System.out.println("Borrowed 1 book, available " + book.getAvailableBook() + " books.");
            } else {
                JOptionPane.showMessageDialog(null,
                        "No books available to borrow...",
                        "Warning Message",
                        JOptionPane.WARNING_MESSAGE);
                validInput = true;
            }
        } else {
            JOptionPane.showMessageDialog(null, "END PROGRAM");
            validInput = true;
        }
    }
}
