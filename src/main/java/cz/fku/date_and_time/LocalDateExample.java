package cz.fku.date_and_time;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;

public class LocalDateExample {
    public static void main(String[] args) {

        LocalTime myTime = LocalTime.now();

//        LocalDate myDate = LocalDate.now();
//        myDate.with(TemporalAdjusters.lastDayOfMonth());
//        myDate = myDate.withMonth(13);
//        myDate = myDate.withDayOfMonth(10);


        System.out.println(myTime);
    }
}
