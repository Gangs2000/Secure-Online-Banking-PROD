package com.example.HdfcBankingEmailNotificationService.Repository;

import com.example.HdfcBankingEmailNotificationService.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

}
