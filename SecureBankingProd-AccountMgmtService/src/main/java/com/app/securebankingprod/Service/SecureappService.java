package com.app.securebankingprod.Service;

import com.app.securebankingprod.Interface.SecureAppInterface;
import com.app.securebankingprod.Model.Account;
import com.app.securebankingprod.Model.CreditTracker;
import com.app.securebankingprod.Model.DebitTracker;
import com.app.securebankingprod.RabbitMq.EmailTriggerService;
import com.app.securebankingprod.Repository.AccountRepository;
import com.app.securebankingprod.Repository.CreditTrackerRepository;
import com.app.securebankingprod.Repository.DebitTrackerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
public class SecureappService implements SecureAppInterface {

    Date date;
    DateFormat dateFormat;
    ModelAndView mv;
    BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
    @Autowired Account account;
    @Autowired DebitTracker debitTracker;
    @Autowired CreditTracker creditTracker;
    @Autowired AccountRepository accountRepository;
    @Autowired DebitTrackerRepository debitTrackerRepository;
    @Autowired CreditTrackerRepository creditTrackerRepository;
    @Autowired EmailTriggerService service;

    @Override
    public ModelAndView accountCreation(Account newAccount) {
        String plainTextPassword= newAccount.getPassword();
        mv=new ModelAndView("/datapages/accountconfirmation.jsp");
        if(accountRepository.count()==0)
            newAccount.setAccountNo("64500000");
        else
            newAccount.setAccountNo(String.valueOf(accountRepository.findAll().stream().map(object->Long.parseLong(object.getAccountNo())).max(Long::compareTo).get()+1));
        newAccount.setPassword(encoder.encode(newAccount.getPassword()));
        account=accountRepository.saveAndFlush(newAccount);
        newAccount.setPassword(plainTextPassword);
        mv.addObject("created",newAccount);
        //Calling Email Trigger Service method to send email for account creation confirmation
        service.triggerEmailForAccountCreation(account);
        return mv;
    }

    @Override
    public ModelAndView forgotPin(Account updatedPin) {
        if(accountRepository.existsById(updatedPin.getAccountNo())){
            account=accountRepository.findById(updatedPin.getAccountNo()).get();
            if(account.getSecurityQuestion().equals(updatedPin.getSecurityQuestion())){
                if(account.getSecurityAnswer().equals(updatedPin.getSecurityAnswer())){
                    mv=new ModelAndView("/datapages/pinupdate.jsp");
                    String plainTextPassword= updatedPin.getPassword();
                    account.setPassword(encoder.encode(updatedPin.getPassword()));
                    account=accountRepository.saveAndFlush(account);
                    account.setPassword(plainTextPassword);
                    //Calling Email Trigger Service method to send email for PIN change confirmation
                    service.triggerEmailForPinChange(account);
                    mv.addObject("updated",account);
                }
                else {
                    mv=new ModelAndView("/datapages/pinerror.jsp");
                    mv.addObject("error","Incorrect security question answer");
                }
            }
            else {
                mv=new ModelAndView("/datapages/pinerror.jsp");
                mv.addObject("error","Incorrect security question");
            }
        }
        else {
            mv=new ModelAndView("/datapages/pinerror.jsp");
            mv.addObject("error","Account number is not found in database");
        }
        return mv;
    }

    @Override
    public ModelAndView withdrawRequest(HttpServletRequest request, HttpSession session) {
        String accountNo=session.getAttribute("accountNo").toString();
        long withdrawAmount=Long.valueOf(request.getParameter("withdrawamount").toString());
        String password= request.getParameter("password").toString();
        account=accountRepository.findById(accountNo).get();
        mv=new ModelAndView("/datapages/withdrawstatus.jsp");
        if(account.getBalance()>=withdrawAmount){
            if(encoder.matches(password, account.getPassword())){
                debitTracker.setId((debitTrackerRepository.count()==0)?(24555200):(24555200+debitTrackerRepository.count()));
                debitTracker.setDebitAccount(accountNo);
                debitTracker.setDebitAmount(withdrawAmount);
                date=Calendar.getInstance().getTime();
                dateFormat=new SimpleDateFormat("dd-MM-yyyy hh:mm a");
                debitTracker.setStamp("Time stamp : "+(dateFormat.format(date))+" Amount : "+withdrawAmount+" has been Debited from your account");
                debitTracker=debitTrackerRepository.saveAndFlush(debitTracker);
                account.setBalance(account.getBalance()-withdrawAmount);
                accountRepository.saveAndFlush(account);
                //Calling Email Trigger Service method to send email for withdraw confirmation
                service.triggerEmailForWithdrawRequest(debitTracker);
                mv.addObject("status","Amount "+withdrawAmount+" has been withdrawn from your account");
            }
            else
                mv.addObject("status","Transaction declined due to incorrect password served");
        }
        else
            mv.addObject("status","Transaction declined due to insufficient balance in your account");
        return mv;
    }

