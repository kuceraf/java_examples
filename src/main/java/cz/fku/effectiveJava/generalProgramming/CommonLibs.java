package cz.fku.effectiveJava.generalProgramming;

import java.util.Random;

public class CommonLibs {
    private static Random rnd = new Random();

    public static void main(String[] args) {
        int low = 0;
        int n = 5;
        for(int i=0; i < 1000000 ;i++) {
            int randomNum = random(n);
            if(randomNum < Math.abs(n)/2) {
                low ++;
            }
            System.out.println(randomNum);
        }
        System.out.println("low: " + low);
    }

    private static int random(int n) {
        return Math.abs(rnd.nextInt()) % n;
    }
}
