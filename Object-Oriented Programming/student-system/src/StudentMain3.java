import javax.swing.*;

void main() {
    Student[] students = new Student[3];

    for (int i = 0; i < students.length; i++) {
        students[i] = new Student();
        students[i].name = JOptionPane.showInputDialog("Enter student " + (i + 1) + " name: ");
        students[i].id = JOptionPane.showInputDialog("Enter student " + (i + 1) + " id: ");
        int homework_score = Integer.parseInt(JOptionPane.showInputDialog("Enter homework's score: "));
        students[i].doHomework(homework_score);
        int exam_score = Integer.parseInt(JOptionPane.showInputDialog("Enter exam's score: "));
        students[i].takeExam(exam_score);
    }
    System.out.println();
    System.out.println("List of PASS students");
    for (Student s : students) {
        if (s.getResult().equals("PASS")) {
            System.out.println("- " + s.name);
        }
    }
    System.out.println("List of FAIL students");
    for (Student s : students) {
        if (s.getResult().equals("FAIL")) {
            System.out.println("- " + s.name);
        }
    }
}
