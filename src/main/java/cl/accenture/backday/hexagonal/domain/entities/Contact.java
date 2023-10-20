package cl.accenture.backday.hexagonal.domain.entities;

import cl.accenture.backday.hexagonal.domain.dto.ContactDto;
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
@Table(name = "CONTACT")
public class Contact {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTACT_ID_SEQUENCE")
  @SequenceGenerator(sequenceName = "CONTACT_ID_SEQUENCE", name = "CONTACT_ID_SEQUENCE", allocationSize = 1)
  @Column(name = "ID")
  private int id;

  private String email;

  private String phoneNumber;

  public Contact(ContactDto contactDTO){
    this.id = contactDTO.getId();
    this.email = contactDTO.getEmail();
    this.phoneNumber = contactDTO.getPhoneNumber();
  }

}
