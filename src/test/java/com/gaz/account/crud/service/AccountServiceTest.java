package com.gaz.account.crud.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.gaz.account.crud.AccountRepository;
import com.gaz.account.model.Account;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {

  @Mock
  private AccountRepository repository;
  @InjectMocks
  private AccountService service;

  @Test
  void saveTest() {
    Account account = new Account("Anton", "Nozikov");
    when(repository.save(account)).thenReturn(1);
    assertEquals(1, service.save("Anton", "Nozikov"));
  }

  @Test
  void findTest() {
    Account account = new Account("Anton", "Nozikov");
    when(repository.findByName("Anton")).thenReturn(account);
    assertEquals("Nozikov", service.find("Anton").getSurname());
  }

  @Test
  void changeSurnameTrueTest() {
    when(repository.update("Anton", "Nozikov")).thenReturn(1);
    assertTrue(service.changeSurname("Anton", "Nozikov"));
  }

  @Test
  void changeSurnameFalseTest() {
    when(repository.update("Anton", "Nozikov")).thenReturn(0);
    assertFalse(service.changeSurname("Anton", "Nozikov"));
  }
}