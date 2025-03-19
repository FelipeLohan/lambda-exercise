import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        List<Employee> emps = new ArrayList<>();

        emps.add(new Employee("Maria", "maria@gmail.com", 3200.0));
        emps.add(new Employee("Alex", "alex@gmail.com", 1900.0));
        emps.add(new Employee("Marco", "marco@gmail.com", 1700.0));
        emps.add(new Employee("Bob", "bob@gmail.com", 3500.0));
        emps.add(new Employee("Anna", "anna@gmail.com", 2800.0));

        List<String> filteredEmps = emps.stream()
                .filter(emp -> emp.getSalary() > 2000.0)
                .map(emp -> emp.getEmail())
                .sorted().collect(Collectors.toList());

        for(String emp : filteredEmps) {
            System.out.println(emp);
        }

        Double empSalarySum = emps.stream()
                .filter(emp -> emp.getName().charAt(0) == 'M')
                .map(emp -> emp.getSalary())
                .reduce(0.0, (x, y) -> x + y);

        System.out.println("Sum of salary from people whose name starts with 'M': " + String.format("%.2f", empSalarySum));
    }
}