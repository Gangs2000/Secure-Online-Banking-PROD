package com.example.HdfcBankingEmailNotificationService.Repository;

import com.example.HdfcBankingEmailNotificationService.Model.CreditTracker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditTrackerRepository extends JpaRepository<CreditTracker, Long> {

}
