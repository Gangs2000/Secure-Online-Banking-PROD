package com.app.securebankingprod.Controller;

import com.app.securebankingprod.Model.Account;
import com.app.securebankingprod.Repository.AccountRepository;
import com.app.securebankingprod.Repository.CreditTrackerRepository;
import com.app.securebankingprod.Repository.DebitTrackerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class RouteController {

    ModelAndView mv;

    @Autowired AccountRepository accountRepository;
    @Autowired DebitTrackerRepository debitTrackerRepository;
    @Autowired CreditTrackerRepository creditTrackerRepository;
    @Autowired Account account;

    @GetMapping("/")
    public ModelAndView homePage(HttpSession session){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        mv=new ModelAndView("options.jsp");
        mv.addObject("data",accountRepository.findById(auth.getName()).get());
        session.setAttribute("accountNo",auth.getName());
        return mv;
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login.jsp";
    }

    @GetMapping("/accountcreation")
    public String accountCreation(){
        return "createaccount.jsp";
    }

    @GetMapping("/forgotpin")
    public String forgotPin(){
        return "forgotpin.jsp";
    }

    @GetMapping("/withdraw")
    public String withDrawRequest(){
        return "withdraw.jsp";
    }

    @GetMapping("/deposit")
    public String depositRequest(){
        return "deposit.jsp";
    }

    @GetMapping("/checkbalance")
    public ModelAndView checkBalance(HttpSession session){
        mv=new ModelAndView("balance.jsp");
        account=accountRepository.findById((String) session.getAttribute("accountNo")).get();
        mv.addObject("balance",account);
        return mv;
    }

    @GetMapping("/gethistory")
    public ModelAndView getHistory(HttpSession session) {
        mv=new ModelAndView("history.jsp");
        mv.addObject("credit",creditTrackerRepository.findByCreditAccount((String) session.getAttribute("accountNo")));
        mv.addObject("debit",debitTrackerRepository.findByDebitAccount((String) session.getAttribute("accountNo")));
        return mv;
    }

    @GetMapping("/logout-success")
    public String logoutPage(){
        return "logout.jsp";
    }
}
