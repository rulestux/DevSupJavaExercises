package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import entities.Worker;
import java.util.Scanner;

import entities.HourContract;
import entities.Worker;
import entities.Department;
import entities.enums.WorkerLevel;

public class Program {

    public static void main(String[] args) throws ParseException {

    Scanner sc = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    System.out.print("Enter department's name: ");
    String departmentName = sc.nextLine();
    System.out.println("Enter worker data: ");
    System.out.print("Name: ");
    String workerName = sc.nextLine();
    System.out.print("Level: ");
    String workerLevel = sc.nextLine();
    System.out.print("Base salary: $ ");
    double baseSalary = sc.nextDouble();
    // instanciação de novo objeto do tipo 'Worker' cujos dados são os
    // parâmetros entre (): workerName, workerLevel, baseSalary, novo
    // objeto 'new Department' instanciado entre () como o conteúdo
    // de 'departmentName':
    Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));

    System.out.print("How many contracts to this worker? ");
    int n = sc.nextInt();

    for (int i=1; i<=n; i++) {
        System.out.println("Enter contract #" + i + " data: ");
        System.out.print("Date (DD/MM/YYYY): ");
        Date contractDate = sdf.parse(sc.next());
        System.out.print("Value per hour: $ ");
        double valuePerHour = sc.nextDouble();
        System.out.print("Duration (hours): ");
        int hours = sc.nextInt();
        HourContract contract = new HourContract(contractDate, valuePerHour, hours);
        worker.addContract(contract);
    }

    System.out.println();
    System.out.print("Enter month and year to calculate income (MM/YYYY): ");
    String monthAndYear = sc.next();
    int month = Integer.parseInt(monthAndYear.substring(0, 2));
    int year = Integer.parseInt(monthAndYear.substring(3));
    System.out.println("Name: " + worker.getName());
    System.out.println("Department: " + worker.getDepartment().getName());
    System.out.println("Income for " + monthAndYear + ": " + String.format("$ %.2f", worker.income(year, month)));
    }
}
