package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import exceptions.DomainException;

public class Reservation {

    private Integer roomNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;

    private static DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Reservation() {
    }

    // inserindo o tratamento de exceção no construtor,
    // para que a data de checkOut não entre como
    // data anterior ao checkIn; a assinatura do método
    // passa a propagar, com o recurso 'throws',
    // a classe personalizada:
   public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) throws DomainException {
        if (!checkOut.isAfter(checkIn)) {
            throw new DomainException("Error in reservation: Check-out date must be after check-in date.");
        }
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    // usando 'ChronoUnit', em vez de 'Duration',
    // para poder armazenar as datas como 'long':
    public long duration() {
        return ChronoUnit.DAYS.between(checkIn, checkOut);
    }

    // o método 'updateDates' retorna, na sua assinatura
    // ao modo 'void' original, sendo agora auxiliado por
    // 'throw' e pela exceção personalizada
    // 'model.exceptions.DomainException',
    // a fim de retornar mensagem de erro, caso necessário;
    // a assinatura do método, então, passa a propagar,
    // com o recurso 'throws', a classe personalizada:
    public void updateDates(LocalDate checkIn, LocalDate checkOut) throws DomainException {
        LocalDate now = LocalDate.now();
        if (checkIn.isBefore(now) || checkOut.isBefore(now)) {
            // instanciando a exceção personalizada
            // 'model.exceptions.DomainException':
            throw new DomainException("Error in reservation: Reservation dates for update must be future dates.");
        }
        if (!checkOut.isAfter(checkIn)) {
            throw new DomainException("Error in reservation: Check-out date must be after check-in date.");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Room: "
            + getRoomNumber()
            + ", check-in: "
            + fmt1.format(getCheckIn())
            + ", check-out: "
            + fmt1.format(getCheckOut())
            + ", "
            + duration()
            + " nights.";
    }

}
