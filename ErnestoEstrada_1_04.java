/*Interactive Average Program
  This program reads an inputfile. Then computes input gross pay, savings and 
  ivestment rates. Also finds number of valid lines and prints results to 
  console and creates a new output file with results.
  Ernesto Estrada
  Program #4, CS 1050, Section 1
  JGRASP 2.0.1_09, MacBook Pro OS X El Capitan
  Apatetic - Zoology. assuming colors and forms that effect deceptive 
  camouflage. 
  "Work hard for what you want because it won't come to you without a fight. 
  You have to be strong and courageous and know that you can do anything you 
  put your mind to. If somebody puts you down or criticizes you, just keep on 
  believing in yourself and turn it into something positive." 
            - Leah LaBelle (b1986) */

import java.util.Scanner;
import java.io.*;

public class ErnestoEstrada_1_04 {
   
   public static void main(String[] args) throws IOException {
      
      final String INPUT_FILE  = "ErnestoEstrada_1_04_Input.txt";
		final String OUTPUT_FILE = "ErnestoEstrada_1_04_Output.txt";
      
      int numberOfLines = 0;      // Number of numbers in the input file
      int numberOfValidLines = 0; // Number of valid numbers in the input file
		double grossPay = 0.0;        // Gross pay per line.   
		double sumGrossPay = 0.0;	    // The sum of the grossPay.		

		double savingsRate = 0.0;     // Savings rate per line.   
		double sumSavings = 0.0;	    // The sum of the savings.		
		double savingsAmount = 0.0;   // Savings amount.
		
		double iraRate = 0.0; 	       // IRA rate per line.   
		double sumIRA = 0.0;  	       // sum of the IRA amount.		
		double iraAmount = 0.0;       // IRA amount.
                  
      // Access the input/output files
      File inputDataFile = new File(INPUT_FILE);
      Scanner inputFile  = new Scanner(inputDataFile);
      FileWriter outputDataFile = new FileWriter(OUTPUT_FILE);
      PrintWriter outputFile = new PrintWriter(outputDataFile);
      System.out.println("Reading  file " + INPUT_FILE + "\r\n" +
	                   "Creating file " + OUTPUT_FILE);
                      
      System.out.println("Gross pay Savings rate " + 
                  "Savings amount IRA rate IRA amount");
      System.out.println("_________ ____________ " +
                  "______________ ________ __________");
      outputFile.write("Gross pay Savings rate " + 
                  "Savings amount IRA rate IRA amount");
      outputFile.println();
      outputFile.write("_________ ____________ " +
                  "______________ ________ __________");
      outputFile.println();
      
      while (inputFile.hasNext()) {
        numberOfLines++;
        String[] line = inputFile.nextLine().split("\\s+"); 
        grossPay = Double.parseDouble(line[0]);
        savingsRate = Double.parseDouble(line[1]);
        iraRate = Double.parseDouble(line[2]);
        
         if (grossPay > 0 && savingsRate > 0 && iraRate > 0) {
            numberOfValidLines++; 
            sumGrossPay += grossPay;
            savingsAmount = (savingsRate * grossPay) / 100.0; 
            sumSavings += savingsAmount;
            iraAmount = (iraRate * grossPay) / 100.0;
            sumIRA += iraAmount;
            
            String resultMessage = (String.format("%.2f", grossPay) + "\t\t"
                  + String.format("%.1f", savingsRate) + "\t"
                  + String.format("%.2f", savingsAmount) + "\t\t"
                  + String.format("%.1f", iraRate) + "\t\t"
                  + String.format("%.2f", iraAmount));
                  outputFile.println();
                  
            // Write to console 
            System.out.println(resultMessage);  
                  
            // Write to output File
			outputFile.write(resultMessage);
            
        }   // End if
      }  // End while
        
      // Number of total and valid lines to file
      outputFile.write("\nNumber Of Lines: \t" + numberOfLines );	
      outputFile.println();
		outputFile.write("Number of Valid Lines: \t" + numberOfValidLines );
      
      // Number of total and valid lines to console
      System.out.println("\nNumber Of Lines: \t" + numberOfLines );	
		System.out.print("Number of Valid Lines: \t" + numberOfValidLines );
		
		// Sum to file
      outputFile.write("\nSum of Gross Pay \t" + 
                        String.format("%.2f",sumGrossPay) );
      outputFile.println();
		outputFile.write("Sum of Savings \t" + 
                        String.format("%.2f",sumSavings) );
      outputFile.println();
      outputFile.write("Sum of IRA \t" + String.format("%.2f",sumIRA) );
      
      // Sum to console
      System.out.println("\nSum of Gross Pay \t" + 
                        String.format("%.2f",sumGrossPay) );     
		System.out.println("Sum of Savings \t" + 
                        String.format("%.2f",sumSavings) );     
      System.out.println("Sum of IRA \t" + String.format("%.2f",sumIRA) );
      
		// Averages to file
		if(numberOfValidLines != 0) {
         outputFile.println();
         outputFile.write("Average of Gross Pay: \t" + 
                        String.format("%.2f",sumGrossPay/numberOfValidLines) );
         outputFile.println();
         outputFile.write("Average of Savings: \t" + 
                        String.format("%.2f",sumSavings/numberOfValidLines) );
         outputFile.println();
         outputFile.write("Average of IRA: \t" + 
                        String.format("%.2f",sumIRA/numberOfValidLines ));
      } // End if
      
      // Averages to console
      if(numberOfValidLines != 0) {         
         System.out.println("Average of Gross Pay: \t" + 
                        String.format("%.2f",sumGrossPay/numberOfValidLines) );
         System.out.println("Average of Savings: \t" + 
                        String.format("%.2f",sumSavings/numberOfValidLines) );
         System.out.println("Average of IRA: \t" + 
                        String.format("%.2f",sumIRA/numberOfValidLines ));
      } // End if
                 
      // Close files and exit
      inputFile.close();
      outputFile.close();
      System.exit(0);
      
   } // End main
} // End class