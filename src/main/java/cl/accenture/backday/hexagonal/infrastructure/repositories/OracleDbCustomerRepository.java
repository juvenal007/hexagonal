package cl.accenture.backday.hexagonal.infrastructure.repositories;

import cl.accenture.backday.hexagonal.domain.entities.Customer;
import cl.accenture.backday.hexagonal.domain.exceptions.DataException;
import cl.accenture.backday.hexagonal.domain.repositories.CustomerRepository;
import cl.accenture.backday.hexagonal.infrastructure.repositories.service.OracleDbCustomerRepositoryService;
import cl.accenture.backday.hexagonal.infrastructure.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OracleDbCustomerRepository implements CustomerRepository {

  @Autowired
  OracleDbCustomerRepositoryService customerRepositoryService;

  @Override
  public Customer getById(int id) {

    Customer user = customerRepositoryService.getById(id).orElseThrow(() -> {
      throw new DataException(Constants.METHOD_NOT_IMPLEMENTED);
    });
    return user;
  }

  @Override
  public void save(Customer user) {
    try {
      log.info("Customer: {}", user);
      customerRepositoryService.save(user);
    } catch (Exception ex) {
      log.error(String.valueOf(ex));
      throw new DataException(Constants.METHOD_NOT_IMPLEMENTED);
    }
  }
}
