package se.apiva;

public class FizzBuzz {

    private final int FIZZ_MULTIPLIER = 3;
    private final int BUZZ_MULTIPLIER = 5;

    public String fizzBuzz(int fizzBuzzNumber) {

        if (fizzBuzzNumber % FIZZ_MULTIPLIER == 0 && fizzBuzzNumber % BUZZ_MULTIPLIER == 0) {
            return "FizzBuzz";
        }

        if (fizzBuzzNumber % FIZZ_MULTIPLIER == 0) {
            return "Fizz";
        }

        if (fizzBuzzNumber % BUZZ_MULTIPLIER == 0) {
            return "Buzz";
        }

        return Integer.toString(fizzBuzzNumber);
    }

}
