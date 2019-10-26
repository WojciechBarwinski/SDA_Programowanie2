package pl.sda.intermediate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CustomerStatisticsTest {
    @Test
    void shouldGiveProperSalaryCustomersMap() {
        Map<BigDecimal, List<Customer>> salaryCustomerMap = CustomerStatistics.giveSalaryCustomerMap();

        List<Customer> customers = salaryCustomerMap.get(BigDecimal.valueOf(3333.0));

        Assertions.assertEquals(2, customers.size());

    }
}