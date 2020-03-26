package com.gaz.account.crud.repository;

import com.gaz.account.crud.AccountRepository;
import com.gaz.account.model.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@RequiredArgsConstructor
public class JdbcAccountRepository implements AccountRepository {

  private final JdbcTemplate jdbcTemplate;

  @Override
  public int save(Account account) {
    return jdbcTemplate.update("insert into accounts (name, surname) values(?, ?)",
        account.getName(), account.getSurname());
  }

  @Override
  public int update(String name, String newSurname) {
    return jdbcTemplate.update(
        "update accounts set surname = ? where name = ?",
        newSurname, findByName(name).getName());
  }

  @Override
  public Account findByName(String name) {
    return jdbcTemplate.queryForObject("select * from accounts where name = ?",
                                        new Object[]{name},
                                        (rs, rowNum) -> new Account(rs.getString("name"),
                                              rs.getString("surname")));
  }
}
