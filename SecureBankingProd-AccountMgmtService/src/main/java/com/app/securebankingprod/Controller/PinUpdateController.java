package com.app.securebankingprod.Controller;

import com.app.securebankingprod.Model.Account;
import com.app.securebankingprod.Service.SecureappService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PinUpdateController {

    @Autowired  SecureappService service;

    @PostMapping(path="/pinchange", consumes = "application/x-www-form-urlencoded")
    public ModelAndView pinUpdate(Account updatePin){
        return service.forgotPin(updatePin);
    }
}
