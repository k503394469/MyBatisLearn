package com.liu.controller;

import com.liu.domain.Account;
import com.liu.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;
    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping("/save")
    public String save(Account account){
        accountService.save(account);
        return "redirect:/account/findAll";
    }
    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<Account> accountList = accountService.findAll();
        model.addAttribute("accountList",accountList);
        return "showList";
    }

}
