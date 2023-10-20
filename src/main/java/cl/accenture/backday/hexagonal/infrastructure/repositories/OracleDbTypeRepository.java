package cl.accenture.backday.hexagonal.infrastructure.repositories;

import cl.accenture.backday.hexagonal.domain.entities.Type;
import cl.accenture.backday.hexagonal.domain.exceptions.DataException;
import cl.accenture.backday.hexagonal.domain.repositories.TypeRepository;
import cl.accenture.backday.hexagonal.infrastructure.repositories.service.OracleDbTypeRepositoryService;
import cl.accenture.backday.hexagonal.infrastructure.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OracleDbTypeRepository implements TypeRepository {

  @Autowired
  OracleDbTypeRepositoryService typeRepositoryService;

  @Override
  public void save(Type type) {
    try {
      log.info("Type: {}", type);
      typeRepositoryService.save(type);
    } catch (Exception ex) {
      log.error(String.valueOf(ex));
      throw new DataException(Constants.METHOD_NOT_IMPLEMENTED);
    }
  }
}