    @Override
    public ModelAndView depositRequest(HttpServletRequest request, HttpSession session) throws InterruptedException {
        String currentAccountNo=session.getAttribute("accountNo").toString();
        String depositTo=request.getParameter("depositTo").toString();
        long depositAmount=Long.valueOf(request.getParameter("depositAmount").toString());
        String password= request.getParameter("password").toString();
        account=accountRepository.findById(currentAccountNo).get();
        mv=new ModelAndView("/datapages/depositstatus.jsp");
        if(accountRepository.existsById(depositTo)) {
            if(account.getBalance()>=depositAmount || depositTo.equals(currentAccountNo)) {
                if(encoder.matches(password, account.getPassword())) {
                    //Setting credit history
                    if (depositTo.equals(currentAccountNo))
                        account.setBalance(account.getBalance() + depositAmount);      //Updating balance in user row ( Self Deposit )
                    else {
                        account.setBalance(account.getBalance() - depositAmount);       //Updating balance in user row ( Deposit to others )
                        /*Logic for Debit amount for non-self deposit*/
                        debitTracker.setId((debitTrackerRepository.count() == 0) ? (24555200) : (24555200 + debitTrackerRepository.count()));
                        debitTracker.setDebitAccount((currentAccountNo));
                        debitTracker.setDebitAmount(depositAmount);
                        date=Calendar.getInstance().getTime();
                        dateFormat=new SimpleDateFormat("dd-MM-yyyy hh:mm a");
                        debitTracker.setStamp("Time stamp : " + (dateFormat.format(date)) + " Deposit amount : " + depositAmount + " has been Debited from your account and credited to account number " + depositTo);       //Setting debit history
                        debitTracker=debitTrackerRepository.saveAndFlush(debitTracker);
                    }
                    /*Logic for Credit amount for self deposit and non-self deposit*/
                    creditTracker.setId((creditTrackerRepository.count() == 0) ? (54555200) : (54555200 + creditTrackerRepository.count()));
                    creditTracker.setCreditAccount(depositTo);
                    creditTracker.setCreditAmount(depositAmount);
                    date=Calendar.getInstance().getTime();
                    dateFormat=new SimpleDateFormat("dd-MM-yyyy hh:mm a");
                    creditTracker.setStamp("Time stamp : " + (dateFormat.format(date)) + " Amount : " + depositAmount + " has been credited to your account");          //Setting credit history

                    creditTracker=creditTrackerRepository.saveAndFlush(creditTracker);
                    accountRepository.saveAndFlush(account);                             //Saving user record

                    account = accountRepository.findById(depositTo).get();               //Fetching depositor account details
                    if (! depositTo.equals(currentAccountNo)) {
                        account.setBalance(account.getBalance() + depositAmount);        //Updating balance in depositor row
                        accountRepository.saveAndFlush(account);                         //Saving depositor record
                        //Calling Email Trigger Service method to send email for withdraw confirmation
                        service.triggerEmailForWithdrawRequest(debitTracker);
                        Thread.sleep(4000);
                    }
                    //Calling Email Trigger Service method to send email for deposit confirmation
                    service.triggerEmailForDepositRequest(creditTracker);
                    mv.addObject("status", "Amount " + depositAmount + " has been deposited to " + depositTo + " account");
                }
                else
                    mv.addObject("status", "Transaction declined due to incorrect password served");
            }
            else
                mv.addObject("status","Transaction declined due to insufficient balance in your account");
        }
        else
            mv.addObject("status","Depositor account "+depositTo+" is not available in bank database");
        return mv;
    }
}
