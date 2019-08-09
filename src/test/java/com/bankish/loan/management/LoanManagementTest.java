package com.bankish.loan.management;

import com.bankish.loan.management.entity.Loan;
import com.bankish.loan.management.entity.User;
import com.bankish.loan.management.enumation.Status;
import com.bankish.loan.management.enumation.Type;
import com.bankish.loan.management.repository.LoanRepository;
import com.bankish.loan.management.repository.UserRepository;
import com.bankish.loan.management.service.LoanManagementService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoanManagementTest {

    @Autowired
    LoanManagementService loanManagementService;

    @MockBean
    UserRepository userRepository;

    @MockBean
    LoanRepository loanRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void createUserTest() {
        User user = new User("serhat", "aydın", "serad", "1", new String[] {"ROLE_USER", "ROLE_ADMIN"});
        when(userRepository.save(user)).thenReturn(user);
        assertEquals(user, userRepository.save(user));
    }

    @Test
    public void getUserByUserName() {
        when(userRepository.findByUserName("serad")).thenReturn(
                new User("serhat", "aydın", "serad", "1", new String[] {"ROLE_USER", "ROLE_ADMIN"}));
        assertEquals("serad", loanManagementService.getUserByUserName("serad").getUserName());
    }

    @Test
    public void deleteUserTest() {
        User user = new User("serhat", "aydın", "serad", "1", new String[] {"ROLE_USER", "ROLE_ADMIN"});
        loanManagementService.deleteUserByUserName("serad");
        verify(userRepository, times(1)).deleteUserByUserNameEquals("serad");
    }

    @Test
    public void getLoanByUserNameTest() {
        when(loanRepository.getLoanByUserUserName("serad")).thenReturn(Stream.of(
                new Loan(20.0, Status.PAID, Type.SMALL_LOAN, new User("serhat", "aydın", "serad", "1", new String[] {"ROLE_USER", "ROLE_ADMIN"}))).
                collect(Collectors.toList()));
        assertEquals(20.0, loanManagementService.getLoanByUser("serad").get(0).getAmount());
    }

}
