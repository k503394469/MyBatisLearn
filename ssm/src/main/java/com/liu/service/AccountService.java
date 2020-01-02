package com.liu.service;

import com.liu.domain.Account;

import java.util.List;

public interface AccountService {
    void save(Account account);
    List<Account> findAll();
}
