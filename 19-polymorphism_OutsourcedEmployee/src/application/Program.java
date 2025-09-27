package application;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // POLIMORFISMO: a lista é declarada com objetos instanciados
        // a partir da classe 'Employee', contudo a instanciação
        // prática é chamada ora pela a subclasse 'OutsourcedEmployee',
        // ora pela a própria classe 'Employee', conforme se verifica
        // no 'if else' abaixo, em que se instanciam os empregados
        // diretos e terceirizados, resultando numa lista 'polimórfica':
        List<Employee> list = new ArrayList<>();

        System.out.print("Enter the number of employees: ");
        int n = sc.nextInt();
        for (int i=1; i<=n; i++) {
            System.out.println("Employee #" + i + " data:");
            System.out.print("Outsourced (y/n)? ");
            char ch = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Hours: ");
            int hours = sc.nextInt();
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();
            if (ch == 'y') {
                System.out.print("Additional charge: ");
                double additionalCharge = sc.nextDouble();
                list.add(new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge));
            }
            else {
                list.add(new Employee(name, hours, valuePerHour));
            }
        }
        System.out.println();
        System.out.println("PAYMENTS:");
        for (Employee emp : list) {
            System.out.println(emp.getName() + " - $ " + String.format("%.2f", emp.payment()));
        }
    }
}

