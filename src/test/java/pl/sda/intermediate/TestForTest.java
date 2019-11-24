package pl.sda.intermediate;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class TestForTest {
    @Test
    void name() {
        List integers = Arrays.asList(new Integer[]{1, 2, 3});
        List ints = Arrays.asList(new int[]{1, 2, 3});
        System.out.println(ints.size() == integers.size());

    }
}
