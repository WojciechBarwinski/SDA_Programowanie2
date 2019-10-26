package pl.sda.intermediate;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class BigDecimaTest {

    @Test
    void name() {
        double a = 0.02;
        double b = 0.03;
        System.out.println(a-b);

        BigDecimal aa = new BigDecimal(0.02);
        BigDecimal bb = new BigDecimal(0.03);
        System.out.println(aa.subtract(bb));

        BigDecimal aaa = new BigDecimal("0.02");
        BigDecimal bbb = new BigDecimal("0.03");
        System.out.println(aaa.subtract(bbb));

        BigDecimal aaaa = BigDecimal.valueOf(0.02);
        BigDecimal bbbb = BigDecimal.valueOf(0.03);
        System.out.println(aaaa.subtract(bbbb));
    }
}
