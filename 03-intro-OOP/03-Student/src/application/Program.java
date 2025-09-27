package application;

import java.util.Scanner;

import entities.Student;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Student stdt = new Student();

        System.out.print("Name: ");
        stdt.name = sc.nextLine();
        System.out.println();
        System.out.print("First quarter grade: ");
        stdt.fstQuarter = sc.nextDouble();
        System.out.print("Second quarter grade: ");
        stdt.secQuarter = sc.nextDouble();
        System.out.print("Third quarter grade: ");
        stdt.trdQuarter = sc.nextDouble();
        System.out.println();

        System.out.printf("FINAL GRADE: %.2f%n", stdt.finGrade());
        if (stdt.finGrade() >= 60.00) {
            System.out.println("PASS");
        }
        else {
            System.out.println("FAILED");
            System.out.printf("MISSING %.2f POINTS.%n", stdt.missingPoints());
        }
        sc.close();

    }
}
