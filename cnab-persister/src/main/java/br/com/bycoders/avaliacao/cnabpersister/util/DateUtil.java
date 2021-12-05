package br.com.bycoders.avaliacao.cnabpersister.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    private DateUtil() {
    }

    public static LocalDateTime stringToDate(String date, String time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        return LocalDateTime.parse(date+time, formatter);
    }
}
