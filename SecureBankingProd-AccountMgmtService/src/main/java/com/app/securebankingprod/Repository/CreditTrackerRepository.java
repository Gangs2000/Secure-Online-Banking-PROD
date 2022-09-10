package com.app.securebankingprod.Repository;

import com.app.securebankingprod.Model.CreditTracker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditTrackerRepository extends JpaRepository<CreditTracker, Long> {
    List<CreditTracker> findByCreditAccount(String creditAccount);
}
