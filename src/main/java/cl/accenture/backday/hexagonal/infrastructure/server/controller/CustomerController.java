package cl.accenture.backday.hexagonal.infrastructure.server.controller;

import cl.accenture.backday.hexagonal.application.usecases.RegisterCustomerUseCase;
import cl.accenture.backday.hexagonal.domain.dto.CustomerDto;
import cl.accenture.backday.hexagonal.domain.exceptions.LegalAgeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/costumer")
@CrossOrigin(
    origins = "*",
    methods = {RequestMethod.POST})
@Slf4j
public class CustomerController {

  @Autowired
  RegisterCustomerUseCase registerUserUseCase;

  @PostMapping(
      path = "/register",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> registerCostumer(@RequestBody CustomerDto userDto)
      throws LegalAgeException {
    log.info("hexagonal|registerCustomer|REQUEST|CustomerDto: {}", userDto);
    registerUserUseCase.execute(userDto);
    log.info("hexagonal|registerCustomer|RESPONSE|Usuario creado con exito.");
    return new ResponseEntity<>(HttpStatus.OK);
  }



}
