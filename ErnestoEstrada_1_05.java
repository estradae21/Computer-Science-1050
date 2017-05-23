/*Interactive Average Program
  This program asks the user to input gross pay, savings and investment rates.
  with this information, it calculates the amount of money that goes into each.
  This program will use methods to call for each step. 
  Ernesto Estrada
  Program #5, CS 1050, Section 1
  JGRASP 2.0.1_09, MacBook Pro OS X El Capitan
  Bissextus - February 29th: the extra day added to the Julian calendar every 
  fourth year (except those evenly divisible by 400) to compensate for the 
  approximately six hours a year by which the common year of 365 days falls 
  short of the solar year. 
  "You have to fight to reach your dream. You have to sacrifice and 
   work hard for it." - Lionel Messi (b.1987)*/

import java.util.Scanner;

public class ErnestoEstrada_1_05 {

   public static void outputExplanation () {
       System.out.println("Program will use your gross pay to calculate your "
                           + "savings and IRA amount with each rates");
       System.out.println("This program will use methods");
       System.out.println("Ernesto Estrada");
   } // Close method outputExplenation

   public static double validNumber (double userInput) {  
       if (userInput > 0) {
       return userInput;
       } // End if
       else {
             System.out.println("You cannot have a number less than zero.");
             userInput = 0;
       return userInput;
       } // End else
   } // End validNumber

   public static double totalSavingsAmount (double grossPay, 
                                             double savingsRate) {                
       double totalSavM = 0;
       totalSavM = (grossPay * savingsRate) / 100.0;   
       return totalSavM;
   } // End method totalSavingsAmount

   public static double totalIraAmount (double grossPay, double iraRate) {              
       double totalIraM = 0;
       totalIraM = (grossPay * iraRate) / 100.0;
       return totalIraM;
   } // End method totalIraAmount

   public static void results (double grossPay, double savingsRate,
                            double iraRate, double totalSav, double totalIra) {
       double totalAmount; // Total amount in both savings and IRA
       totalAmount = totalSav + totalIra; // Total amount of Savings and IRA
       System.out.println("The Gross pay is " + 
                           String.format("%.2f",grossPay));
       System.out.println("The savings rate is " +
                           String.format("%.1f",savingsRate));
       System.out.println("The IRA rate is " + 
                           String.format("%.1f",iraRate));
       System.out.println("The savings amount is " + 
                           String.format("%.2f",totalSav));
       System.out.println("The IRA amount is " + 
                           String.format("%.2f",totalIra));
  	    System.out.println("The total savings and IRA is " +
                           String.format("%.2f",totalAmount));
   } // End method results

   public static void main(String[] args) {

       Scanner input = new Scanner(System.in);

       double grossPay = 0;    // Annual pay
       double savingsRate = 0; // Savings rate
       double iraRate = 0;     // IRA investment rate
       double totalSav;        // Total savings amount
       double totalIra;        // Total IRA amount

       //  Program explanation
       outputExplanation();

       // Prompt for gross pay, savings, and IRA rates
       System.out.println("Enter gross pay, savings, and IRA " +
                           "percentage rates.");

       while (grossPay == 0) {
               System.out.print("Gross pay: ");
               grossPay = validNumber(input.nextDouble());
       } // End While loop

       while (savingsRate == 0) {
               System.out.print("Savings rate: ");
               savingsRate = validNumber(input.nextDouble());
       } // End while loop
       
       while (iraRate == 0) {
              System.out.print("IRA rate: ");
              iraRate = validNumber(input.nextDouble());
       } // End while loop
       
       // Method to calculate the savings amount
       totalSav = totalSavingsAmount (grossPay, savingsRate);
         
       // Mehtod to calculate the IRA amount  
       totalIra = totalIraAmount (grossPay, iraRate);

       // Method to display final results 
       results (grossPay, savingsRate,iraRate, totalSav, totalIra);

       // Close files and exit
       input.close();
       System.exit(0);
   } // End main
} // End class