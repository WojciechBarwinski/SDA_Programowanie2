package pl.sda.intermediate.tdd;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public static int adding(String text) {
        if (StringUtils.isBlank(text)) {
            return 0;
        }
        String[] split;
        if (text.startsWith("//")) {
            char delimiter = text.charAt(2);
            String[] splitUsingNewLine = text.split("\n");
            split = splitUsingNewLine[1].split(String.valueOf(delimiter));

        } else {
            split = text.split(",|\n");
        }
        List<Integer> numbers = new ArrayList<>();
        for (String s : split) {
            int result = Integer.parseInt(s.trim());
            numbers.add(result);
        }

        return numbers.stream()
                .reduce(0, (a, b) -> a + b);
    }
}
