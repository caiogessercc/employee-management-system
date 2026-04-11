package infrastructure.formatting;

import java.time.format.DateTimeFormatter;

public class Formatter {
  private Formatter() {}

  private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
}
