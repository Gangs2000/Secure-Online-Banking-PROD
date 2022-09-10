package com.app.securebankingprod.Controller;

import com.app.securebankingprod.Service.SecureappService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class DepositController {
    @Autowired SecureappService service;

    @PostMapping(path = "/deposit-request", consumes = "application/x-www-form-urlencoded")
    public ModelAndView depositRequest(HttpServletRequest request, HttpSession session) throws InterruptedException {
        return service.depositRequest(request, session);
    }
}
