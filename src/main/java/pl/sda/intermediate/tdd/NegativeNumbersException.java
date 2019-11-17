package pl.sda.intermediate.tdd;

import java.util.List;
import java.util.stream.Collectors;

public class NegativeNumbersException extends RuntimeException{
    public NegativeNumbersException(List<Integer> negativeNumbers) {
        super(messageCreator(negativeNumbers));
    }

    private static String messageCreator(List<Integer> negativeNumbers) {
        String message = "Liczby ujemne niedozwolone: ";
        message = message + negativeNumbers.stream()
                .sorted()
                .map(e -> e.toString())
                .collect(Collectors.joining(", "));
        return message;
    }
}
