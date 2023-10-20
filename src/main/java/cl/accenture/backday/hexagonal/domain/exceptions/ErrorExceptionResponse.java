package cl.accenture.backday.hexagonal.domain.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * ErrorExceptionResponse
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorExceptionResponse {

  @JsonProperty(value = "meta")
  private MetadataExceptionResponse metadataExceptionResponse;

  @JsonProperty(value = "errors")
  private List<ErrorsResponse> errorsResponse;

}
