import application.EmployeeService;
import domain.Employee;
import infrastructure.bootstrap.DataProvider;

import java.util.List;

public class Main {

  public static void main(String[] args) {

    EmployeeService service = new EmployeeService();
    List<Employee> employees = DataProvider.createEmployees();

    service.removeByName(employees, "João");

  }
}