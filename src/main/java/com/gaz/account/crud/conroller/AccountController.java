package com.gaz.account.crud.conroller;

import com.gaz.account.model.Account;
import com.gaz.account.crud.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {

  private final AccountService service;

  @RequestMapping("/save/{name}/{surname}")
  @ResponseStatus(HttpStatus.CREATED)
  public int save(@PathVariable("name") String name, @PathVariable("surname") String surname) {
    return service.save(name, surname);
  }

  @RequestMapping("update/{name}/{surname}")
  @ResponseStatus(HttpStatus.OK)
  public boolean changeSurname(@PathVariable("name") String name, @PathVariable("surname") String surname) {
    return service.changeSurname(name, surname);
  }

  @RequestMapping("/find/{name}")
  @ResponseStatus(HttpStatus.OK)
  public Account find(@PathVariable("name") String name) {
    return service.find(name);
  }

}
