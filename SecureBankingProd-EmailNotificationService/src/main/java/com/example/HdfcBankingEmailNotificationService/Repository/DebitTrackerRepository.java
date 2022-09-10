package com.example.HdfcBankingEmailNotificationService.Repository;

import com.example.HdfcBankingEmailNotificationService.Model.DebitTracker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DebitTrackerRepository extends JpaRepository<DebitTracker, Long> {

}
