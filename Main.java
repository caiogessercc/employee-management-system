import application.EmployeeService;
import domain.Employee;
import infrastructure.bootstrap.DataProvider;
import infrastructure.formatting.Formatter;

import java.util.List;

public class Main {

  public static void main(String[] args) {

    EmployeeService service = new EmployeeService();
    List<Employee> employees = DataProvider.createEmployees();

    service.removeByName(employees, "João");

    System.out.println("LISTA DE FUNCIONÁRIOS:");
    printEmployees(employees);
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