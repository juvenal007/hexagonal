package cl.accenture.backday.hexagonal.infrastructure.repositories.service;

import cl.accenture.backday.hexagonal.domain.entities.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OracleDbContactRepositoryService extends CrudRepository<Contact, Long> {}
