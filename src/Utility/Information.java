package Utility;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
public class Information {
    public static String now() {
        Locale locale = Locale.forLanguageTag("id");
        String pattern = "dd-MMMM-yyyy";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, locale);
        LocalDateTime dateTime = LocalDateTime.now();
        return dateTime.format(formatter);
    }
}
