package cl.accenture.backday.hexagonal.domain.exceptions;

import org.springframework.validation.BindingResult;

/** DataException */
public class DataException extends RuntimeException {

  public static final long serialVersionUID = 700L;

  private final transient BindingResult result;

  /**
   * @param result
   */
  public DataException(BindingResult result) {
    super();
    this.result = result;
  }

  /**
   * @param message
   * @param result
   */
  public DataException(String message, BindingResult result) {
    super(message);
    this.result = result;
  }

  /**
   * @param message
   */
  public DataException(String message) {
    super(message);
    this.result = getResult();
  }

  /**
   * @return
   */
  public BindingResult getResult() {
    return result;
  }
}
