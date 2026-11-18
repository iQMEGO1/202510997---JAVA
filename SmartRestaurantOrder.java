
import java.util.Scanner;

public class SmartRestaurantOrder {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

       
        final double DRINK_PRICE = 15.50;
        final double STUDENT_DISCOUNT = 0.10;
        final double SENIOR_DISCOUNT = 0.05;
        final double TIP_RATE = 0.10;

        
        String name;
        int age;
        double mealPrice;
        int drinks;
        boolean isStudent;
        int rating;

       
        System.out.print("Enter customer name: ");
        name = input.nextLine();

        System.out.print("Enter customer age: ");
        age = input.nextInt();

        System.out.print("Enter meal price: $");
        mealPrice = input.nextDouble();

        System.out.print("Enter number of drinks: ");
        drinks = input.nextInt();

        System.out.print("Is the customer a student? (true/false): ");
        isStudent = input.nextBoolean();

        System.out.print("Enter service rating (1-5): ");
        rating = input.nextInt();

        
        if (rating < 1 || rating > 5) {
            System.out.println("Error: Rating must be between 1 and 5.");
        } else {

            
            double drinksCost = drinks * DRINK_PRICE;
            double subtotal = mealPrice + drinksCost;

            
            double discountRate;

            if (isStudent && age >= 60) {
                discountRate = STUDENT_DISCOUNT;
            } else if (isStudent) {
                discountRate = STUDENT_DISCOUNT;
            } else if (age >= 60) {
                discountRate = SENIOR_DISCOUNT;
            } else {
                discountRate = 0.0;
            }

            double discountAmount = subtotal * discountRate;

            
            double tipAmount;

            if (rating == 4 || rating == 5) {
                tipAmount = subtotal * TIP_RATE;
            } else {
                tipAmount = 0.0;
            }

            
            double finalBill = subtotal - discountAmount + tipAmount;

        
            int wholeAmount = (int) finalBill;

            
            System.out.println("\n===== SMART RESTAURANT =====");
            System.out.println("Customer: " + name);
            System.out.printf("Meal: $%.2f%n", mealPrice);
            System.out.printf("Drinks: $%.2f%n", drinksCost);
            System.out.printf("Discount: $%.2f%n", discountAmount);
            System.out.printf("Tip: $%.2f%n", tipAmount);
            System.out.printf("Final bill: $%.2f%n", finalBill);
            System.out.println("Whole amount: $" + wholeAmount);

            System.out.println("============================");
        }

        input.close();
    }
}
