import javax.swing.*;

void main() {
    Book book = new Book("Java Programming", 5);
    boolean validInput = false;

    while (!validInput) {
        int star_or_end = JOptionPane.showConfirmDialog(null,
                "Do you want to borrow/return book?",
                "Borrow/Return Book",
                JOptionPane.YES_NO_OPTION);

        if (star_or_end == JOptionPane.YES_OPTION) {
            String input = JOptionPane.showInputDialog("Press 1 to borrow book\nPress 2 to return book");

            if (input == null) {
                JOptionPane.showMessageDialog(null, "END PROGRAM");
                break;
            }
            try {
                int borrow_or_return = Integer.parseInt(input);

                if (borrow_or_return == 1) {
                    if (book.getAvailableBook() > 0) {
                        book.borrowBook();
                        System.out.println("Borrowed 1 book, available " + book.getAvailableBook() + " books.");
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "No books available to borrow...",
                                "Warning",
                                JOptionPane.WARNING_MESSAGE);
                    }
                } else if (borrow_or_return == 2) {
                    if (book.getAvailableBook() < book.getTotalBook()) {
                        book.returnBook();
                        System.out.println("Returned 1 book, available " + book.getAvailableBook() + " books.");
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Cannot return! All books are already here.",
                                "Warning",
                                JOptionPane.WARNING_MESSAGE);
                    }
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter only 1 or 2");
            }
        } else {
            JOptionPane.showMessageDialog(null, "END PROGRAM");
            validInput = true;
        }
    }
}