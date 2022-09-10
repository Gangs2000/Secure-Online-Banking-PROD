package com.app.securebankingprod.Repository;

import com.app.securebankingprod.Model.DebitTracker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DebitTrackerRepository extends JpaRepository<DebitTracker, Long> {
    List<DebitTracker> findByDebitAccount(String accountNo);
}
