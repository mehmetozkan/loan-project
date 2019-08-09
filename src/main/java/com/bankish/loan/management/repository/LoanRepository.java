package com.bankish.loan.management.repository;

import com.bankish.loan.management.entity.Loan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends CrudRepository<Loan, Long> {
    List<Loan> getLoanByUserUserName(String userName);
    List<Loan> getAllByOrderByAmountDesc();
}