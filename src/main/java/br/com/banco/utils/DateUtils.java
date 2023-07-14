package br.com.banco.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtils {

    public static LocalDateTime strToLocalDateTime(String str){
        System.out.println(str);
        if(str.matches("^\\d{2}-\\d{2}-\\d{4}$"))
            str=str.concat(" 00:00:00");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
        return dateTime;
    }

    public static String convertSystemTimeMillisToString(Long systemMillis){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date resultDate = new Date(systemMillis);
        return sdf.format(resultDate);
    }
}

