import javax.swing.JOptionPane; 
import java.util.StringTokenizer;

public class ErnestoEstrada_1_03 {

   public static void main(String[] args) {
       
   String inputName;
   String inputNum;
   String inputNum2;
   StringTokenizer st;
   StringTokenizer st2;
   int num1;
   int num2;
   int sum;
   
   inputName = JOptionPane.showInputDialog(
            "Good afternoon, what is your name?");         
   inputNum = JOptionPane.showInputDialog(
            "Please input first numbers: ");
   inputNum2 = JOptionPane.showInputDialog(
            "Please input second numbers: ");
            
   st = new StringTokenizer(inputNum);
   st2 = new StringTokenizer(inputNum2);
   
   num1 = Integer.parseInt(st.nextToken());
   num2 = Integer.parseInt(st2.nextToken());
   
   sum = num1 + num2;
   
   JOptionPane.showMessageDialog(null, 
              "Name: " + inputName + "\n" +
              "First number: " + num1 + "\n" +
              "Second number: " + num2 + "\n" +
              "Sum of numbers: " + sum);
              
   
   


   

            
      // Close files and exit
      System.exit(0);
   } // End main
} // End classinput