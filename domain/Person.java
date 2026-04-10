package domain;

import java.time.LocalDate;
import java.time.Period;

public class Person {

  private String name;
  private LocalDate birthDate;

  public Person(String name, LocalDate birthDate) {
    this.name = validarNome(name);
    this.birthDate = validarData(birthDate);
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
    if (name == null || name.isBlank()) {
      throw new IllegalArgumentException("O nome não pode ser vazio");
    }
    return name;
  }

  private LocalDate validarData(LocalDate birthDate) {
    if (birthDate == null) {
      throw new IllegalArgumentException("A data de nascimento não pode ser nula");
    }

    if (birthDate.isAfter(LocalDate.now())) {
      throw new IllegalArgumentException("A data de nascimento não pode estar no futuro");
    }

    return birthDate;
  }
}