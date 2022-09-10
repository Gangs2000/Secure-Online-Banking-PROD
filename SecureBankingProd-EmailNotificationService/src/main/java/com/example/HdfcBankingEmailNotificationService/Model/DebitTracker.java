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
public class DebitTracker {
    @Id
    private long id;
    private String debitAccount;
    private long debitAmount;
    private String stamp;
}
