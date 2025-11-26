
package CIE;

public class Personal {
    public String usn, name;
    public int sem;
    public void getDetails(String u, String n, int s) {
        usn = u;
        name = n;
        sem = s;
    }

    public void displayDetails() {
        System.out.println("\nUSN: " + usn);
        System.out.println("Name: " + name);
        System.out.println("Semester: " + sem);
    }
}
