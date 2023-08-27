package org.example.dsa;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class CustomDateFormatDemo {
    public static void main(String[] args) {

        System.out.println(formatDateTime(new Date(Instant.now().plusSeconds(1*60).toEpochMilli()),"yyyy-MM-dd HH:mm:ss"));

    }
    public static String formatDateTime(Date date, String format){
        if(date == null){
            return null;
        }
        try{
            return new SimpleDateFormat(format).format(date);
        }catch(Exception ex){
            return null;
        }
    }
}
