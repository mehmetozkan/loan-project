package com.bankish.loan.management.rest.resource;

import com.bankish.loan.management.entity.Loan;
import com.bankish.loan.management.entity.User;
import com.bankish.loan.management.service.LoanManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loanmanagement")
public class LoanManagementResource {

    private final Logger LOG = LoggerFactory.getLogger(LoanManagementResource.class);

    @Autowired
    private LoanManagementService loanManagementService;

    @GetMapping(value = "get-all-loan-by-username/{userName}")
    public ResponseEntity<List<Loan>> getLoanByUser(@PathVariable String userName) {
        Assert.notNull(userName, "user name can not be null");
        return new ResponseEntity<>(loanManagementService.getLoanByUser(userName), HttpStatus.OK);
    }

    @GetMapping(value = "get-all-loans-order-by-amount")
    public ResponseEntity<List<Loan>> getAllLoansOrderingByAmount() {
        return new ResponseEntity<>(loanManagementService.getAllLoansOrderingByAmount(), HttpStatus.OK);
    }

    @GetMapping(value = "get-user/{userName}")
    public ResponseEntity<User> getUserByUserName(@PathVariable String userName) {
        Assert.notNull(userName, "user name can not be null");
        return new ResponseEntity<>(loanManagementService.getUserByUserName(userName), HttpStatus.OK);
    }

    @DeleteMapping(value = "delete-user/{userName}")
    public ResponseEntity<Void> deleteUserByUserName(@PathVariable String userName) {
        Assert.notNull(userName, "user name can not be null");
        loanManagementService.deleteUserByUserName(userName);
        LOG.info("user :" + userName + "has been deleted.");
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "create-user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<>(loanManagementService.createUser(user), HttpStatus.OK);
    }

    @PutMapping(value = "update-user")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return new ResponseEntity<>(loanManagementService.updateUser(user), HttpStatus.OK);
    }

    @PostMapping(value = "create-loan")
    public ResponseEntity<Loan> createLoan(@RequestBody Loan loan) {
        return new ResponseEntity<>(loanManagementService.createLoan(loan), HttpStatus.OK);
    }

    @PutMapping(value = "update-loan")
    public ResponseEntity<Loan> updateLoan(@RequestBody Loan loan) {
        return new ResponseEntity<>(loanManagementService.updateLoan(loan), HttpStatus.OK);
    }
}
