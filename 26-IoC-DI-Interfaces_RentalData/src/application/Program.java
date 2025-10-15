package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import entities.CarRental;
import entities.Vehicle;
import services.BrazilTaxService;
import services.RentalService;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner((System.in));
        // instanciação da formatação data/hora:
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Enter rental data:");
        System.out.print("Car model: ");
        String carModel = sc.nextLine();
        System.out.print("Start (DD/MM/YYYY HH:MM): ");
        LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);
        System.out.print("Finish (DD/MM/YYYY HH:MM): ");
        LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt);

        // como na classe 'CarRental' o 'Vehicle' é uma associação
        // feita através de uma instanciação dessa classe no objeto
        // 'vehicle', para passá-la como um parâmetro do tipo (classe)
        // 'String', ela precisa ser instanciada com 'new', numa
        // sintaxe em cujo parêntese é passada a variável 'String' 'model':
        CarRental cr = new CarRental(start, finish, new Vehicle(carModel));

        System.out.print("Enter price per hour: $");
        double pricePerHour = sc.nextDouble();
        System.out.print("Enter price per day: $");
        double pricePerDay = sc.nextDouble();

        // INJEÇÃO DE DEPENDÊNCIA: incluindo uma instância de objeto
        // TaxService específico, conforme previsto pelo construtor da
        // classe 'RentalService' com a interface:
        RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());

        rentalService.processInvoice(cr);

        System.out.println("INVOICE:");
        System.out.println("Basic payment: $" + String.format("%.2f", cr.getInvoice().getBasicPayment()));
        System.out.println("Tax: $" + String.format("%.2f", cr.getInvoice().getTax()));
        System.out.println("Total payment: $" + String.format("%.2f", cr.getInvoice().getTotalPayment()));

        sc.close();
    }
}
