class WrongAgeException extends Exception {
    public WrongAgeException(String msg) {
        super(msg);
    }
}

class Father {
    int fage;

    Father(int age) throws WrongAgeException {
        if (age < 0) {
            throw new WrongAgeException("Father's age cannot be negative");
        }
        fage = age;
    }
}

class Son extends Father {
    int sage;

    Son(int fatherAge, int sonAge) throws WrongAgeException {
        super(fatherAge);

        if (sonAge >= fatherAge) {
            throw new WrongAgeException(
                "Son's age must be less than Father's age");
        }

        sage = sonAge;
    }
}

public class ExceptionInheritanceDemo {
    public static void main(String[] args) {
        try {
            Son s = new Son(45, 20);
            System.out.println("Father Age: " + s.fage);
            System.out.println("Son Age   : " + s.sage);
        }
        catch (WrongAgeException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
