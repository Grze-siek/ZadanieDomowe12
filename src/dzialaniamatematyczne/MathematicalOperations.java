package dzialaniamatematyczne;

import javax.security.sasl.SaslClient;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class MathematicalOperations {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("dzialania.txt");
        Scanner scan = null;
        try {
            scan = new Scanner(file);
            while(scan.hasNextLine()) {
                String nextLine = scan.nextLine();
                solveTheOperation(nextLine);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(scan != null)
                scan.close();
        }

    }

    private static void solveTheOperation(String nextLine) {
        String[] wyrazy = nextLine.split(" ");
        double solution = 0;
        int firstNumber = Integer.parseInt(wyrazy[0]);
        int secondNumber = Integer.parseInt(wyrazy[2]);
        String operator = wyrazy[1];
        switch(operator){
            case "+": {
                solution = firstNumber + secondNumber;
                break;
            }
            case "-": {
                solution = firstNumber - secondNumber;
                break;
            }
            case "*": {
                solution = firstNumber * secondNumber;
                break;
            }
            case "/": solution = firstNumber / secondNumber;
        }
        String equation = nextLine + " = " + String.valueOf(solution);
        System.out.println(equation);
        saveToFile(equation);
    }

    private static void saveToFile(String equation) {
        PrintWriter save = null;
        try {
            save = new PrintWriter("SolvedEquation.txt");
           // save.println(equation);
            save.write(equation);
            save.println();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            save.close();
        }
    }
}
