import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int password = 1234;
        int attempts = 3;
        int enteredPassword;
        double balance = 1000;
        int transactionHistory[] = new int[5];

        System.out.println("\t\t==ATM SYSTEM==");
        System.out.println("Welcome to the ATM System");
        System.out.println("Enter your password: ");        
        enteredPassword = input.nextInt();

        while (enteredPassword != password && attempts > 1) {
            attempts--;
            System.out.println("Incorrect password. You have " + attempts + " attempts left.");
            System.out.println("Enter your password: ");
            enteredPassword = input.nextInt();
        }do {
            if (enteredPassword == password) {
                System.out.println("\t\t==ATM MENU==");
                System.out.println("1. Check Balance");
                System.out.println("2. Withdraw Money");
                System.out.println("3. Deposit Money");
                System.out.println("4. Transaction History");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");
                int choice = input.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Your current balance is: $" + balance);
                        break;
                    case 2:
                        System.out.print("Enter the amount to withdraw: ");
                        double withdrawAmount = input.nextDouble();
                        if (withdrawAmount <= balance) {
                            balance -= withdrawAmount;
                            System.out.println("Withdrawal successful. Your new balance is: $" + balance);
                        } else {
                    System.out.println("Insufficient funds. Your current balance is: $" + balance);
                        }
                            break;
                    case 3:
                        System.out.print("Enter the amount to deposit: ");
                        double depositAmount = input.nextDouble();
                        balance += depositAmount;
                        System.out.println("Deposit successful. Your new balance is: $" + balance);
                        break;
                    case 4:
                        System.out.println("Transaction History:");
                        for (int i = 0; i < transactionHistory.length; i++) {
                            if (transactionHistory[i] != 0) {
                                System.out.println("Transaction " + (i + 1) + ": $" + transactionHistory[i]);
                            }
                        }
                        break;

                    case 5:
                        System.out.println("Thank you for using the ATM System. Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } else {
                System.out.println("Access denied. You have no attempts left.");
            }
        } while (enteredPassword == password);

    }
}
