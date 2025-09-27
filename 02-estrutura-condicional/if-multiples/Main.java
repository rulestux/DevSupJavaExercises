import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        int number1 = sc.nextInt();
        System.out.println();
        System.out.println("Enter the second number: ");
        int number2 = sc.nextInt();
        System.out.println();

        if (number1 % number2 == 0 || number2 % number1 == 0)
            System.out.println("They are multiples.");
        else
            System.out.println("They are not multiples.");
        sc.close();

    }
}
