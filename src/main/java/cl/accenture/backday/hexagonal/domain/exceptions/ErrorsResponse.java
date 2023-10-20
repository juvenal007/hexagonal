package cl.accenture.backday.hexagonal.domain.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * ErrorsResponse
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorsResponse {


  private String status;
  private String title;
  private String detail;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Source source;

  /**
   * Source
   */
  @Getter
  @Setter
  @NoArgsConstructor
  @ToString
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Source implements Serializable {

    private String pointer;
  }

}
