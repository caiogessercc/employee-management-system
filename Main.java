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

    Map<String, List<Employee>> grouped = service.groupByRole(employees);
    System.out.println("\nFUNCIONÁRIOS AGRUPADOS POR FUNÇÃO:");
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

    Employee oldest = service.findOldest(employees);
    System.out.println("\nFUNCIONÁRIO MAIS VELHO:");
    System.out.println(oldest.getName() + " - " + oldest.getAge() + " anos");
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