package application;

import java.util.Scanner;
import entities.Employee;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Employee emp = new Employee();

        System.out.print("Name: ");
        emp.name = sc.nextLine();
        System.out.print("Gross salary: ");
        emp.grossSalary = sc.nextDouble();
        System.out.print("Tax: ");
        emp.tax = sc.nextDouble();

        System.out.println();
        System.out.println("Employee: " + emp);
        System.out.println();
        System.out.print("Which percentage to icrease salary? ");
        double percentage = sc.nextDouble();
        emp.increaseSalary(percentage);

        System.out.println();
        System.out.println("Updated data: " + emp);
        sc.close();
    }
}
