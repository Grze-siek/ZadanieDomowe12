package dzialaniamatematyczne;

import javax.security.sasl.SaslClient;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MathematicalOperations {
    public static void main(String[] args) {
        File file = new File("dzialania.txt");
        List<String[]> equations = readTheFile(file);
        List<String> solvedEquations = solveTheOperation(equations);
        saveToFile(solvedEquations);
    }

    private static List<String[]> readTheFile(File file) {
        List<String[]> equations = new ArrayList<>();
        String nextLine = null;
        Scanner scan = null;
        try {
            scan = new Scanner(file);
            while(scan.hasNextLine()) {
                nextLine = scan.nextLine();
                String[] wyrazy = nextLine.split(" ");
                equations.add(wyrazy);
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } finally {
            if(scan != null)
                scan.close();
        }
        return equations;
    }

    private static List<String> solveTheOperation(List<String[]> equations) {
        double solution = 0;
        List<String> solvedEquations = new ArrayList<>();
        for (String[] equation : equations) {

            int firstNumber = Integer.parseInt(equation[0]);
            int secondNumber = Integer.parseInt(equation[2]);
            String operator = equation[1];
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
            String stringEquation = firstNumber + " " + operator + " " + secondNumber;
            solvedEquations.add(stringEquation + " = " + String.valueOf(solution));
        }
        for (String solvedEquation : solvedEquations) {

            System.out.println(solvedEquation.toString());
        }
        return solvedEquations;
    }

    private static void saveToFile(List<String> equation) {
        PrintWriter save = null;
        try {
            save = new PrintWriter("SolvedEquation.txt");
            for (String newLine : equation) {
                save.println(newLine);
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } finally {
            save.close();
        }
    }
}
