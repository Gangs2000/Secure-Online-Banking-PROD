package com.app.securebankingprod.SecurityConfigs;

import com.app.securebankingprod.Model.Account;
import com.app.securebankingprod.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired AccountRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> account=repository.findById(username);
        if(account.isEmpty())
            throw new UsernameNotFoundException("Account is not found in database..");
        return new AccountPrincipal(account);
    }
}
