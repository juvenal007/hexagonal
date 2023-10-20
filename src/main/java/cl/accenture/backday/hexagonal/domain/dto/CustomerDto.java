package cl.accenture.backday.hexagonal.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerDto {

  private int id;

  private TypeDto type;

  private ContactDto contact;

  private String name;

  private int age;

}
