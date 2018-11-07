package cz.fku.effectiveJava.generalProgramming;

import cz.fku.effectiveJava.enumeration.PayrollDay;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;


public class EnumMapExample {
    public enum DayOfWeek {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY;
    }


    public static void main(String[] args) {
        Map<DayOfWeek, String> enumMap = new EnumMap<>(DayOfWeek.class);
        Map<DayOfWeek, String> hashMap = new HashMap<>();

        enumMap.put(DayOfWeek.FRIDAY, "patek");
        hashMap.put(DayOfWeek.FRIDAY, "patek");
    }
}
