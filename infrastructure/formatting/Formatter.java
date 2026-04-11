package infrastructure.formatting;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.text.NumberFormat;
import java.util.Locale;

public class Formatter {
  private Formatter() {}

  private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
  private static final NumberFormat MONEY_FORMATTER = NumberFormat.getNumberInstance(Locale.forLanguageTag("pt-BR"));

  static {
    MONEY_FORMATTER.setMinimumFractionDigits(2);
    MONEY_FORMATTER.setMaximumFractionDigits(2);
  }

  public static String formatDate(LocalDate date) {
    if (date == null) {
      throw new IllegalArgumentException("A data não pode ser nula");
    }
    return date.format(DATE_FORMATTER);
  }
}
