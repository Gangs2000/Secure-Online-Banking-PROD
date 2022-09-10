package com.app.securebankingprod.RabbitMq;

import com.app.securebankingprod.Model.Account;
import com.app.securebankingprod.Model.CreditTracker;
import com.app.securebankingprod.Model.DebitTracker;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailTriggerService implements EmailTriggerInterface{

    @Autowired RabbitTemplate template;

    @Override
    public void triggerEmailForAccountCreation(Account newAccount) {
        template.convertAndSend(MqConfigure.EXCHANGE,MqConfigure.ROUTING_KEY1, newAccount);              //Producing account object to RabbitMq Queue
    }

    @Override
    public void triggerEmailForPinChange(Account updatedPin) {
        template.convertAndSend(MqConfigure.EXCHANGE,MqConfigure.ROUTING_KEY2,updatedPin);               //Producing updated PIN to RabbitMq Queue
    }

    @Override
    public void triggerEmailForWithdrawRequest(DebitTracker debitTracker) {
        template.convertAndSend(MqConfigure.EXCHANGE,MqConfigure.ROUTING_KEY3,debitTracker);             //Producing withdraw tracker details to RabbitMq Queue
    }

    @Override
    public void triggerEmailForDepositRequest(CreditTracker creditTracker) {
        template.convertAndSend(MqConfigure.EXCHANGE,MqConfigure.ROUTING_KEY4,creditTracker);             //Producing deposit tracker details to RabbitMq Queue
    }
}
