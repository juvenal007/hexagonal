package cl.accenture.backday.hexagonal.application.usecases;

import cl.accenture.backday.hexagonal.domain.dto.CustomerDto;
import cl.accenture.backday.hexagonal.domain.entities.Contact;
import cl.accenture.backday.hexagonal.domain.entities.Customer;
import cl.accenture.backday.hexagonal.domain.entities.Type;
import cl.accenture.backday.hexagonal.domain.exceptions.LegalAgeException;
import cl.accenture.backday.hexagonal.domain.repositories.ContactRepository;
import cl.accenture.backday.hexagonal.domain.repositories.CustomerRepository;
import cl.accenture.backday.hexagonal.domain.repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** RegisterCustomerUseCase */
@Service
public class RegisterCustomerUseCase {

  @Autowired CustomerRepository customerRepository;

  @Autowired ContactRepository contactRepository;

  @Autowired TypeRepository typeRepository;

  /**
   * @param customerDTO
   */
  @Transactional
  public void execute(CustomerDto customerDTO) throws LegalAgeException {
    Customer customer = new Customer(customerDTO);
    Contact contact = new Contact(customerDTO.getContact());
    Type type = new Type(customerDTO.getType());
    customer.setType(type);
    customer.setContact(contact);
    customer.validateLegalAge();
    contactRepository.save(contact);
    typeRepository.save(type);
    customerRepository.save(customer);
  }
}
