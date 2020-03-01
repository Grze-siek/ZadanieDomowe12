package statystykifirmy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Data {
    public static void main(String[] args) {
        File file = new File("company.txt");
        readingData(file);

    }

    private static void readingData(File file) {
        Scanner scan = null;
        try {
            scan = new Scanner(file);
            while(scan.hasNextLine()) {
                String nextLine = scan.nextLine();
                saveToArray(nextLine);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            scan.close();
        }
    }

    private static Employee[] saveToArray(String nextLine) {
        int index = 1;
        String[] employeeData = nextLine.split(";");
        Employee[] employees = new Employee[index];
        employees[0] = new Employee(employeeData[0], employeeData[1], employeeData[2], employeeData[3], employeeData[4]);
         index++;
        System.out.println(Arrays.toString(employees));
        return employees;
    }
}
