/*Calculate mileage reimbursement based on a table.
  This program reads the input file, creates arrays, and  will calculate mileage 
  reimbursements using if/else/if statements. It will also keep track of the 
  positive numbers, numbers to process, and add the totals of the miles and 
  reimbursements. All of this information will be sent to view on the console 
  and will also be in a file that the program will create. 	
  Ernesto Estrada
  Program #8, CS 1050, Section 1
  JGRASP 2.0.1_09, MacBook Pro OS X El Capitan
  Endemic - Natural to or characteristic of a specific people or place; native; 
  	indigenous. Belonging exclusively or confined to a particular place. An 
  	endemic disease. 
  "The most important six inches on the battlefield is between your ears."
  					- General James "Mad Dog" Mattis (b.1950)
 */
import java.util.Scanner;
import java.io.*;

public class ErnestoEstrada_1_08 {
	
	static toolKit tools = new toolKit(); 
	static final String CURRENCY_MASK = "#,##0.00";
	static final String NUMBER_MASK = "#,##0.0";
	
	public static void programSum(PrintWriter outputFile) {
		String line = "Calculates mileage reimbursement using arrays.\n"
				+ "Once it calculates the information it will print to screen\n"
				+ "and it will also write a file with the information";
		System.out.println(line);
		outputFile.write(line);
		outputFile.println();
	}
//*****************************************************************************	
	public static void heading(PrintWriter outputFile) {
		String line = ("\n Mileage  " + "  Reimbursement \n" +  "________  " 
	            + "  _____________\n");
		System.out.print(line);
		outputFile.print(line);
		
	}
//*****************************************************************************		
	public static int readData(Scanner inp, double[] values) {
		int nRead = 0;
		
		// Begins to read the data and send to information to the array
		while (nRead < values.length && inp.hasNext()) {
			values[nRead] = inp.nextDouble();
         nRead++;
		}	
		return nRead;
	}
//*****************************************************************************		
	public static void calcReimbursement(double[] miles, double[] reimb, 
                                                               int value) {
		double base = 0.0;
		double rate = 0.0;
		double overage = 0.0;
		
		// begining of the reimbursement calculations 
		for (int i = 0; i < value; i++){
			if (i == value) break;
			else if (miles[i] <= 0) 	
				{base = 0.0; rate = 0.0; overage = 0.0;}
			else if (miles[i] < 400) 	
				{base = 0.0; rate = .18; overage = miles[i];}
			else if (miles[i] < 900) 	
				{base = 65.0; rate = .15; overage = miles[i] - 400;}
			else if (miles[i] < 1300)   
				{base = 115.0; rate = .12; overage = miles[i] - 900;}
			else if (miles[i] < 1900)   
				{base = 140.0; rate = .10; overage = miles[i] - 1300;}
			else if (miles[i] < 2600)	
				{base = 165.0; rate = .08; overage = miles[i] - 1900;}
			else 						
				{base = 195.0; rate = .06; overage = miles[i] - 2600;}
		reimb[i] = base + rate * overage;
		} // End for loop
	} // End reimbursements calculator
//*****************************************************************************	
	public static void detailLines(PrintWriter outputFile, double[] miles, 
													double[] reimbursements) {
		String noMileage = "*****";
		
		for (int i = 0; i < miles.length; i++) {
			if (i == miles.length) break;
			else if (reimbursements[i] > 0) {
				String line1 = tools.leftPad(miles[i],  8, NUMBER_MASK)
						+ tools.leftPad(reimbursements[i], 12, CURRENCY_MASK);
				System.out.println(line1);
				outputFile.println(line1);
			}
			else {
				String line2 = tools.leftPad(miles[i],  8, NUMBER_MASK)
						+ tools.padString(noMileage, 12, " ", "");
				System.out.println(line2);
				outputFile.println(line2);
			}
		}
	}
//*****************************************************************************	
	public static double[] avCalc(double[] miles, double[] reimb, int value) {
		double sumMiles = 0.0;					// Local variable for total miles
		double sumReimb = 0.0;					// Local total reimbursement value
		double milesAvg = 0.0;				   // Value for average of miles
		double reimbAvg = 0.0;				   // Value for average of reimbursements
		double[] avCalc = new double[4];	   // Array for both averages and totals
		   
		// Begins calculating the averages 
		for (int i = 0; i < value; i++) {
			sumMiles += miles[i];
         sumReimb += reimb[i];
		}
		if (value > 0) {
	      milesAvg = sumMiles / value;
         reimbAvg = sumReimb / value;
		}
      // sends results to array 
		avCalc[0] = sumMiles;			
		avCalc[1] = milesAvg;
      avCalc[2] = sumReimb;
      avCalc[3] = reimbAvg;
		
		return avCalc;
	} 
//*****************************************************************************
	public static int positiveNum(double[] values, int nValue) {
		int pos = 0;	// Local variable for positive numbers
		
		// begins to find all the positive miles in array
		for (int i = 0; i < nValue; i++) {
			if (i == nValue) break;
			if (values[i] > 0) {
				++pos;
			}
		}
		return pos;
	}
//*****************************************************************************
	public static void outputSummary (PrintWriter outputFile, int nValues, 
			int nRead, double[] averages) { 
		// Creating string to display end result message
		String finalLine = "\nThe total miles is " + 
			tools.leftPad(averages[0], 2, NUMBER_MASK) +
			"\nThe total amount of reimbursement is " + 
			tools.leftPad(averages[2], 2, CURRENCY_MASK) + 
			"\nThe number miles that were processed is " +
			nValues + "\nThe amount of miles that were greater than zero  " + 
			nRead + "\nThe average miles travel is " + 
			tools.leftPad(averages[1], 2, NUMBER_MASK) + 
			 "\nThe average reimbursement is " + 
			tools.leftPad(averages[3], 2, CURRENCY_MASK);
		
		System.out.println(finalLine);
		outputFile.println(finalLine);
	}
//*****************************************************************************
	public static void main(String[] args) throws IOException {
		
		final String INPUT_FILE = "ErnestoEstrada_1_08_Input.txt";
		final String OUTPUT_FILE = "ErnestoEstrada_1_08_Output.txt";
      
      // Access the input/output files
	    File inputDataFile = new File(INPUT_FILE);
	    Scanner inputFile  = new Scanner(inputDataFile);
	    FileWriter outputDataFile = new FileWriter(OUTPUT_FILE);
	    PrintWriter outputFile = new PrintWriter(outputDataFile);
	    System.out.println("Reading  file " + INPUT_FILE + "\r\n" +
		                   "Creating file " + OUTPUT_FILE + "\n");
      
      int posNumbers = 0;
		int nValues = inputFile.nextInt();		// Amount of values that will be processed 
      int nRead = 0;                         // Value that will be processed
		double totalMiles = 0.0;	            // Sum of the miles traveled 
		double totalReimburse = 0.0;           // Sum of all the reimbursements
      // List containing value of all the miles
		double[] miles = new double[nValues];				
      // List containing value of all the miles reimbursement
		double[] reimbursements = new double[nValues];	
      // List containing averages of the miles and reimbursements
		double[] averages = new double[4];			
		
	   // Creates message to explain what the program does to the user
	   programSum(outputFile);
	    
	   // Creates heading for console and output file
      heading(outputFile);
 	    
      // Reading the file and transferring data to the miles array
	   nRead = readData(inputFile, miles);
 	    
 	   // Sends miles array to a method that will calculate the reimbursements 
 	   // and will transfer the results to the reimbursements array
 	   calcReimbursement(miles, reimbursements, nRead);
 	    
 	   // This method will read both the miles and reimbursement arrays and 
 	   // create a table the will sent to the console and will print 
 	   // information on a different file
 	   detailLines(outputFile, miles, reimbursements);
 	    
 	   // Method that will calculate the averages and totals of miles and of 
 	   // reimbursements and will create a new array with both results 
 	   averages = avCalc(miles, reimbursements, nRead);
 	    
      // Uses a method to count positive miles and assigning that result to 
 	   // to given variable 
 	   posNumbers = positiveNum(miles, nRead);
 	    
 	   // Organize and write the left over information to the console and file 
 	   outputSummary (outputFile, nValues, posNumbers, averages);
 	   
 	   inputFile.close();
      outputFile.close();  
	} // End Main
} // End Class	
