import application.EmployeeService;
import domain.Employee;
import infrastructure.bootstrap.DataProvider;
import infrastructure.formatting.Formatter;

import java.util.List;
import java.math.BigDecimal;
import java.util.Map;
import java.time.Month;

public class Main {

  public static void main(String[] args) {

    EmployeeService service = new EmployeeService();
    List<Employee> employees = DataProvider.createEmployees();

    service.removeByName(employees, "João");

    System.out.println("LISTA DE FUNCIONÁRIOS:");
    printEmployees(employees);

    service.applySalaryIncrease(employees, new BigDecimal("0.10"));

    System.out.println("\nFUNCIONÁRIOS AGRUPADOS POR FUNÇÃO:");
    Map<String, List<Employee>> grouped = service.groupByRole(employees);
    grouped.forEach((role, list) -> {
      System.out.println("\nFunção: " + role);
      printEmployees(list);
    });

    System.out.println("\nANIVERSARIANTES (OUTUBRO E DEZEMBRO):");
    List<Employee> birthdays = service.filterByBirthMonth(
        employees,
        Month.OCTOBER,
        Month.DECEMBER);
    printEmployees(birthdays);

    System.out.println("\nFUNCIONÁRIO MAIS VELHO:");
    Employee oldest = service.findOldest(employees);
    System.out.println(oldest.getName() + " - " + oldest.getAge() + " anos");

    System.out.println("\nORDEM ALFABÉTICA:");
    List<Employee> sorted = service.sortByName(employees);
    printEmployees(sorted);

    System.out.println("\nTOTAL DOS SALÁRIOS:");
    BigDecimal total = service.calculateTotalSalary(employees);
    System.out.println(Formatter.formatMoney(total));
  }

  private static void printEmployees(List<Employee> employees) {
    employees.forEach(Main::printEmployee);
  }

  private static void printEmployee(Employee e) {
    System.out.printf(
        "%s | %s | %s | %s%n",
        e.getName(),
        Formatter.formatDate(e.getBirthDate()),
        Formatter.formatMoney(e.getSalary()),
        e.getRole());
  }
}