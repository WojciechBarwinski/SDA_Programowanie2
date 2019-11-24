package pl.sda.intermediate.proteins;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ProteinsChecker {

    String proteins = "BDDFPQPPRRAGGHPOPDKJKPEQAAER\n" +
            "BDDFPQPFRRAGGHPOPDKJKPEQAAER\n" +
            "BDDFPQPFRRAGCHPOPDKJKPEQAAER\n" +
            "BDDFPQPFRRAGGHPOPDKJKPEQAAER\n" +
            "BDDFPOPFRRAGCHPOPDKJKPEQAAER\n" +
            "BDDFPOPFRRAGCHPOPDKJKPEQAAER\n" +
            "AABBCC\n" +
            "ACBBCA\n" +
            "BCBACA\n" +
            "ACBBCA\n" +
            "AABBCC\n" +
            "BCBACA\n" +
            "BCBACA\n" +
            "AABBCCC\n" +
            "AABBCC\n" +
            "AABBCC\n" +
            "ABBBCC\n" +
            "AABCCC\n" +
            "ABCAC\n" +
            "CACBA\n" +
            "AAAAAAAAAAAAAAAAAAAAB\n" +
            "AAAAAAAAAAAAAAAAAAAAA\n" +
            "QOOOOOOOOOOOOOOOOOOOO\n" +
            "OOOOOOOOOOOOOOOOOOOOQ";

    @Test
    void oneThread() {
        String[] split = proteins.split("\n");
        for (int i = 0; i < split.length - 1; i += 2) {
            System.out.println(changePossible(split[i], split[i + 1]));
        }
    }

    private boolean changePossible(String p1, String p2) {
        if (p1.length() != p2.length()) {
            return false;
        }
        if (p1.equals(p2)) {
            return true;
        }

        char[] split1 = p1.toCharArray();
        char[] split2 = p2.toCharArray();
        Arrays.sort(split1);
        Arrays.sort(split2);
        return Arrays.equals(split1, split2);
    }



}
