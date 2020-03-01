package sumaliczbdodatnich;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SumPositiveNumbers {
    public static void main(String[] args) {
        List<Double> numbers = new ArrayList<>();
        System.out.println("Wprowadz liczbe dodatnia:");
       for(double number = loadNumber(); number >= 0; number = loadNumber()) {
            numbers.add(number);
        }
        System.out.println(numbers.toString());
        if(numbers.size() > 1) {
            showReverseOrder(numbers);
            showSum(numbers);
            maxMinNumber(numbers);
        }
    }

    public static double loadNumber() {
        Scanner scan = new Scanner(System.in);
        if(scan.hasNextDouble()) {
            double number = scan.nextDouble();
            return number;
        }
        scan.close();
        return -1;
    }
    public static void showReverseOrder(List list) {
        List newList = new ArrayList();
        for (int i = list.size() - 1; i >= 0 ; i--) {
            newList.add(list.get(i));
        }
        System.out.println(newList.toString());
    }
    public static void showSum(List<Double> list) {
        double sum = 0;
        for (Object o : list) {
            sum += (Double)o;
            if(o == list.get(list.size() - 1))
                System.out.print(o);
            else
                System.out.print( o + " + ");
        }

        System.out.println(" = " + sum);
    }
    public static void maxMinNumber(List<Double> list) {
        double min = list.get(0);
        double max = list.get(0);
        for (Double o : list) {
            if(o > max)
                max = o;
        }
        for (Double o : list) {
            if(o < min)
                min = o;
        }
        System.out.println("Najkwieksza liczba to: " + max);
        System.out.println("Najmniejsza liczba to: " + min);
    }
}
