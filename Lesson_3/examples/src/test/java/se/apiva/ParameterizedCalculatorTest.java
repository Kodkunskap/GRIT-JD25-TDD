package se.apiva;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParameterizedCalculatorTest {

    @ParameterizedTest
    @ValueSource(ints = { 1, 3, 5, 99, 13, 123498231 })
    public void testIsOddWithOddNumbers(int number) {
        FastCalculator fastCalculator = new FastCalculator();

        var result = fastCalculator.isOdd(number);

        assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(ints = { 0, 2, 4, 98, 14, 123371230})
    public void testIsOddWithEvenNumbers(int number) {
        FastCalculator fastCalculator = new FastCalculator();

        var result = fastCalculator.isOdd(number);

        assertFalse(result);
    }

    @ParameterizedTest
    @ValueSource(classes = { FastCalculator.class, SafeCalculator.class })
    @NullSource
    public void testIsEvenWithOddNumbers(Class className) {
        Calculator calc = className == FastCalculator.class ? new FastCalculator() : new SafeCalculator();

        var result = calc.isOdd(3);

        assertTrue(result);
    }

}
