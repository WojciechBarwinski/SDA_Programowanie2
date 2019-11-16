package pl.sda.intermediate;

import org.junit.jupiter.api.Test;

public class FibonacciExample {

    @Test
    void recursive() {
        System.out.println(fibonacciRecursive(6));
    }

    private int fibonacciRecursive(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
}
