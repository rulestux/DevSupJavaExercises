package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaypalService;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Enter contract data:");
        System.out.print("Number: #");
        int number = sc.nextInt();
        sc.nextLine();
        System.out.print("Date (DD/MM/YYYY): ");
        LocalDate date = LocalDate.parse(sc.next(), fmt);
        System.out.print("Contract value: $");
        double totalValue = sc.nextDouble();
        sc.nextLine();

        Contract obj = new Contract(number, date, totalValue);

        System.out.print("Enter the number of installments: #");
        int n = sc.nextInt();
        sc.nextLine();

        ContractService contractService = new ContractService(new PaypalService());

        contractService.processContract(obj, n);

        System.out.println();
        System.out.println("Installments:");
        for (Installment installment : obj.getInstallments()) {
            System.out.println(installment);
        }

        sc.close();
    }
}
