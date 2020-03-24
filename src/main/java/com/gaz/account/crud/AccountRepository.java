package com.gaz.account.crud;

import com.gaz.account.model.Account;

public interface AccountRepository {

  Account findByName(String name);

  int save(Account user);

  int update(String name, String newSurname);

}
