package cl.accenture.backday.hexagonal.domain.repositories;

import cl.accenture.backday.hexagonal.domain.entities.Customer;

public interface CustomerRepository {

  Customer getById(int id);

  void save(Customer user);
}
