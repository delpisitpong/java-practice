public class Student {
    String name;
    String id;
    int score = 0;

    public void doHomework(int point) {
        score += point;
        System.out.println(name + " did homework " + point + " points");
    }

    public void takeExam(int point) {
        score += point;
        System.out.println(name + " took exam " + point + " points");
    }

    public String getResult() {
        if (score >= 50) {
            return "PASS";
        }
        else {
            return "FAIL";
        }
    }

    public void showStatus() {
        System.out.println("Name      : " + name);
        System.out.println("Student ID: " + id);
        System.out.println("Score     : " + score);
        System.out.println("Result    : " + getResult());
        System.out.println("==============================");
    }
}
