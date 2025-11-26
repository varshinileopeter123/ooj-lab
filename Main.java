class WrongAge extends Exception {
    WrongAge(String msg) {
        super(msg);
    }
}
class WrongSonAge extends Exception {
    WrongSonAge(String msg) {
        super(msg);
    }
}
class Father {
    int fatherAge;

    Father(int age) throws WrongAge {
        if (age < 0) {
            throw new WrongAge("Father's age cannot be negative!");
        }
        fatherAge = age;
    }
}
class Son extends Father {
    int sonAge;

    Son(int fatherAge, int sonAge) throws WrongAge, WrongSonAge {
        super(fatherAge); // Call Father constructor

        if (sonAge >= fatherAge) {
            throw new WrongSonAge("Son's age cannot be greater than or equal to Father's age!");
        }
        if (sonAge < 0) {
            throw new WrongSonAge("Son's age cannot be negative!");
        }

        this.sonAge = sonAge;
    }
}
public class Main {
    public static void main(String[] args) {

        try {
            Son s1 = new Son(45, 20);
            System.out.println("Object created successfully!");
        }
        catch (WrongAge e) {
            System.out.println("Father Exception: " + e.getMessage());
        }
        catch (WrongSonAge e) {
            System.out.println("Son Exception: " + e.getMessage());
        }

        // Example of error case
        try {
            Son s2 = new Son(40, 40); // will throw exception
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

