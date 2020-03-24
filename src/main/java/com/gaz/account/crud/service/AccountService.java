package com.gaz.account.crud.service;

import com.gaz.account.crud.AccountRepository;
import com.gaz.account.model.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

  private final AccountRepository repository;

  public int save(final String name, final String surname) {
    return repository.save(new Account(name, surname));
  }

  public Account find(final String name) {
    return repository.findByName(name);
  }

  public boolean changeSurname(final String name, final String surname) {
    repository.update(name, surname);
    return find(name).getSurname().equals(surname);
  }

}
