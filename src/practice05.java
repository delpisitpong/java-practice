public static int[] random_array() {
    int[] numbers = new int[10];
    Random rand = new Random();

    for (int i = 0; i < numbers.length; i++) {
        numbers[i] = rand.nextInt(21);

    }

    return numbers;

}


public static void display_array(int[] numbers) {
    for (int num : numbers) {
        IO.print(num + " ");

    }

    IO.println();

}


public static int count_element(int[] numbers, int element) {
    int count = 0;

    for (int num : numbers) {
        if (num == element) {
            count++;

        }
    }

    return count;

}


void main() {
    Scanner scanner = new Scanner(System.in);

    int[] numbers = random_array();

    IO.print("Enter your guess (0-20): ");
    int guess_number = scanner.nextInt();

    int count = count_element(numbers, guess_number);

    if (count > 0) {
        IO.println("Congratulations!! " + guess_number + " is an element in the array!!");

        if (count > 1) {
            IO.println("Fantastic!! It also appears more than once!!");

        }
    } else {
        IO.println("Sorry, try again next time...");
        IO.print("Here are the elements in the array: ");
        display_array(numbers);

    }

    scanner.close();

}
