package org.aston;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Lesson12junit5Test {

    @DisplayName("Calculation and verification of the factorial of the transmitted number")
    @ParameterizedTest
    @CsvSource({"1, -1", "1, 0", "1, 1", "40320, 8", "479001600, 12"})
    void calculateCheckFactorialNumber(long expectedValue, long transmittedNum) {
        Assertions.assertEquals(expectedValue, Lesson12junit5.getFactorial(transmittedNum));
    }
}