package cl.accenture.backday.hexagonal.domain.repositories;

import cl.accenture.backday.hexagonal.domain.entities.Contact;

public interface ContactRepository {

  void save(Contact contact);
}
