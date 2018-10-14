package cz.fku.effectiveJava.generalProgramming;

public class Loop {
    public static void main(String[] args) {
        // multiple variable declaration in tradidional for loop
        for(int i = 0, n = expensiveComputation(); i < n; i++, n--) {
            System.out.println("n:" + n + " i:" + i);
        }
    }

    static private int expensiveComputation() {
        return 30;
    }
}
