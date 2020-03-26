package com.gaz.account.crud.service;

import com.gaz.account.crud.AccountRepository;
import com.gaz.account.model.Account;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountService {

  private final AccountRepository repository;

  public int save(final String name, final String surname) {
    log.info("Account was saved");
    return repository.save(new Account(name, surname));
  }

  public Account find(final String name) {
    Account account = repository.findByName(name);
    if (account != null) {
      log.info("Account was found");
    } else {
      log.info("Account with this name does not exist");
    }
    return account;
  }

  public boolean changeSurname(final String name, final String surname) {
    if (repository.update(name, surname) != 0) {
      log.info("Account was changed");
      return true;
    } else {
      log.info("Account wasn't changed");
      return false;
    }
  }
}
