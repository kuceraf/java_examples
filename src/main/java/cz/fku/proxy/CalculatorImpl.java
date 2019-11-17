package cz.fku.proxy;

public class CalculatorImpl implements Calculator {
    @Override
    public int add(int left, int right) {
        return left + right;
    }
}
