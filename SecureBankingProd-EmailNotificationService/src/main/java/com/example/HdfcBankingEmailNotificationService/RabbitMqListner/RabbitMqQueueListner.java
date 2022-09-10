package com.example.HdfcBankingEmailNotificationService.RabbitMqListner;

import com.example.HdfcBankingEmailNotificationService.Model.Account;
import com.example.HdfcBankingEmailNotificationService.Model.CreditTracker;
import com.example.HdfcBankingEmailNotificationService.Model.DebitTracker;
import com.example.HdfcBankingEmailNotificationService.RabbitMq.MqConfigure;
import com.example.HdfcBankingEmailNotificationService.Repository.AccountRepository;
import com.example.HdfcBankingEmailNotificationService.Repository.CreditTrackerRepository;
import com.example.HdfcBankingEmailNotificationService.Repository.DebitTrackerRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class RabbitMqQueueListner {

    @Autowired JavaMailSender javaMailSender;
    @Autowired AccountRepository accountRepository;
    @Autowired CreditTrackerRepository creditTrackerRepository;
    @Autowired DebitTrackerRepository debitTrackerRepository;
    @Autowired Account account;
    @Autowired CreditTracker creditTracker;
    @Autowired DebitTracker debitTracker;

    SimpleMailMessage simpleMailMessage=new SimpleMailMessage();

    //Queue for Account Creation email notification
    @RabbitListener(queues = MqConfigure.QUEUE1)
    public void accountCreation(Account newAccount) throws InterruptedException {
        account=accountRepository.findById(newAccount.getAccountNo()).get();
        simpleMailMessage.setFrom("evento.bookconfirmation@gmail.com");
        simpleMailMessage.setTo(account.getEmailId());
        simpleMailMessage.setSubject("Welcome To HDFC Banking PROD!!!");
        simpleMailMessage.setText("\n Dear "+account.getUserName()+" ,"
                +"\n \n Greetings from HDFC Banking PROD !!"
                +"\n \n Congratulations!! Your HDFC account has been created as per information shared by you...!!! Account No - XXXXX"+String.valueOf(account.getAccountNo()).substring(5)
                +"\n \n We take this opportunity to thank you for choosing us as your preferred banker and welcome you to HDFC Bank."
                +"\n \n We are hereby enclosing a soft copy of Welcome Letter containing the important information pertaining to your relationship with HDFC Bank for your quick access to the account."
                +"\n \n Please find the below account details.."
                +"\n \n Account Number      : "+account.getAccountNo()
                +"\n \n Account Holder Name : "+account.getUserName()
                +"\n \n Date of Birth       : "+account.getDob()
                +"\n \n Email ID            : "+account.getEmailId()
                +"\n \n Mobile Number       : +91 "+account.getMobile()
                +"\n \n \n Confidential Information - ( Keep it confidential do not share with others ) "
                +"\n \n Security Question   : "+account.getSecurityQuestion()
                +"\n \n Security Answer     : "+account.getSecurityAnswer()
                +"\n \n Should you need any assistance, feel free to contact your home branch through given PhoneBanking numbers or write to us - evento.bookconfirmation@gmail.com"
                +"\n \n We assure you that it is our constant endeavor To ensure that Each customer interaction Is made pleasant And satisfactory so that your relationship With the bank Is strengthened. We look forward To your Long lasting relationship With the bank."
                +"\n \n \n Warm Regards,"
                +"\n HDFC Banking PROD Ltd.."
                +"\n \n Note : This is an auto generated email. Please Do Not reply To this mail."
                );
        javaMailSender.send(simpleMailMessage);
        System.out.println("Account creation email has been triggered to "+account.getEmailId());
        Thread.sleep(3000);
    }

    //Queue for Security PIN change email Notification
    @RabbitListener(queues = MqConfigure.QUEUE2)
    public void securityPINChange(Account updatedAccount) throws InterruptedException {
        account=accountRepository.findById(updatedAccount.getAccountNo()).get();
        simpleMailMessage.setFrom("evento.bookconfirmation@gmail.com");
        simpleMailMessage.setTo(account.getEmailId());
        simpleMailMessage.setSubject("Alert!! - HDFC Banking PROD Security PIN has been changed by you...!!");
        simpleMailMessage.setText("Dear "+account.getUserName()+", "
                +"\n \n Login PIN will keep your MobileBanking App more secure and make it easier for you to upgrade when new features are added."
                +"\n \n This email is to notify that you have been changed your HDFC account security PIN on "+ LocalDate.now()
                +"\n \n Here is the updated security PIN - ( Keep it confidential do not share with others ) "
                +"\n \n Account Number      : "+account.getAccountNo()
                +"\n \n Account Holder Name : "+account.getUserName()
                +"\n \n Date of Birth       : "+account.getDob()
                +"\n \n Security PIN        : "+updatedAccount.getPassword()
                +"\n \n If the PIN is not changed by you please immediately drop an email to evento.bookconfirmation@gmail.com without further delay.."
                +"\n \n \n Warm Regards,"
                +"\n HDFC Banking PROD Ltd.."
                +"\n \n Note : This is an auto generated email. Please Do Not reply To this mail."
        );
        javaMailSender.send(simpleMailMessage);
        System.out.println("Security PIN change alert has been triggered to "+account.getEmailId());
        Thread.sleep(3000);
    }

    //Queue for Withdraw email Notification
    @RabbitListener(queues = MqConfigure.QUEUE3)
    public void withdrawNotification(DebitTracker updatedTracker) throws InterruptedException {
        account=accountRepository.findById(updatedTracker.getDebitAccount()).get();
        debitTracker=debitTrackerRepository.findById(updatedTracker.getId()).get();
        simpleMailMessage.setFrom("evento.bookconfirmation@gmail.com");
        simpleMailMessage.setSubject("HDFC System Alert!! - Amount Debited on your Acc - XXXXX"+String.valueOf(account.getAccountNo()).substring(5));
        simpleMailMessage.setTo(account.getEmailId());
        simpleMailMessage.setText("Dear "+account.getUserName()+", "
                +"\n \n Rs."+debitTracker.getDebitAmount()+" has been debited on "+LocalDate.now()+" from Acc - XXXXX"+String.valueOf(account.getAccountNo()).substring(5)
                +"\n CR. SMS BLOCK to +91 8870715240 to block all digital channel transactions if the current transaction is not done by you - HDFC Banking PROD."
                +"\n \n Transaction ID : "+debitTracker.getId()
                +"\n \n Debited Amount : Rs."+debitTracker.getDebitAmount()
                +"\n \n "+debitTracker.getStamp()
                +"\n \n Current Account Balance on your account is Rs."+account.getBalance()
                +"\n \n \n Warm Regards,"
                +"\n HDFC Banking PROD Ltd.."
                +"\n \n Note : This is an auto generated email. Please Do Not reply To this mail."
        );
        javaMailSender.send(simpleMailMessage);
        System.out.println("Withdrawn email Notification has been sent to user");
        Thread.sleep(3000);
    }

    //Queue for Deposit email Notification
    @RabbitListener(queues = MqConfigure.QUEUE4)
    public void depositNotification(CreditTracker updatedTracker) throws InterruptedException {
        account=accountRepository.findById(updatedTracker.getCreditAccount()).get();
        creditTracker=creditTrackerRepository.findById(updatedTracker.getId()).get();
        simpleMailMessage.setFrom("evento.bookconfirmation@gmail.com");
        simpleMailMessage.setSubject("HDFC System Alert!! - Amount Credited on your Acc - XXXXX"+String.valueOf(account.getAccountNo()).substring(5));
        simpleMailMessage.setTo(account.getEmailId());
        simpleMailMessage.setText("Dear "+account.getUserName()+", "
                +"\n \n Your Account number XXXXX"+String.valueOf(account.getAccountNo()).substring(5)+" credited by Rs."+creditTracker.getCreditAmount()+" on "+LocalDate.now()
                +"\n \n Transaction ID  : "+creditTracker.getId()
                +"\n \n Credited Amount : Rs."+creditTracker.getCreditAmount()
                +"\n \n "+creditTracker.getStamp()
                +"\n \n Current Account Balance on your account is Rs."+account.getBalance()
                +"\n \n \n Warm Regards,"
                +"\n HDFC Banking PROD Ltd.."
                +"\n \n Note : This is an auto generated email. Please Do Not reply To this mail."
        );
        javaMailSender.send(simpleMailMessage);
        System.out.println("Deposit email notification has been sent to user");
        Thread.sleep(3000);
    }
}
