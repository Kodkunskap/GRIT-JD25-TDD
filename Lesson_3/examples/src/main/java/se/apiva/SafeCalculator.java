package se.apiva;

public class SafeCalculator implements Calculator {

    @Override
    public boolean isOdd(int number) {
        return number % 2 != 0;
    }

    @Override
    public int add(int a, int b) {
        return Math.addExact(a, b);
    }
}
