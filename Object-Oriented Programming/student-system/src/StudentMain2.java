void main() {
    Scanner scanner = new Scanner(System.in);
    Student s1 = new Student();
    System.out.print("Enter student name: ");
    s1.name = scanner.nextLine();
    System.out.print("Enter student id: ");
    s1.id = scanner.nextLine();
    System.out.print("Enter homework score: ");
    int homework_score = scanner.nextInt();
    s1.doHomework(homework_score);
    System.out.print("Enter exam score: ");
    int exam_score = scanner.nextInt();
    s1.takeExam(exam_score);
    System.out.println();
    s1.showStatus();
}
