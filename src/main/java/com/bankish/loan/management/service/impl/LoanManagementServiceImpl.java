package com.bankish.loan.management.service.impl;

import com.bankish.loan.management.entity.Loan;
import com.bankish.loan.management.entity.User;
import com.bankish.loan.management.repository.LoanRepository;
import com.bankish.loan.management.repository.UserRepository;
import com.bankish.loan.management.service.LoanManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LoanManagementServiceImpl implements LoanManagementService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Loan> getLoanByUser(String userName) {
        return loanRepository.getLoanByUserUserName(userName);
    }

    @Override
    public List<Loan> getAllLoansOrderingByAmount() {
        return loanRepository.getAllByOrderByAmountDesc();
    }

    @Override
    public User getUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public void deleteUserByUserName(String userName) {
        userRepository.deleteUserByUserNameEquals(userName);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Loan createLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    @Override
    public Loan updateLoan(Loan loan) {
        return loanRepository.save(loan);
    }
}
