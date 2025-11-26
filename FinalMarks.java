import java.util.*;
import CIE.*;
import SEE.*;

public class FinalMarks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        External[] stu = new External[n];
        Internals[] in = new Internals[n];

        for (int i = 0; i < n; i++) {
            stu[i] = new External();
            in[i] = new Internals();

            System.out.println("\nEnter details for student " + (i + 1) + ":");
            System.out.print("USN: ");
            String usn = sc.next();
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Semester: ");
            int sem = sc.nextInt();
            stu[i].getDetails(usn, name, sem);

            System.out.println("Enter 5 internal marks:");
            int[] im = new int[5];
            for (int j = 0; j < 5; j++) im[j] = sc.nextInt();
            in[i].getInternalMarks(im);

            System.out.println("Enter 5 SEE marks:");
            int[] se = new int[5];
            for (int j = 0; j < 5; j++) se[j] = sc.nextInt();
            stu[i].getSeeMarks(se);
        }

        System.out.println("\n----- FINAL MARKS -----");
        for (int i = 0; i < n; i++) {
            stu[i].displayDetails();
            for (int j = 0; j < 5; j++) {
                int finalMark = (in[i].internalMarks[j] / 2) + (stu[i].seeMarks[j] / 2);
                System.out.println("Subject " + (j + 1) + ": " + finalMark);
            }
            System.out.println("-----------------------");
        }
        sc.close();
    }
}
