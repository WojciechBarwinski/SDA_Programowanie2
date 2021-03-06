package pl.sda.intermediate.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    @Test
    void shouldReturnZeroWhenTextIsEmpty() {
        String text = "";
        int result = StringCalculator.adding(text);
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldReturnZeroWhenTextIsNull() {
        String text = null;
        int result = StringCalculator.adding(text);
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldReturnSumWhenTextIsOneNumber() {
        String text = "1";
        int result = StringCalculator.adding(text);
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldReturnZeroWhenTextIsBlank() {
        String text = " ";
        int result = StringCalculator.adding(text);
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldReturnSumWhenTextHasTwoNumbersWithDelimiter() {
        String text = "2, 3";
        int result = StringCalculator.adding(text);
        Assertions.assertEquals(5, result);
    }

    @Test
    void shouldReturnSumWhenTextHasManyNumbersWithDelimiter() {
        String text = "2, 3, 5, 4";
        int result = StringCalculator.adding(text);
        Assertions.assertEquals(14, result);
    }

    @Test
    void shouldReturnSumWhenTextHasManyNumbersWithTwoTypesDelimiter() {
        String text = "2, 3, 5 \n 4";
        int result = StringCalculator.adding(text);
        Assertions.assertEquals(14, result);
    }

    @Test
    void shouldReturnSumWhenTextHasCustomDelimiter() {
        String text = "//x\n2x 3 x5 x 4";
        int result = StringCalculator.adding(text);
        Assertions.assertEquals(14, result);
    }

    @Test
    void shouldThrowExceptionWhenNegativeNumbersArePassed() {
        String text = "//x\n2x -3 x5 x -4 x -4";

        NegativeNumbersException exception = Assertions.assertThrows(
                NegativeNumbersException.class,
                () -> StringCalculator.adding(text));// LAZY
        Assertions.assertEquals("Liczby ujemne niedozwolone: -4, -4, -3",
                                exception.getMessage());
    }

    @Test
    void shouldReturnSumIgnoringNumbersBiggerThanThousand() {
        String text = "//x\n2x 3 x5 x 4 x1002";
        int result = StringCalculator.adding(text);
        Assertions.assertEquals(14, result);
    }

    @Test
    void shouldReturnSumWhenTextHasLongCustomDelimiter() {
        String text = "//xxx\n2xxx 3 xxx5 xxx 4 xxx1002";
        int result = StringCalculator.adding(text);
        Assertions.assertEquals(14, result);
    }
}
