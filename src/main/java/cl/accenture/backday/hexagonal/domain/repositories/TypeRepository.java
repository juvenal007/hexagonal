package cl.accenture.backday.hexagonal.domain.repositories;

import cl.accenture.backday.hexagonal.domain.entities.Type;

public interface TypeRepository {

  void save(Type type);
}
