package application;

import java.util.Scanner;

import model.services.InterestService;
import model.services.UsaInterestService;

public class Program {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Amount: $");
        double amount = sc.nextDouble();
        System.out.print("Months: ");
        int months = sc.nextInt();
        sc.nextLine();

        // com a implementação da interface 'InterestService', esta é a
        // única linha a ser eventualmente alterada, quando necessário,
        // para substituir o 'new UsaInterestService(1.0)' pelo
        // 'new BrazilInterestService(2.0)':
        InterestService is = new UsaInterestService(1.0);
        double payment = is.payment(amount, months);

        System.out.println("Payment after " + months + " months:");
        System.out.println(String.format("%.2f", payment));

        sc.close();
    }
}
