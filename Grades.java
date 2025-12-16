import java.util.Scanner;

class Student {
    String usn;
    String name;
    int[] credits;
    int[] marks;
    int n;   

    void acceptDetails() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter USN: ");
        usn = sc.nextLine();

        System.out.print("Enter Name: ");
        name = sc.nextLine();

        System.out.print("Enter number of subjects: ");
        n = sc.nextInt();

        credits = new int[n];
        marks = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter credits for subject " + (i + 1) + ": ");
            credits[i] = sc.nextInt();

            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }
    }

    void displayDetails() {
        System.out.println("\nStudent Details");
        System.out.println("USN   : " + usn);
        System.out.println("Name  : " + name);

        System.out.println("\nCredits and Marks:");
        for (int i = 0; i < n; i++) {
            System.out.println("Subject " + (i + 1) +
                               " -> Credits: " + credits[i] +
                               ", Marks: " + marks[i]);
        }
    }

    double calculateSGPA() {
        int totalCredits = 0;
        int weightedSum = 0;

        for (int i = 0; i < n; i++) {
            int gradePoint;

            if (marks[i] >= 90) gradePoint = 10;
            else if (marks[i] >= 80) gradePoint = 9;
            else if (marks[i] >= 70) gradePoint = 8;
            else if (marks[i] >= 60) gradePoint = 7;
            else if (marks[i] >= 50) gradePoint = 6;
            else if (marks[i] >= 40) gradePoint = 5;
            else gradePoint = 0;

            weightedSum += credits[i] * gradePoint;
            totalCredits += credits[i];
        }

        return (double) weightedSum / totalCredits;
    }
}

public class StudentMain {
    public static void main(String[] args) {
        Student s = new Student();

        s.acceptDetails();
        s.displayDetails();

        double sgpa = s.calculateSGPA();
        System.out.println("\nSGPA = " + sgpa);
    }
}
