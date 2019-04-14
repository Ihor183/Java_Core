package ua.igorbendera.date;

import java.time.*;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Date date =  new Date();
        System.out.println("Date - " + date);
        Instant instant = date.toInstant();

        dateToLocalDate(instant);
        dateToLocalTime(instant);
        dateToLocalDateTime(instant);
    }

    static void dateToLocalDate(Instant instant) {
        LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println("Local date - " + localDate);
    }

    static void dateToLocalTime(Instant instant) {
        LocalTime localTime = instant.atZone(ZoneId.systemDefault()).toLocalTime();
        System.out.println("Local time - " + localTime);
    }

    static void dateToLocalDateTime(Instant instant) {
        LocalDateTime localDateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println("Local date and time - " + localDateTime);
    }
}
