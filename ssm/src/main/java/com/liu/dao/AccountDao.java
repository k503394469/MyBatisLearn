package com.liu.dao;

import com.liu.domain.Account;

import java.util.List;
public interface AccountDao {
    void save(Account account);
    List<Account> findAll();
}
