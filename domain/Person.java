package domain;

import java.time.LocalDate;

public class Person {

  private String name;
  private LocalDate birthDate;

  public Person(String name, LocalDate birthDate) {
    this.name = validarNome(name);
    this.birthDate = validarData(birthDate);
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