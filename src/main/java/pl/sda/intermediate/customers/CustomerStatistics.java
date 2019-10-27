package pl.sda.intermediate.customers;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class CustomerStatistics {

    static Customer[] people = new Customer[]{
            new Customer("Anna", "Nowak   ", 33, "1200"),
            new Customer("Beata", "Kowalska", 22, "1200"),
            new Customer("Marek", " Nowak", 25, "1250 "),
            new Customer("Adam", "Twardowski", 33, "4100 "),
            new Customer("Monika  ", "Kos", 25, "2500"),
            new Customer("Adam ", "Rudy", 45, "3333"),
            new Customer("Marek", "Rudy", 15, 2210),
            new Customer("Adam", "Madej", 15, 3333),
            new Customer("Adam", "Nowak ", 15, null)
    };

    public static List<Customer> giveList() {
        return Arrays.stream(people).collect(Collectors.<Customer>toList());
    }

//    2. Napisz metodę, która przyjmie tablicę people i zwróci
//    listę Stringów <imię nazwisko> (elementem listy będzie np "Anna Nowak")

    public static List<String> giveFirstLastNameList() {
        List<String> resultList = new ArrayList<>();
        for (Customer person : people) {
            String name = person.getFirstName() + " " + person.getLastName();
            resultList.add(name);
        }
        return resultList;
    }

    public static List<String> giveFirstLastNameListWithStream() {
        return giveList().stream()
                .map(x -> x.getFirstName() + " " + x.getLastName())
                .collect(Collectors.toList());
    }

    public static Map<Integer, Customer> giveIdCustomerMap() {
        Map<Integer, Customer> resultMap = new HashMap<>();
        for (Customer person : people) {
            resultMap.put(person.getId(), person);
        }
        return resultMap;
    }

    public static Map<Integer, Customer> giveIdCustomerMapWithStream() {
        return giveList().stream()
                .collect(Collectors.toMap(x -> x.getId(), x -> x));
    }

//    4. Napisz metodę, która zwróci mapę osób według zarobków
//        <zarobki,osoby_z_zarobkami>

    public static Map<BigDecimal, List<Customer>> giveSalaryCustomerMap() {
        Map<BigDecimal, List<Customer>> resultMap = new HashMap<>();
        for (Customer person : people) {
            if (resultMap.containsKey(person.getSalary())) {
                List<Customer> customersList = resultMap.get(person.getSalary());
                customersList.add(person);
            } else {
                List<Customer> customersList = new ArrayList<>();
                customersList.add(person);
                resultMap.put(person.getSalary(), customersList);
            }
        }
        return resultMap;
    }

    public static Map<BigDecimal, List<Customer>> giveSalaryCustomerMapWithStream() {
        return giveList().stream()
                .collect(Collectors.groupingBy(x -> x.getSalary()));
    }


//    7. Napisz metodę, która zwróci mapę
//        <imię,<suma_zarobków_osób_o_taki_imieniu>>

    public static Map<String, BigDecimal> giveNameAndSumSalaryMap() {
        Map<String, BigDecimal> resultMap = new HashMap<>();
        for (Customer person : people) {
            if (resultMap.containsKey(person.getFirstName())) {
                BigDecimal salarySum = resultMap.get(person.getFirstName());
                BigDecimal newSum = salarySum.add(person.getSalary());
                resultMap.put(person.getFirstName(), newSum);
            } else {

                resultMap.put(person.getFirstName(), person.getSalary());
            }
        }
        return resultMap;
    }

    public static Map<String, Optional<BigDecimal>> giveNameAndSumSalaryMapWithStream() {
        return giveList().stream()
                .collect(Collectors.groupingBy(x -> x.getFirstName(),
                        Collectors.mapping(e -> e.getSalary(),
                                Collectors.reducing((a, b) -> a.add(b)))));


    }
}
