package se.apiva;


public class FastCalculator implements Calculator {

    @Override
    public boolean isOdd(int number) {
        return number % 2 != 0;
    }

    @Override
    public int add(int a, int b) {
        return a + b;
    }
}
