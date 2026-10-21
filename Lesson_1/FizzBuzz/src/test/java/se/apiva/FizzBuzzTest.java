package se.apiva;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {

    private final int FIZZ_MULTIPLIER = 3;
    private final int BUZZ_MULTIPLIER = 5;

    // 1. Write a “fizzBuzz” method that accepts a number as input and returns
    // it as a String.
    @Test
    @DisplayName("Accepts a number and returns it as a string")
    public void returnNumberAsString() {
        FizzBuzz fzbz = new FizzBuzz();

        String result = fzbz.fizzBuzz(1);

        assertEquals("1", result);
    }

    // 2. For multiples of three return “Fizz” instead of the number
    @Test
    @DisplayName("For multiples of three return Fizz")
    public void returnFizzForMultipleOfThree() {
        FizzBuzz fzbz = new FizzBuzz();

        String result = fzbz.fizzBuzz(FIZZ_MULTIPLIER);

        assertEquals("Fizz", result);
    }

    // 3. For the multiples of five return “Buzz”
    @Test
    @DisplayName("For multiples of five return Buzz")
    public void returnBuzzForMultipleOfFive() {
        FizzBuzz fzbz = new FizzBuzz();

        String result = fzbz.fizzBuzz(BUZZ_MULTIPLIER);

        assertEquals("Buzz", result);
    }

    // 4. For numbers that are multiples of both three and five
    // return “FizzBuzz”.
    @Test
    @DisplayName("For multiples of three and five return FizzBuzz")
    public void returnFizzBuzzForMultipleOfThreeAndFive() {
        FizzBuzz fzbz = new FizzBuzz();

        String result = fzbz.fizzBuzz(FIZZ_MULTIPLIER*BUZZ_MULTIPLIER);

        assertEquals("FizzBuzz", result);
    }

}
