package domain;

import java.time.LocalDate;
import java.time.Period;

/**
 * Representa uma pessoa no sistema.
 *
 * Regras:
 * - Nome não pode ser vazio
 * - Data de nascimento não pode ser futura
 */
public class Person {

  private final String name;
  private final LocalDate birthDate;

  public Person(String name, LocalDate birthDate) {
    this.name = validarNome(name);
    this.birthDate = validarDataNascimento(birthDate);
  }

  public String getName() {
    return name;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public int getAge() {
    return Period.between(birthDate, LocalDate.now()).getYears();
  }

  private String validarNome(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new IllegalArgumentException("O nome não pode ser vazio");
    }
    return name.trim();
  }

  private LocalDate validarDataNascimento(LocalDate birthDate) {
    if (birthDate == null) {
      throw new IllegalArgumentException("A data de nascimento não pode ser nula");
    }

    if (birthDate.isAfter(LocalDate.now())) {
      throw new IllegalArgumentException("A data de nascimento não pode estar no futuro");
    }

    return birthDate;
  }

  @Override
  public String toString() {
    return "Person{name='" + name + "', birthDate=" + birthDate + "}";
  }
}