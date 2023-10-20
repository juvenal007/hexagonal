package cl.accenture.backday.hexagonal.domain.exceptions;

import org.springframework.validation.BindingResult;

/** LegalAgeException */
public class LegalAgeException extends RuntimeException {

  public static final long serialVersionUID = 700L;

  private final transient BindingResult result;

  /**
   * @param result
   */
  public LegalAgeException(BindingResult result) {
    super();
    this.result = result;
  }

  /**
   * @param message
   * @param result
   */
  public LegalAgeException(String message, BindingResult result) {
    super(message);
    this.result = result;
  }

  /**
   * @param message
   */
  public LegalAgeException(String message) {
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
