import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int number = sc.nextInt();

        if (number > 0)
            System.out.printf("%d is a positive number.%n", number);
        else if (number < 0)
            System.out.printf("%d is a negative number.%n", number);
        else
            System.out.println("You cannot enter null.");

        sc.close();
    }
}
