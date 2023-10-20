package cl.accenture.backday.hexagonal.domain.exceptions;

import org.springframework.validation.BindingResult;

/** UserExistException */
public class UserExistException extends RuntimeException {

  public static final long serialVersionUID = 700L;

  private final transient BindingResult result;

  /**
   * @param result
   */
  public UserExistException(BindingResult result) {
    super();
    this.result = result;
  }

  /**
   * @param message
   * @param result
   */
  public UserExistException(String message, BindingResult result) {
    super(message);
    this.result = result;
  }

  /**
   * @param message
   */
  public UserExistException(String message) {
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
