package pl.sda.intermediate.customers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.sda.intermediate.customers.Customer;
import pl.sda.intermediate.customers.CustomerStatistics;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

class CustomerStatisticsTest {
    @Test
    void shouldGiveProperSalaryCustomersMap() {
        Map<BigDecimal, List<Customer>> salaryCustomerMap = CustomerStatistics.giveSalaryCustomerMap();

        List<Customer> customers = salaryCustomerMap.get(BigDecimal.valueOf(3333.0));

        Assertions.assertEquals(2, customers.size());

    }
}