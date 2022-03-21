package com.userapplication.user.application.service;

import com.userapplication.user.application.bean.Account;
import com.userapplication.user.application.repository.AccountRepository;
import com.userapplication.user.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

//    @Autowired
//    private void setAccountRepository(AccountRepository accountRepository){
//        this.accountRepository = accountRepository;
//    }


    public Account getById(long id) {
        return accountRepository.findById(id).orElse(null);
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public void save(Account account) {
        accountRepository.save(account);
    }

    public void deleteById(long id) {
        accountRepository.deleteById(id);
    }
}
