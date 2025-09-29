package application;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Room number: ");
        int number = sc.nextInt();
        sc.nextLine();
        System.out.print("Check-in date (DD/MM/YYYY): ");
        LocalDate checkIn = LocalDate.parse(sc.next(), fmt1);
        System.out.print("Check-out date (DD/MM/YYYY): ");
        LocalDate checkOut = LocalDate.parse(sc.next(), fmt1);

        // bad solution - usando 'if-else' para tratar erros
        // na classe 'model.entities.Reservation':
        if (!checkOut.isAfter(checkIn)) {
            System.out.println("Error in reservation: Check-out date must be after check-in date.");
        }
        else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: \n" + reservation);
            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in date (DD/MM/YYYY): ");
            checkIn = LocalDate.parse(sc.next(), fmt1);
            System.out.print("Check-out date (DD/MM/YYYY): ");
            checkOut = LocalDate.parse(sc.next(), fmt1);

            // uma variável error é criada para retornar a
            // 'String' do método 'updateDates' que, caso seja
            // nula, a reserva é concluída, porque tudo
            // transcorreu como esperado:
            String error = reservation.updateDates(checkIn, checkOut);
            if (error != null) {
                System.out.println("Error in reservation: " + error);
            }
            else {
            System.out.println("Reservation: \n" + reservation);
            }
        }
        sc.close();
    }
}
