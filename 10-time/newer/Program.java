import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Program {

    public static void main(String[] args) {

    // exibindo data local atual ISO-8601:
    LocalDate d01 = LocalDate.now();
    System.out.println("d01: " + d01);
    // note-se que todo objeto instanciado a partir das classes
    // 'java.time.', quando chamados no 'println', comportam-se
    // pressupondo o método 'd01.toString()'.

    // exibindo data e hora local atuais ISO-8601:
    LocalDateTime d02 = LocalDateTime.now();
    System.out.println("d02: " + d02);

    // exibindo data e hora GMT:
    Instant d03 = Instant.now();
    System.out.println("d03: " + d03);

    // lendo data e hora GMT ISO-8601:
    LocalDateTime d04 = LocalDateTime.parse("2025-09-19T20:00:30");
    System.out.println("d04: " + d04);

    // lendo data e hora formatadas e convertendo em ISO-8601:
    // usa-se o 'DateTimeFormatter' https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
    DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    LocalDateTime d05 = LocalDateTime.parse("20/09/2025 20:00", fmt1);
    System.out.println("d05: " + d05);
    // ou:
    LocalDateTime d06 = LocalDateTime.parse("20/09/2025 20:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    System.out.println("d06: " + d06);

    // formatando data e hora locais ISO-8601:
    System.out.println("d07 (d02 formated): " + d02.format(fmt1));
    // ou:
    System.out.println("d08 (d02 formated): " + fmt1.format(d02));

    // formatando e convertendo data e hora GMT ISO-8601
    // 'Instant.now' em fuso local:
    DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());
    System.out.println("d09 (d03 local formated): " + fmt2.format(d03));

    // convertendo horário GMT em fuso local:
    LocalDateTime r1 = LocalDateTime.ofInstant(d03, ZoneId.systemDefault());
    System.out.println("d10 (d03 local): " + r1);

    // convertendo horário GMT para outro fuso:
    LocalDateTime r2 = LocalDateTime.ofInstant(d03, ZoneId.of("Europe/Lisbon"));
    System.out.println("d11 (d03 other fuse): " + r2);

    // quebra de linha:
    System.out.println();

    // dia do ano:
    System.out.println("d03 day of year: " + d04.getDayOfYear());
    // dia da semana:
    System.out.println("d03 day of week: " + d04.getDayOfWeek());
    // mês:
    System.out.println("d03 month: " + d04.getMonth());
    // ano:
    System.out.println("d03 year: " + d04.getYear());

    // quebra de linha:
    System.out.println();

    // operações com a data:
    LocalDate pastWeekLocalDate = d01.minusDays(7);
    System.out.println("Past Week Local: " + pastWeekLocalDate);
    LocalDate nextWeeksSeven = d01.plusWeeks(7);
    System.out.println("Next 7 weeks Local: " + nextWeeksSeven);
    Instant nextWeekInstant = d03.plus(7, ChronoUnit.DAYS);
    System.out.println("Next Week from Instant: " + nextWeekInstant);

    // quebra de linha:
    System.out.println();

    // contagem de tempo com 'Duration':
    System.out.println("Days counting:");
    LocalDateTime d20 = LocalDateTime.parse("2025-08-10T12:00:00");
    LocalDateTime d21 = LocalDateTime.now();
    Duration t1 = Duration.between(d20, d21);
    System.out.println("Duration of days from 10/08/2025 to now: " + t1.toDays());

	// contagem de tempo usando 'ChronoUnit', usando o tipo 'long';
	// o tipo 'ChronoUnit' possui diversas constantes enumeradas,
	// feito CENTURES, DAYS, DECADES, ERAS, HALF_DAYS etc. (ver documentação Oracle):
    long daysBetween = ChronoUnit.HOURS.between(d21, nextWeeksSeven.atTime(0, 0));
    System.out.println("Duration of time from now to more 7 weeks: " + daysBetween + "H");

    }
}
