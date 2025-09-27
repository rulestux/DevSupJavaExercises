package application;

import java.util.Scanner;
import entities.Rectangle;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Rectangle rectangle = new Rectangle();

        System.out.println("Enter the width: ");
        rectangle.width = sc.nextDouble();
        System.out.println("Enter the height: ");
        rectangle.height = sc.nextDouble();

        System.out.printf("The area is: %.2f%n", rectangle.area());
        System.out.printf("The perimeter is: %.2f%n", rectangle.perimeter());
        System.out.printf("The diagonal is: %.2f%n", rectangle.diagonal());

        sc.close();
    }
}
