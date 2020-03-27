package com.gaz.account.crud.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.gaz.account.crud.AccountRepository;
import com.gaz.account.model.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {

  public static final String NAME = "Anton";
  public static final String SURNAME = "Nozikov";

  @Mock
  private AccountRepository repository;
  @InjectMocks
  private AccountService service;

  private Account account;

  @BeforeEach
  public void init() {
    account = new Account(NAME, SURNAME);
  }

  @Test
  void saveTest() {
    when(repository.save(account)).thenReturn(1);
    assertEquals(1, service.save(NAME, SURNAME));
  }

  @Test
  void findTest() {
    when(repository.findByName(NAME)).thenReturn(account);
    assertEquals(SURNAME, service.find(NAME).getSurname());
  }

  @Test
  void changeSurnameTrueTest() {
    when(repository.update(NAME, SURNAME)).thenReturn(1);
    assertTrue(service.changeSurname(NAME, SURNAME));
  }

  @Test
  void changeSurnameFalseTest() {
    when(repository.update(NAME, SURNAME)).thenReturn(0);
    assertFalse(service.changeSurname(NAME, SURNAME));
  }
}