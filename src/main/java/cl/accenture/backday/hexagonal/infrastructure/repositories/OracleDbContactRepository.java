package cl.accenture.backday.hexagonal.infrastructure.repositories;

import cl.accenture.backday.hexagonal.domain.entities.Contact;
import cl.accenture.backday.hexagonal.domain.exceptions.DataException;
import cl.accenture.backday.hexagonal.domain.repositories.ContactRepository;
import cl.accenture.backday.hexagonal.infrastructure.repositories.service.OracleDbContactRepositoryService;
import cl.accenture.backday.hexagonal.infrastructure.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OracleDbContactRepository implements ContactRepository {

  @Autowired
  OracleDbContactRepositoryService contactRepositoryService;

  @Override
  public void save(Contact contact) {
    try {
      log.info("Contact: {}", contact);
      contactRepositoryService.save(contact);
    } catch (Exception ex) {
      log.error(String.valueOf(ex));
      throw new DataException(Constants.METHOD_NOT_IMPLEMENTED);
    }
  }
}
