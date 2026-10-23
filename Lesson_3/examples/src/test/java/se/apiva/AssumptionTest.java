package se.apiva;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class AssumptionTest {

    @Test
    public void onlyRunOnMacOSX() {
        assumeTrue(
                System.getProperty("os.name").toLowerCase().contains("mac"),
                "Test should only be run on macOSX"
        );

        assertEquals(2, 1 + 1);
    }

    @Test
    public void onlyRunOnWindows() {
        assumeTrue(
                System.getProperty("os.name").toLowerCase().contains("windows"),
                "Test should only be run on windows"
        );

        assertEquals(2, 1 + 1);
    }

}
