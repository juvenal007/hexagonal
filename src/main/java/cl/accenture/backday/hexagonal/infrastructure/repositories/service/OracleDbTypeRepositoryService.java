package cl.accenture.backday.hexagonal.infrastructure.repositories.service;

import cl.accenture.backday.hexagonal.domain.entities.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OracleDbTypeRepositoryService extends CrudRepository<Type, Long> {}
