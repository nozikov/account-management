package com.gaz.account.service;

import com.gaz.account.AccountRepository;
import com.gaz.account.model.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

  private final AccountRepository repository;

  public Account find(final String name) {
    return repository.findByName(name);
  }
}
