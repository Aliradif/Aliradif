import java.util.*;


public class Tax {
    public static void main(String[] args) {

        double TaxRate, Rebate, income;
        char MaritalStatus;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your annual income: ");
        income = scanner.nextDouble();

        System.out.print("Enter your marital status (S for single, M for married): ");
        MaritalStatus = Character.toUpperCase(scanner.next().charAt(0));

        TaxRate = income < 20000 ? 0.0 : income < 30000 ? 0.05 : income < 50000 ? 0.10 : income < 100000 ? 0.25 : 0.35;

        Rebate = MaritalStatus == 'M' ? (income < 20000 ? 0.04 : income < 30000 ? 0.03 : income < 50000 ? 0.02 : income < 100000 ? 0.01 : 0.0) : 0.0;

        double tax = income * TaxRate * (1 - Rebate);
        System.out.printf("Your income tax is: $%.2f%n", tax);
        
        scanner.close();
    }
}