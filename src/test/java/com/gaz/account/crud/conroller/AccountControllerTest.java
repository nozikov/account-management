package com.gaz.account.crud.conroller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import com.gaz.account.crud.AccountRepository;
import com.gaz.account.crud.service.AccountService;
import com.gaz.account.model.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AccountControllerTest {

  private final static String NAME = "Anton";
  private final static String SURNAME = "Nozikov";

  @Mock
  private AccountService service;
  @Mock
  private AccountRepository repository;
  @InjectMocks
  private AccountController controller;

  private Account account;

  @BeforeEach
  public void init() {
    account = new Account(NAME, SURNAME);
  }

  @Test
  void saveTest() {
    when(service.save(NAME, SURNAME)).thenReturn(1);
    assertEquals(1, controller.save(NAME, SURNAME));
  }

  @Test
  void changeSurnameTrueTest() {
    when(service.changeSurname(NAME, SURNAME)).thenReturn(true);
    assertTrue(controller.changeSurname(NAME, SURNAME));
  }

  @Test
  void changeSurnameFalseTest() {
    when(service.changeSurname(NAME, SURNAME)).thenReturn(false);
    assertFalse(controller.changeSurname(NAME, SURNAME));
  }

  @Test
  void findTest() {
    when(service.find(NAME)).thenReturn(account);
    assertEquals(account, controller.find(NAME));
  }
}