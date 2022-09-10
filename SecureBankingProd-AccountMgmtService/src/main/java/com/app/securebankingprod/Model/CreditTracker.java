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
public class CreditTracker {
    @Id
    private long id;
    private String creditAccount;
    private long creditAmount;
    private String stamp;
}
