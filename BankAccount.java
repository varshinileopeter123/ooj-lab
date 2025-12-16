import java.util.Scanner;

class Account {
    String custName;
    int accNo;
    String accType;
    double balance;

    Scanner sc = new Scanner(System.in);

    void acceptDetails() {
        System.out.print("Enter Customer Name: ");
        custName = sc.nextLine();

        System.out.print("Enter Account Number: ");
        accNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Account Type: ");
        accType = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        balance = sc.nextDouble();
    }

    void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amt = sc.nextDouble();
        balance += amt;
        System.out.println("Amount deposited successfully.");
    }

    void displayBalance() {
        System.out.println("Current Balance = " + balance);
    }
}

class SavAcct extends Account {

    void computeInterest() {
        System.out.print("Enter interest rate (%): ");
        double rate = sc.nextDouble();

        double interest = balance * rate / 100;
        balance += interest;

        System.out.println("Interest added = " + interest);
    }

    void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amt = sc.nextDouble();

        if (amt <= balance) {
            balance -= amt;
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

class CurAcct extends Account {
    final double MIN_BAL = 1000;
    final double PENALTY = 100;

    void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amt = sc.nextDouble();

        if (amt <= balance) {
            balance -= amt;

            if (balance < MIN_BAL) {
                balance -= PENALTY;
                System.out.println("Minimum balance not maintained.");
                System.out.println("Penalty imposed = " + PENALTY);
            }

            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        System.out.print("Choose account type: ");
        int choice = sc.nextInt();

        if (choice == 1) {
            SavAcct sa = new SavAcct();
            sa.acceptDetails();
            sa.deposit();
            sa.computeInterest();
            sa.withdraw();
            sa.displayBalance();
        } 
        else if (choice == 2) {
            CurAcct ca = new CurAcct();
            ca.acceptDetails();
            ca.deposit();
            ca.withdraw();
            ca.displayBalance();
        } 
        else {
            System.out.println("Invalid choice.");
        }
    }
}
