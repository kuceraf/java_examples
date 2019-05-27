package cz.fku.concurrency.synchronization;

public class Statistic {
    private int number = 0;
    private int total = 0;
    public void increase(String thredName) {
        number++;
        total++;

        System.out.println("Increasing stats: " + thredName +" -- "+ number);
    }

    public void decrease() {
        number--;
    }

    public int getStatistic() {
        return number;
    }

    public int getTotal() {
        return total;
    }
}
