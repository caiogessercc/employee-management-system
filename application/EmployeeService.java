package application;

import domain.Employee;

import java.math.BigDecimal;
import java.util.List;
import java.util.Comparator;

public class EmployeeService {

  public void removeByName(List<Employee> employees, String name) {
    employees.removeIf(e -> e.getName().equalsIgnoreCase(name));
  }

  public void applySalaryIncrease(List<Employee> employees, BigDecimal percentage) {
    employees.forEach(e -> e.applySalaryIncrease(percentage));
  }

  public List<Employee> sortByName(List<Employee> employees) {
    return employees.stream()
        .sorted(Comparator.comparing(Employee::getName))
        .toList();
  }

  public BigDecimal calculateTotalSalary(List<Employee> employees) {
    BigDecimal total = BigDecimal.ZERO;
  
    for (Employee e : employees) {
      total = total.add(e.getSalary());
    }
  
    return total;
  }
}
