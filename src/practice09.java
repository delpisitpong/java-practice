void main() {
    Scanner scanner = new Scanner(System.in);

    int number;
    boolean is_loop = true;

    while (is_loop) {
        try {
            System.out.print("Enter a number: ");
            number = scanner.nextInt();
            is_loop = false;
            System.out.println("You entered number = " + number);
        } catch (InputMismatchException err) {
            scanner.next();
            System.out.println("Invalid Data!!");
        }
    }
}
