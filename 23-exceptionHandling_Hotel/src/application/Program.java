package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // good solution - usando exceção personalizada e
        // a estrutura 'try-catch' para tratar as exceções;
        // o bloco principal do programa agora se encontra
        // no corpo do recurso 'try':
        try {
            System.out.print("Room number: ");
            int number = sc.nextInt();
            sc.nextLine();
            System.out.print("Check-in date (DD/MM/YYYY): ");
            LocalDate checkIn = LocalDate.parse(sc.next(), fmt1);
            System.out.print("Check-out date (DD/MM/YYYY): ");
            LocalDate checkOut = LocalDate.parse(sc.next(), fmt1);

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: \n" + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in date (DD/MM/YYYY): ");
            checkIn = LocalDate.parse(sc.next(), fmt1);
            System.out.print("Check-out date (DD/MM/YYYY): ");
            checkOut = LocalDate.parse(sc.next(), fmt1);

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: \n" + reservation);

        }
        // com 'catch', são tratadas as exceções possíveis;
        // chamando a exceção personalizada como argumento:
        catch (DomainException e) {
            System.out.println(e.getMessage());
        }
        // tratando exceções imprevistas:
        catch (RuntimeException e) {
            System.out.println("Unexpected error!");
        }

        sc.close();
    }
}
