package com.app.securebankingprod.Controller;

import com.app.securebankingprod.Model.Account;
import com.app.securebankingprod.Service.SecureappService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountCreationController {

    @Autowired SecureappService service;

    @PostMapping(path="/createaccount",consumes = "application/x-www-form-urlencoded")
    public ModelAndView accountCreation(Account newAccount){
        return service.accountCreation(newAccount);
    }
}
