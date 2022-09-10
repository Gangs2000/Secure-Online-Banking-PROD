package com.app.securebankingprod.Controller;

import com.app.securebankingprod.Service.SecureappService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class WithdrawController {

    @Autowired SecureappService service;

    @PostMapping(path = "/withdraw-request", consumes = "application/x-www-form-urlencoded")
    public ModelAndView withdrawRequest(HttpServletRequest request, HttpSession session){
        return service.withdrawRequest(request, session);
    }
}
