import java.util.Scanner;

public class GradeEvaluator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the student's grade: ");
        double grade = scanner.nextDouble();

        if (grade < 0 || grade > 100) {
            System.out.println("Wrong Grade");
        } else if (grade >= 90) {
            System.out.println("A");
        } else if (grade >= 80) {
            System.out.println("B");
        } else if (grade >= 70) {
            System.out.println("C");
        } else if (grade >= 60) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

        scanner.close();
    }
}