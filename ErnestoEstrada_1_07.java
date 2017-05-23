/*Process grades and names from an input file; produce a report in an output 
  file based on the range of grades. 	
  Ernesto Estrada
  Program #7, CS 1050, Section 1
  JGRASP 2.0.1_09, MacBook Pro OS X El Capitan
  Renascent - Being reborn; springing again into being or vigor: a renascent 
  interest in Henry James.
  "In life, it's not the genetic guy who wins or the guy with the most 
  potential who wins; it's the person with the greatest perseverance who 
  wins. Always be willing to get up and go at it again and again. 
  That's the guy who has his hands raised later in life. 
  That's the guy you guys need to be." Greg Plitt (1977-2015) */

import java.util.Scanner;
import java.io.*;

public class ErnestoEstrada_1_07 {
	
	public static void heading(PrintWriter outputFile) {
		outputFile.write(toolKit.padString("Name", 20, "", " ") + 
				toolKit.padString("Grade", 6) + toolKit.padString("Message", 4)
				+ "\n" + toolKit.padString("", 19, "", "-") +
				toolKit.padString(" ", 6, "", "-") + 
				toolKit.padString(" ", 8, "", "-"));
		outputFile.println();
	}
	
	public static void gradeMessage(PrintWriter outputFile, String name, 
			int grade, String message) {
		outputFile.println(toolKit.padString(name, 19, "", " ") + 
				toolKit.leftPad(grade, 4, "0") + "   " + 
				toolKit.padString(message, 12, "", " "));
	}
	public static void results(PrintWriter outputFile, int linesProcessed, 
			int amontOfSatisfactory, double avgOfSatisfavtory, 
			double totalAverage) {
		outputFile.println("Number of lines processed: " + linesProcessed + 
				"\n" + "Number of grades between 70 and 89 is: " + 
				amontOfSatisfactory + "\n" + "With averages of: " + 
				toolKit.leftPad(avgOfSatisfavtory,  2, "0.0", " ") + 
				"\n" + "The average for the class is: " +
				toolKit.leftPad(totalAverage,  2, "0.0", " "));
	}
	
	public static void main(String[] args) throws IOException {	
	
		final String INPUT_FILE = "ErnestoEstrada_1_07_Input.txt";
		final String OUTPUT_FILE= "ErnestoEstrada_1_07_Output.txt";
		
		int amontOfSatisfactory = 0;
		int linesProcessed = 0;
		int grade = 0;
		double avgOfSatisfavtory = 0.0;
		double totalAverage = 0.0;
		String name; 
		String message;
	
		// Access the input/output files
		File inputDataFile = new File(INPUT_FILE);
		Scanner inputFile  = new Scanner(inputDataFile);
		FileWriter outputDataFile = new FileWriter(OUTPUT_FILE);
		PrintWriter outputFile = new PrintWriter(outputDataFile);

		// Creates heading for console and output file
		heading(outputFile);
		
		while (inputFile.hasNext()) {
			linesProcessed++;
			grade = inputFile.nextInt();
			name = inputFile.nextLine();
			name = name.trim();
			
			if (grade >= 90) {
				message = "OUTSTANDING";
			}
			else if (grade >= 70 && grade < 90) {
				message = "Satisfactory";
				avgOfSatisfavtory += grade;
				amontOfSatisfactory++;
			}
			else {
				message = "FAILING";
			}
			totalAverage += grade;
			gradeMessage(outputFile, name, grade, message);	
		}
		// Takes total grades and finds the average 
		totalAverage = (totalAverage / linesProcessed);
		
		// Takes total of all satisfactory grades then divides by the amount
		avgOfSatisfavtory = (avgOfSatisfavtory / amontOfSatisfactory);
		
		// Prints out the final message to the file 
		results(outputFile, linesProcessed, amontOfSatisfactory, 
				avgOfSatisfavtory, totalAverage);
		
		inputFile.close();
		outputFile.close();
      System.exit(0);
	}
}
