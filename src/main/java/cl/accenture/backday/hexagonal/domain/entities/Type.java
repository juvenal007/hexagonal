package cl.accenture.backday.hexagonal.domain.entities;

import cl.accenture.backday.hexagonal.domain.dto.TypeDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "TYPE")
public class Type {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TYPE_ID_SEQUENCE")
  @SequenceGenerator(sequenceName = "TYPE_ID_SEQUENCE", name = "TYPE_ID_SEQUENCE", allocationSize = 1)
  @Column(name = "ID")
  private int id;

  private String name;

  public Type(TypeDto typeDTO){
    this.id = typeDTO.getId();
    this.name = typeDTO.getName();
  }

}
