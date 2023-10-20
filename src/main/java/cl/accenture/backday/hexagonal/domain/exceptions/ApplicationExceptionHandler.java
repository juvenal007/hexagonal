package cl.accenture.backday.hexagonal.domain.exceptions;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/** ApplicationExceptionHandler */
@RestControllerAdvice
public class ApplicationExceptionHandler {

  @Value("${app.version}")
  String VERSION;

  /**
   * @param ex
   * @return error
   */
  @ExceptionHandler(Exception.class)
  protected ResponseEntity<ErrorExceptionResponse> handleException(Exception ex) {
    HttpStatus httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;

    ErrorExceptionResponse errorExceptionResponse =
        getException(ex, httpStatus, ex.getClass().getSimpleName());

    return new ResponseEntity<>(errorExceptionResponse, httpStatus);
  }

  /**
   * @param ex
   * @return error
   */
  @ExceptionHandler(DataException.class)
  protected ResponseEntity<ErrorExceptionResponse> dataException(Exception ex) {
    HttpStatus httpStatus = HttpStatus.SERVICE_UNAVAILABLE;

    ErrorExceptionResponse errorExceptionResponse = getException(ex, httpStatus, "Error interno.");

    return new ResponseEntity<>(errorExceptionResponse, httpStatus);
  }

  ErrorExceptionResponse getException(Exception ex, HttpStatus httpStatus, String Error) {
    List<ErrorsResponse> listErrorsResponse = new ArrayList<>();

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    Date date = new Date();

    MetadataExceptionResponse meta = new MetadataExceptionResponse();

    ErrorExceptionResponse errorExceptionResponse = new ErrorExceptionResponse();

    ErrorsResponse errorsResponse = new ErrorsResponse();

    errorsResponse.setStatus(String.valueOf(httpStatus.value()));
    errorsResponse.setTitle(Error);
    errorsResponse.setDetail(ex.getMessage());
    listErrorsResponse.add(errorsResponse);

    meta.set_version(VERSION);
    meta.set_rqDateTime(sdf.format(date));

    errorExceptionResponse.setMetadataExceptionResponse(meta);
    errorExceptionResponse.setErrorsResponse(listErrorsResponse);
    return errorExceptionResponse;
  }
}
