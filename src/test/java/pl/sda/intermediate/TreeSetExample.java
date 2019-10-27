package pl.sda.intermediate;

import org.junit.jupiter.api.Test;
import pl.sda.intermediate.customers.Customer;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {
    @Test
    void ts() {
        Set<String> objects = new TreeSet<>();
        objects.add("v");
        objects.add("a");
        System.out.println(objects);


        Comparator<Customer> customerComparator = (x, y) -> y.getFirstName().compareTo(x.getFirstName());
        Set<Customer> customers = new TreeSet<>(customerComparator);
        Customer c1 = new Customer();
        c1.setFirstName("Ania");
        customers.add(c1);
        Customer c2 = new Customer();
        c2.setFirstName("Beata");
        customers.add(c2);
        System.out.println(customers);
    }
}
