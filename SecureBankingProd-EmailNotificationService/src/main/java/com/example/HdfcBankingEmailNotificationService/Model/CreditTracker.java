package com.example.HdfcBankingEmailNotificationService.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CreditTracker {
    @Id
    private long id;
    private String creditAccount;
    private long creditAmount;
    private String stamp;
}
