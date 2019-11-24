package pl.sda.intermediate;

import com.sun.org.apache.xpath.internal.compiler.FunctionTable;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class LambdasExample {

    private List<String> animals = Arrays.asList("pig", "dog", " hamster", "parrot", "rabbit", "duck", "   ", null);

    @Test
    void lambdasOne() {

        Comparator<String> secondLetterComparator =
                Comparator.comparing(a -> String.valueOf(a.charAt(1)));
        Comparator<String> thirdLetterComparator =
                Comparator.comparing(a -> String.valueOf(a.charAt(2)));

        Function<String, String> justTrim = e -> e.trim();

        animals.stream()
                .filter(Objects::nonNull)
                .filter(StringUtils::isNotBlank)
                .map(justTrim)
                .sorted(secondLetterComparator.thenComparing(thirdLetterComparator))
                .forEach(System.out::println);

    }

    Function<String, Integer> changeStringToNumber = (a) -> Integer.valueOf(a);

    @FunctionalInterface
    private interface SuperCalculator<F,S,R>{
        R calculate(F first, S second);
    }

    @Test
    void calculate() {
        SuperCalculator<String, Integer, Double> adder = (a, b) -> Double.valueOf(Integer.valueOf(a) + b);
        SuperCalculator<String, Long,Double> multiplier = (a, b) -> Double.valueOf(Integer.valueOf(a) * b.intValue());

        System.out.println(adder.calculate("23", 2));


        System.out.println(calculateSomehow("1", 2, adder));
    }

    private <F, S, R> R calculateSomehow(F a, S b, SuperCalculator<F, S, R> calculator) {
        return calculator.calculate(a, b);
    }

}
