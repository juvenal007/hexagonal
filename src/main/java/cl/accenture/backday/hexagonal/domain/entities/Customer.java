package cl.accenture.backday.hexagonal.domain.entities;

import cl.accenture.backday.hexagonal.domain.dto.CustomerDto;
import cl.accenture.backday.hexagonal.domain.exceptions.LegalAgeException;
import cl.accenture.backday.hexagonal.infrastructure.utils.Constants;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
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
@Table(name = "CUSTOMER")
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUSTOMER_ID_SEQUENCE")
  @SequenceGenerator(sequenceName = "CUSTOMER_ID_SEQUENCE", name = "CUSTOMER_ID_SEQUENCE", allocationSize = 1)
  @Column(name = "ID")
  private int id;

  @Transient
  private final int legalAge = 18;

  @OneToOne(optional = false)
  @JoinColumn(name = "CUSTOMER_CONTACT_ID")
  private Contact contact;

  @OneToOne(optional = false)
  @JoinColumn(name = "CUSTOMER_TYPE_ID")
  private Type type;

  private String name;

  private int age;

  public Customer(CustomerDto customerDTO) {
    this.type = new Type(customerDTO.getType());
    this.contact = new Contact(customerDTO.getContact());
    this.id = customerDTO.getId();
    this.name = customerDTO.getName();
    this.age = customerDTO.getAge();
  }

  public void validateLegalAge() throws LegalAgeException {
    if (this.age < this.legalAge) {
      throw new LegalAgeException(Constants.CUSTOMER_AGE_EXCEPTION);
    }
  }
}
