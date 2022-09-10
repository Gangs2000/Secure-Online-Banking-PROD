package com.app.securebankingprod.Interface;

import com.app.securebankingprod.Model.Account;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface SecureAppInterface {
    ModelAndView accountCreation(Account newAccount);
    ModelAndView forgotPin(Account updatedPin);
    ModelAndView withdrawRequest(HttpServletRequest request, HttpSession session);
    ModelAndView depositRequest(HttpServletRequest request, HttpSession session) throws InterruptedException;
}
