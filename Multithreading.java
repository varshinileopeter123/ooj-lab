class CollegeThread extends Thread {
    public void run() {
        try {
            while (true) {
                System.out.println("BMS College of Engineering");
                Thread.sleep(10000); 
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

class DepartmentThread extends Thread {
    public void run() {
        try {
            while (true) {
                System.out.println("CSE");
                Thread.sleep(2000); 
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

public class MultiThreadDemo {
    public static void main(String[] args) {
        CollegeThread t1 = new CollegeThread();
        DepartmentThread t2 = new DepartmentThread();

        t1.start();
        t2.start();
    }
}
