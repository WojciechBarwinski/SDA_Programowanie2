package pl.sda.intermediate.tdd;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {
    public static int adding(String text) {
        if (StringUtils.isBlank(text)) {
            return 0;
        }
        String[] split =null;
        if (text.startsWith("//")) {
            Pattern pattern = Pattern.compile("(//)(.+)(\n)(.+)");
            Matcher matcher = pattern.matcher(text);
            if (matcher.matches()) {
                String delimiter = matcher.group(2);
                String numbersInString = matcher.group(4);
                split = numbersInString.split(delimiter);
            }

        } else {
            split = text.split(",|\n");
        }
        List<Integer> numbers = new ArrayList<>();
        List<Integer> negativeNumbers = new ArrayList<>();
        for (String s : split) {
            int result = Integer.parseInt(s.trim());
            if (result < 0){
                negativeNumbers.add(result);
            }
            numbers.add(result);
        }
        if (!negativeNumbers.isEmpty()){
            throw new NegativeNumbersException(negativeNumbers);
        }
        return numbers.stream()
                .filter(x -> x<1000)
                .reduce(0, (a, b) -> a + b);
    }
}
