package infrastructure.formatting;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.text.NumberFormat;
import java.util.Locale;
import java.math.BigDecimal;

public final class Formatter {
  private Formatter() {}

  private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
  private static final NumberFormat MONEY_FORMATTER = NumberFormat.getNumberInstance(Locale.forLanguageTag("pt-BR"));

  static {
    MONEY_FORMATTER.setMinimumFractionDigits(2);
    MONEY_FORMATTER.setMaximumFractionDigits(2);
  }

  /**
   * Formata uma data no padrão brasileiro (dd/MM/yyyy)
   */
  public static String formatDate(LocalDate date) {
    if (date == null) {
      throw new IllegalArgumentException("A data não pode ser nula");
    }
    return date.format(DATE_FORMATTER);
  }

  /**
   * Formata um valor monetário no padrão brasileiro
   * Exemplo: 1234.56 -> 1.234,56
   */
  public static String formatMoney(BigDecimal value) {
    if (value == null) {
      throw new IllegalArgumentException("O valor não pode ser nulo");
    }
    return MONEY_FORMATTER.format(value);
  }
}
