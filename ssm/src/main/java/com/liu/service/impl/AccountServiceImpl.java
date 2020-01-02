package com.liu.service.impl;

import com.liu.dao.AccountDao;
import com.liu.domain.Account;
import com.liu.service.AccountService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    private final AccountDao accountDao;


    @Autowired
    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void save(Account account) {
        accountDao.save(account);
    }

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }
}
