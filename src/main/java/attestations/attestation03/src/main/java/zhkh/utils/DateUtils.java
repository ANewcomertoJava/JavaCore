package zhkh.utils;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public static String formatDate(LocalDate date) {
        return date != null ? date.format(formatter) : "N/A";
    }

    public static LocalDate parseDate(String dateString) {
        return LocalDate.parse(dateString, formatter);
    }
}
