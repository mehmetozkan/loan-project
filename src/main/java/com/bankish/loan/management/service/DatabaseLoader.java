package com.bankish.loan.management.service;

import com.bankish.loan.management.entity.Loan;
import com.bankish.loan.management.entity.User;
import com.bankish.loan.management.enumation.Status;
import com.bankish.loan.management.enumation.Type;
import com.bankish.loan.management.repository.LoanRepository;
import com.bankish.loan.management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DatabaseLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;
    @Autowired
    LoanRepository loanRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user = new User("serhat","aydın","serad","1",new String[] {"ROLE_USER", "ROLE_ADMIN"});
        User user2 = new User("çetin","kaltar","cetkal","1",new String[] {"ROLE_USER", "ROLE_ADMIN"});
        Loan loan = new Loan(20.0, Status.PAID, Type.SMALL_LOAN, user);
        Loan loan2 = new Loan(100.0, Status.UNPAID, Type.MORTGAGE, user2);
        userRepository.saveAll(Arrays.asList(user, user2));
        loanRepository.saveAll(Arrays.asList(loan, loan2));
    }
}
