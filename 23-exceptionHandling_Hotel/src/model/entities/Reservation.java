package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Reservation {

    private Integer roomNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;

    private static DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Reservation() {
    }

    public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) {
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

    public long duration() {
        return ChronoUnit.DAYS.between(checkIn, checkOut);
    }

    // para tratar a excessão, o método 'updateDates' não
    // será 'void', mas retornará uma 'String' com a mensagem
    // de erro ou retornará nulo, caso tudo funcione adequadamente:
    public String updateDates(LocalDate checkIn, LocalDate checkOut)  {
        LocalDate now = LocalDate.now();
        if (checkIn.isBefore(now) || checkOut.isBefore(now)) {
            return "Error in reservation: Reservation dates for update must be future dates.";
        }
        if (!checkOut.isAfter(checkIn)) {
            return "Error in reservation: Check-out date must be after check-in date.";
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        // como o método retorna uma 'String', em vez de uma declaração
        // 'void', caso tudo funcione bem, faz-se necessária a
        // declaração de um retorno nulo:
        return null;
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
