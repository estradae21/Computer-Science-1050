import java.util.Scanner;
import java.io.*;

public class ErnestoEstrada_1_10 {
	
	static Toolkit tools = new Toolkit();
	static final int MAX_EMPLOYEES = 30;
	static final int FEDERAL_TAX = 18;
	static final int IRA = 8;	
	static final double STATE_TAX = 4.5;
	
	public static int readData(Scanner inFile, String[] names, double[][] data) {
		int len = names.length;
		int nRead = 0;
		
		// hours [0] pay rate [1]
		while(inFile.hasNext()) {
		if(nRead < len) {
			data[nRead][0] = inFile.nextDouble();
			data[nRead][1] = inFile.nextDouble();
			names[nRead] = inFile.nextLine();
            names[nRead] = names[nRead].trim();
			} else {
			System.out.println("Number of employees on file is greater than Max number");
			System.out.println(" of employees allowed: " + len);
			System.out.println("EXITING...");
			System.exit(0); 		
			}			
	    nRead++;       
	    }  	
		return nRead;
	}
	
//**********************************************************************************
	
	public static void grossPayCalc(int nRead, double[][] data) {
		// hours [0] pay rate [1] gross pay [2]
		for(int i = 0; i < nRead; i++) {
			if(data[i][0] <= 40.0) {
				data[i][2] = data[i][0] * data[i][1];
			}
			else if(data[i][0] <= 50.0) {
				data[i][2] = data[i][1] * (40 + ((data[i][0] - 40) * 1.5));
			}
			else {
				data[i][2] = data[i][1] * (40 + 15 + ((data[i][0] - 50) * 2)); 
			}
		}
	}

//**********************************************************************************
	
	public static void IRA_CALC(int nRead, double[][] data) {
		// ira [5]
		for(int i = 0; i < nRead; i++) {
			data[i][5] = (double) (data[i][2] * IRA) / 100;
		}
	}
	
//**********************************************************************************
	
	@SuppressWarnings("static-access")
	public static void taxCalc(int nRead, double[][] data) {
		double taxes = 0.0;
		// taxes [6]
		for(int i = 0; i < nRead; i++) {
			taxes = 0.0;
			taxes = (double) (data[i][2] * FEDERAL_TAX) / 100;
			taxes += (double) (data[i][2] * STATE_TAX) / 100;
			data[i][6] = tools.roundNumber(taxes, 2);
		}
	}
	
//**********************************************************************************	
	
	public static void netPay(int nRead, double[][] data) {
		//[2] gross pay, [3] net pay, [6] taxes deducted.
		for(int i = 0; i < nRead; i++) {
			data[i][3] = (double) data[i][2] - data[i][6];
		}

	}
	
//**********************************************************************************
	
	@SuppressWarnings("static-access")
	public static void totalSavings(int nRead, double[][] data) {
		double savings = 0.0;
		//[3] net pay [4] savings amount [5] IRA investment amount 
		for(int i = 0; i < nRead; i++) {
			savings = (double) (data[i][3] * 10) / 100;
			data[i][4] = data[i][5] + tools.roundNumber(savings, 2);
		}
	}
	
//**********************************************************************************	
	
	public static void report(PrintWriter outFile, int nRead, String[] names, 
								double[][] data) {
		String heading = ("\t\tFabulous Furniture Company\n" +
						  "\t\t\tPayroll Report\n");
		String table = 
		 ("\nName		    Gross Pay   Net Pay   Savings     Taxes   Hours   Pay Rate\n" +
		  "------------------ ---------   -------   ------- ---------   -----   --------");
		System.out.println(heading + table);
		outFile.println(heading + table);
		
		showResults(outFile, nRead, names, data);
	}
	
	@SuppressWarnings("static-access")
	public static void showResults(PrintWriter outFile, int nRead, String[] names, 
									double[][] data) {
		//0] number of hours worked, [1] hourly pay rate, [2] gross pay, 
		//[3] net pay, [4] savings amount, [5] IRA investment amount and [6] taxes 
		for(int i = 0; i < nRead; i++) {
			String results = tools.padString(names[i], 19, "", " ") + 
					tools.leftPad(data[i][2], 9, "#,##0.00") + " " +
					tools.leftPad(data[i][3], 9, "#,##0.00") + " " +
					tools.leftPad(data[i][4], 9, "#,##0.00") + " " +
					tools.leftPad(data[i][6], 9, "#,##0.00") + " " +
					tools.leftPad(data[i][0], 7, "#,##0.00") + " " +
					tools.leftPad(data[i][1], 8, "#,##0.00");
			outFile.println(results);
			System.out.println(results); 
		}
		totals(outFile, nRead, names, data);
	}
	
	@SuppressWarnings("static-access")
	public static void totals(PrintWriter outFile, int nRead, String[] names, 
									double[][] data) {
		double grossPay = 0.0;
		double netPay = 0.0;
		double savings = 0.0;
		double taxes = 0.0; 
		double hours = 0.0;
		double averagePay = 0.0;
		//0] number of hours worked, [1] hourly pay rate, [2] gross pay, 
				//[3] net pay, [4] savings amount, [5] IRA investment amount and [6] taxes 
		for(int i = 0; i < nRead; i++) {
			grossPay += data[i][2];
			netPay += data[i][3];
			savings += (data[i][4] + data[i][5]);
			taxes += data[i][6];
			hours += data[i][0];
			averagePay += data[i][1];
		}
		
		averagePay /= nRead;
		
		String results = tools.leftPad(grossPay, 28, "#,##0.00") + " " +
				tools.leftPad(netPay, 9, "#,##0.00") + " " +
				tools.leftPad(savings, 9, "#,##0.00") + " " +
				tools.leftPad(taxes, 9, "#,##0.00") + " " +
				tools.leftPad(hours, 7, "#,##0.00") + " " +
				tools.leftPad(averagePay, 7, "#,##0.00");
		String output = ("------------------ ---------   -------   ------- ---------   -----"
				+ "   --------\n"
				+ results + "\n\nThere are " + nRead + " employees.\n");
		outFile.println(output);
		System.out.println(output);
	}
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws IOException {
		
		final String INPUT_FILE = "ErnestoEstrada_1_10_Input.txt";
		final String OUTPUT_FILE = "ErnestoEstrada_1_10_Output.txt";
			
		File inputDataFile = new File(INPUT_FILE);
		Scanner inputFile = new Scanner(inputDataFile);
		FileWriter outputDataFile = new FileWriter(OUTPUT_FILE);
		PrintWriter outputFile = new PrintWriter(outputDataFile);
		System.out.println("Reading File" + INPUT_FILE + "\r\n" +
								"Creating new file" + OUTPUT_FILE +"\r\n");
			
		String [] employees = new String[MAX_EMPLOYEES];
		double[][] employeePay = new double[MAX_EMPLOYEES][7];
		int nRead = 0;
		
		nRead = readData(inputFile, employees, employeePay);
		
		grossPayCalc(nRead, employeePay);
		IRA_CALC(nRead, employeePay);	
		taxCalc(nRead, employeePay);
		netPay(nRead, employeePay);
		totalSavings(nRead, employeePay);
		report(outputFile, nRead, employees, employeePay);
		tools.selectionSortStringWithNumbers(employees, employeePay, nRead, -1);
		report(outputFile, nRead, employees, employeePay);
		tools.selectionSortStringWithNumbers(employees, employeePay, nRead, 2);
		report(outputFile, nRead, employees, employeePay);
		inputFile.close();
		outputFile.close();
		}
}
