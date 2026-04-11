package application;

import domain.Employee;

import java.util.List;

public class EmployeeService {

  public void removeByName(List<Employee> employees, String name) {
    employees.removeIf(e -> e.getName().equalsIgnoreCase(name));
  }
}
