/*
Write a program that receives input from user for the following:
Annual income,
Married or Single

Tax brackets (flat taxation):
Less than $20000,      No Income Tax.
[20000-30000)                 5%
[30000-50000)               10%
[50000-100000)              25%
>= 100000                      35%

Married will get 1% rebate if income is 20000-30000, 2% rebate if income is 30000-50000, 5% rebate if income is 50000-100000, 7% rebate if income is greater than 100000.

The program should print the income tax.

Use any of the previous programs that compute the income tax of a citizen, write a new program that uses the same logic inside a while loop to compute tax of three citizens. 

Hint: the body of the while loop should include the taxation.*/

import java.util.*;
public class TaxWhile {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int count = 0;
        while(count<3){
            System.out.print("Enter your Name: ");
           String Name = sc.nextLine();
           System.out.print("Enter your income: ");
            Double income = sc.nextDouble();
            System.out.print("Enter your Status, (M) for Married and (S) for Single: ");
            char status = sc.next().charAt(0);
            while (status != 'M' && status != 'm' && status != 'S' && status != 's') {
                System.out.println("Invalid Status. Please enter 'M' for Married or 'S' for Single.");
                System.out.print("Enter your Status, (M) for Married and (S) for Single: ");
                status = sc.next().charAt(0);
            }
            sc.nextLine();


            double tax = tax(income);
            double rebate = rebate(income, status, tax);
            System.out.printf("The tax for %s is: $%.2f%n", Name, tax);
            System.out.printf("The rebate for %s is: $%.2f%n", Name, rebate);
            System.out.printf("The tax for %s after rebate is: $%.2f%n", Name, (tax - rebate));
            System.out.print("Would you like to check for another citizen? Y/N: ");
            char choice = sc.next().charAt(0);
           
            while (choice != 'y' && choice != 'Y' && choice != 'n' && choice != 'N') {
                System.out.println("Invalid Choice. Please enter 'Y' Or 'N'.");
                System.out.print("Would you like to check for another citizen? Y/N: ");
                choice = sc.next().charAt(0);
            }
                if(choice == 'N' || choice == 'n') 
                break;
                
                 
                
           
            count++;
            sc.nextLine();
            if (count == 3){
                System.out.println("You've reached today's limit for checking citizens' tax details. Please try again tomorrow. Thank you!");
                sc.close();
            }
        }
    }

    public static double tax(double income) { 
        if (income < 20000) return 0;
        if (income < 30000) return income * 0.05;
        if (income < 50000) return income * 0.10;
        if (income < 100000) return income * 0.25;
        return income * 0.35;
    }

    public static double rebate(double income, char status, double tax) {
        if (status == 'M' || status == 'm') {
            if (income >= 20000 && income < 30000) return tax * 0.01;
            if (income >= 30000 && income < 50000) return tax * 0.02;
            if (income >= 50000 && income < 100000) return tax * 0.05;
            if (income >= 100000) return tax * 0.07;
        }
        return 0;
    }
}
