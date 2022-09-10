package com.app.securebankingprod.Model;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
@Entity
public class Account {
    @Id
    private String accountNo;
    private String userName;
    private String password;
    private String emailId;
    private long balance;
    private String dob;
    private long mobile;
    private String securityQuestion;
    private String securityAnswer;
}
