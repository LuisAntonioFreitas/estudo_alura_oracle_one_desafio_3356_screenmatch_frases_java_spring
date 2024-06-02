package net.lanet.screenmatchfrases.utils;

import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Component
public class CurrentDateTimeUtils {

    public static LocalDateTime getNow() {
        LocalDateTime dateTime = LocalDateTime.now(ZoneId.of("UTC"));
        return dateTime;
    }

    public static String getNowGMTString() {
        // Get the current date and time in UTC
        Instant instant = Instant.now();

        // Set the time zone to GMT
        ZoneId zone = ZoneId.of("GMT");

        // Format the date and time as a string
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        String dateTime = instant.atZone(zone).format(formatter);

        return dateTime;
    }
}
