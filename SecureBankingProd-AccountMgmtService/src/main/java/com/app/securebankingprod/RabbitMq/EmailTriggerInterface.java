package com.app.securebankingprod.RabbitMq;

import com.app.securebankingprod.Model.Account;
import com.app.securebankingprod.Model.CreditTracker;
import com.app.securebankingprod.Model.DebitTracker;

public interface EmailTriggerInterface {
    void triggerEmailForAccountCreation(Account account);
    void triggerEmailForPinChange(Account account);
    void triggerEmailForWithdrawRequest(DebitTracker debitTracker);
    void triggerEmailForDepositRequest(CreditTracker creditTracker);
}
