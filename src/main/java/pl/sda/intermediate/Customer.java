package pl.sda.intermediate;

import java.math.BigDecimal;

public class Customer {
    Integer id;
    String firstName;
    String lastName;
    Integer age;
    BigDecimal salary;

    static Integer counter = 1;

    {
        this.id = counter++;
    }
    public Customer(String firstName, String lastName, Integer age, String salary) {

        this(firstName, lastName, age, Double.parseDouble(salary));
    }
    public Customer(String firstName, String lastName, Integer age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = BigDecimal.valueOf(salary);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
