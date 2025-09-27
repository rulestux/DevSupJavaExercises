import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("Enter your ID number: ");
    int id = sc.nextInt();
    System.out.println("Enter hours worked total: ");
    int hoursWorked = sc.nextInt();
    System.out.println("Enter your hourly wage:  ");
    double wage = sc.nextDouble();
    System.out.println();

    double salary = hoursWorked * wage;
    System.out.printf("Number %d, your salary is: U$ %.2f.%n", id,  salary);


    sc.close();
    }
}
