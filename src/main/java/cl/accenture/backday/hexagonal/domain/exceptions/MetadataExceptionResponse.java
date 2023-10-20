package cl.accenture.backday.hexagonal.domain.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * MetadataExceptionResponse
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class MetadataExceptionResponse {

  @JsonProperty(value = "_version")
  private String _version;

  @JsonProperty(value = "_rqDateTime")
  private String _rqDateTime;

}
