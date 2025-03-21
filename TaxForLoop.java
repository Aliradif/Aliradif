import java.util.*;
public class TaxForLoop {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int count = 0; Double income = 0.0; char status = ' ';
        for (; count < 3; count++) 
        {
            
            System.out.print("Enter your Name: ");
            String Name = sc.nextLine();
           
          while (true) {
            
           try{      
            System.out.print("Enter your income: ");
            income = sc.nextDouble();
            break;}
            catch(Exception e){
                System.out.println("Invalid input. please enter a number, you entered a " + sc.nextLine());
                            }      
        }
            System.out.print("Enter your Status, (M) for Married and (S) for Single: ");
            status = sc.next().charAt(0);
            
            for (;!(status == 'M' || status == 'm' || status == 'S' || status == 's');){
                System.out.println("Invalid Status. Please enter 'M' for Married or 'S' for Single.");
                System.out.print("Enter your Status, (M) for Married and (S) for Single: ");
                status = sc.next().charAt(0);
                sc.nextLine();
        
            }

            double tax = tax(income);
            double rebate = rebate(income, status, tax);
            System.out.printf("The tax for %s is: $%.2f%n", Name, tax);
            System.out.printf("The rebate for %s is: $%.2f%n", Name, rebate);
            System.out.printf("The tax for %s after rebate is: $%.2f%n", Name, (tax - rebate));
            
            System.out.print("Would you like to check for another citizen? Y/N: ");
            char choice = sc.next().charAt(0);
            
           
           
         for (; (choice!= 'y' && choice != 'Y' && choice != 'n' && choice != 'N');) {
                System.out.println("Invalid Choice. Please enter 'Y' Or 'N'.");
                System.out.print("Would you like to check for another citizen? Y/N: ");
                choice = sc.next().charAt(0);           
         }
                        
              if(choice == 'N' || choice == 'n')  break;
        
            sc.nextLine();

            if (count == 2) {
                System.out.println("You've reached today's limit for checking citizens' tax details. Please try again tomorrow. Thank you!");
            }
        }
        sc.close();  
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
