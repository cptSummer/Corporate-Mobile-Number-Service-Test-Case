package com.corporate_mobile_number_service.users;

import com.corporate_mobile_number_service.dao.users.UserDto;
import com.corporate_mobile_number_service.dao.users.UserMapper;
import com.corporate_mobile_number_service.dao.users.UserService;
import com.corporate_mobile_number_service.dao.users.jpa.UserEntity;
import com.corporate_mobile_number_service.dao.users.jpa.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
@Transactional
@ExtendWith(SpringExtension.class)
public class UserServiceTest {
    @InjectMocks
    private UserService userService;

    @Mock
    private UserMapper userMapper;

    @Mock
    private UserRepository userRepository;


    @Test
    public void testToppingUpThePhoneBill() {
        int initialBalance = 35;

        when(userRepository.checkThePhoneBalanceAmountById(1L)).thenReturn(initialBalance);

        userService.toppingUpThePhoneBillById(1L, 10);

        int expectedBalance = initialBalance + 10;

        when(userRepository.checkThePhoneBalanceAmountById(1L)).thenReturn(expectedBalance);

        int actualBalance = userService.getThePhoneBalanceAmountById(1L);
        assertThat(actualBalance).isEqualTo(expectedBalance);
    }


    @Test
    public void testToppingUpThePhoneBillWithException() {
        Long user_id = 1L;
        int toppingUpAmount = -10;

        assertThrows(IllegalArgumentException.class, () -> userService.toppingUpThePhoneBillById(user_id, toppingUpAmount));
    }

    @Test
    public void rewriteThePhoneBalanceAfterCall() {
        String phoneNumber = "+380678836147";
        int callMinutes = 5;
        int balanceBeforeCall = 50;
        when(userRepository.getThePhoneBalanceAmountByPhoneNumber(phoneNumber)).thenReturn(balanceBeforeCall);
        userService.toppingUpThePhoneBillByPhone(phoneNumber, balanceBeforeCall);
        userService.rewriteThePhoneBalanceAfterCall(phoneNumber, callMinutes);
        verify(userRepository).getThePhoneBalanceAmountByPhoneNumber(phoneNumber);
        verify(userRepository).rewriteThePhoneBalanceAfterCall(phoneNumber, callMinutes * 5);


    }
    @Test
    public void rewriteThePhoneBalanceAfterCallError() {
        String phoneNumber = "+380678836147";
        int callMinutes = 5;
        int balanceBeforeCall = -50;
        when(userRepository.getThePhoneBalanceAmountByPhoneNumber(phoneNumber)).thenReturn(balanceBeforeCall);
        userService.rewriteThePhoneBalanceAfterCall(phoneNumber, callMinutes);
        verify(userRepository).getThePhoneBalanceAmountByPhoneNumber(phoneNumber);

        assertThat(userService.checkIfThereIsEnoughMoneyOnTheBalanceOfThePhone(phoneNumber)).isFalse();
    }



}
