import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int number = sc.nextInt();
        System.out.println();

        if (number % 2 == 0)
            System.out.printf("%d is even.%n", number);
        else
            System.out.printf("%d is odd.%n", number);

        sc.close();

    }
}
