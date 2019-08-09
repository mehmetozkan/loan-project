package com.bankish.loan.management.service;

import com.bankish.loan.management.entity.Loan;
import com.bankish.loan.management.entity.User;

import java.util.List;

public interface LoanManagementService {
    List<Loan> getLoanByUser(String userName);
    List<Loan> getAllLoansOrderingByAmount();
    User getUserByUserName(String userName);
    void deleteUserByUserName(String userName);
    User createUser(User user);
    User updateUser(User user);
    Loan createLoan(Loan loan);
    Loan updateLoan(Loan loan);
}
