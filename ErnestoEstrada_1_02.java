/*Interactive Average Program
   This program asks the user to input gross pay, savings and ivestment rates.
    with this information it calulate the amount of money that goes into each.
  Ernesto Estrada
  Program #2, CS 1050, Section 1
  JGRASP 2.0.1_09, MacBook Pro OS X El Capitan
  Cryophilic - preferring or thriving at low temperatures. 
  Work hard for what you want because it won't come to you without a fight. 
    You have to be strong and courageous and know that you can do anything you 
    put your mind to. If somebody puts you down or criticizes you, just keep on
    believing in yourself and turn it into something positive. 
            - Leah LaBelle (b.1986) */

import java.util.Scanner;

public class ErnestoEstrada_1_02 {

   public static void main(String[] args) {
                   
      Scanner input = new Scanner(System.in);
      double grossPay;      // Annual pay
      double savingsRate;   // Savings rate 
      double iraRate;       // IRA investment rate
      double totalSav;      // Tolal savings amount        
      double totalIra;      // Total IRA amount 
      double totalAmount;   // Total amount in both savings and IRA
      
      // Description of what this program will do
      System.out.println("This program calculate's how much of gross pay"
                  + "\ngoes into savings and investment accounts.");

      // Inputs of numbers
      System.out.print("Enter gross pay: ");
      grossPay = input.nextDouble();
      System.out.print("Enter savings rate: "); 
      savingsRate = input.nextDouble();
      System.out.print("Enter IRA investment rate: ");   
      iraRate = input.nextDouble();

      // Convert rates into decimals
      savingsRate = savingsRate / 100;   // %
      iraRate = iraRate / 100;           // %
      
      // Calculate savings, IRA, and total amounts
      totalSav = grossPay * savingsRate;
      totalIra = grossPay * iraRate;
      totalAmount = totalSav + totalIra;     

      // Output messages of final results 
      System.out.println("The amount of gross pay "
                  + "that goes into savings $" + totalSav);   
      System.out.println("The amount of gross pay "
                  + "that goes into an IRA $" + totalIra);
      System.out.println("Total amount that goes into both savings and IRA $"
                  + totalAmount);
      System.out.println("Ernesto Estrada");

      // Close files and exit
      input.close();
      System.exit(0);
   } // End main
} // End class
