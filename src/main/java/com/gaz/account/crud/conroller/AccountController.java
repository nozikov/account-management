package com.gaz.account.crud.conroller;

import com.gaz.account.model.Account;
import com.gaz.account.crud.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {

  private final AccountService service;

  @PostMapping("/save/name/{name}/surname/{surname}")
  @ResponseStatus(HttpStatus.CREATED)
  public int save(@PathVariable String name, @PathVariable String surname) {
    return service.save(name, surname);
  }

  @PostMapping("update/name/{name}/surname/{surname}")
  @ResponseStatus(HttpStatus.OK)
  public boolean changeSurname(@PathVariable String name, @PathVariable String surname) {
    return service.changeSurname(name, surname);
  }

  @PostMapping("/find")
  @ResponseStatus(HttpStatus.OK)
  public Account find(@RequestBody String name) {
    return service.find(name);
  }

}
