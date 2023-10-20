package cl.accenture.backday.hexagonal.infrastructure.repositories.service;

import cl.accenture.backday.hexagonal.domain.entities.Customer;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OracleDbCustomerRepositoryService extends CrudRepository<Customer, Long> {

  Optional<Customer> getById(int id);


}
