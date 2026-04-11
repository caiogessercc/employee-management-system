package application;

import domain.Employee;

import java.math.BigDecimal;
import java.util.List;
import java.util.Comparator;
import java.time.Month;

/**
 * Responsável por operações sobre funcionários.
 *
 * Esta classe não contém regras de negócio profundas,
 * apenas orquestra chamadas ao domínio.
 */
public class EmployeeService {

  public void removeByName(List<Employee> employees, String name) {
    employees.removeIf(e -> e.getName().equalsIgnoreCase(name));
  }

  public void applySalaryIncrease(List<Employee> employees, BigDecimal percentage) {
    employees.forEach(e -> e.applySalaryIncrease(percentage));
  }

  // groupByRole

  public List<Employee> filterByBirthMonth(List<Employee> employees, Month... months) {
    return employees.stream()
        .filter(e -> {
          int mes = e.getBirthDate().getMonthValue();
          for (Month m : months) {
            if (m.getValue() == mes) {
              return true;
            }
          }
          return false;
        })
        .toList();
  }

  public Employee findOldest(List<Employee> employees) {
    return employees.stream()
        .min(Comparator.comparing(Employee::getBirthDate))
        .orElseThrow(() -> new IllegalStateException("Lista de funcionários está vazia"));
  }

  public List<Employee> sortByName(List<Employee> employees) {
    return employees.stream()
        .sorted(Comparator.comparing(Employee::getName))
        .toList();
  }

  public BigDecimal calculateTotalSalary(List<Employee> employees) {
    return employees.stream()
        .map(Employee::getSalary)
        .reduce(BigDecimal.ZERO, BigDecimal::add);
  }

  // calculateMinimumWages
}
