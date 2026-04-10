package domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Employee extends Person {

  private BigDecimal salary;
  private String role;

  public Employee(String name, LocalDate birthDate, BigDecimal salary, String role) {
    super(name, birthDate);
    this.salary = validarSalario(salary);
    this.role = validarRole(role);
  }

  private BigDecimal validarSalario(BigDecimal salary) {
    if (salary == null || salary.compareTo(BigDecimal.ZERO) < 0) {
      throw new IllegalArgumentException("O salário não pode ser negativo");
    }
    return salary;
  }

  private String validarRole(String role) {
    if (role == null || role.isBlank()) {
      throw new IllegalArgumentException("A função não pode ser vazia");
    }
    return role;
  }
}