package domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.math.RoundingMode;

/**
 * Representa um funcionário do sistema.
 *
 * Herda de Person e adiciona:
 * - Salário
 * - Função (cargo)
 *
 * Regras:
 * - Salário não pode ser negativo
 * - Função não pode ser vazia
 */
public class Employee extends Person {

  private BigDecimal salary;
  private String role;

  public Employee(String name, LocalDate birthDate, BigDecimal salary, String role) {
    super(name, birthDate);
    this.salary = validarSalario(salary);
    this.role = validarRole(role);
  }

  public BigDecimal getSalary() {
    return salary;
  }

  public String getRole() {
    return role;
  }

  /**
   * Aplica aumento percentual ao salário
   *
   * Exemplo:
   * 10% → passar 0.10
   */
  public void applySalaryIncrease(BigDecimal percentage) {
    if (percentage == null) {
      throw new IllegalArgumentException("O percentual não pode ser nulo");
    }

    if (percentage.compareTo(BigDecimal.ZERO) < 0) {
      throw new IllegalArgumentException("O percentual não pode ser negativo");
    }

    BigDecimal increase = salary.multiply(percentage);
    salary = salary.add(increase).setScale(2, RoundingMode.HALF_UP);
  }

  private BigDecimal validarSalario(BigDecimal salary) {
    if (salary == null) {
      throw new IllegalArgumentException("O salário não pode ser nulo");
    }

    if (salary.compareTo(BigDecimal.ZERO) < 0) {
      throw new IllegalArgumentException("O salário não pode ser negativo");
    }

    return salary.setScale(2, RoundingMode.HALF_UP);
  }

  private String validarRole(String role) {
    if (role == null || role.isBlank()) {
      throw new IllegalArgumentException("A função não pode ser vazia");
    }
    return role;
  }
}