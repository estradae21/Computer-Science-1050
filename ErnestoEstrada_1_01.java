/* Interactive Average Program  	
    Ernesto Estrada
    Program #1, CS 1050, Section 1
    JGRASP 2.0.1_09, MacBook Pro OS X El Capitan
    Cupidity - eager or excessive dersire, especially to posses something;
               greed; avarice; 
    "The soldier above all prays for peace, for it is the soldier that must
      suffer and bear the deepest wounds and scars of war." 
            -Douglas MacArthur (1880-1964)
 */

import java.util.Scanner;

public class ErnestoEstrada_1_01 {

   public static void main (String [ ] args)  { 
                 
      Scanner console = new Scanner(System.in);
      double num1, num2;      // Input values
      double average;         // Average of the input values

      // Explain the program to the user
      System.out.println("This program averages two real numbers.");

      // Input the two numbers 
      System.out.print("Input your first number: "); 
      num1 = console.nextDouble();
      System.out.print("Input your second number: ");
      num2 = console.nextDouble();

      // Calculate the average of the two numbers
      average = (num1 + num2) / 2.0;

      // Output the results
      System.out.print("The average of " + num1);
      System.out.println(" and " + num2 + " is " + average);
      System.out.println("Ernesto Estrada");

      // Close files and exit
      console.close();
      System.exit(0);
   } // End main
} // End class

