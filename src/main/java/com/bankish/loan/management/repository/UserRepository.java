package com.bankish.loan.management.repository;

import com.bankish.loan.management.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUserName(String userName);
    void deleteUserByUserNameEquals(String userName);
}
