package com.corporate_mobile_number_service.dao.users;

import com.corporate_mobile_number_service.dao.users.jpa.UserEntity;
import com.corporate_mobile_number_service.dao.users.jpa.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional
    public void toppingUpThePhoneBillById(Long user_id, int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
        userRepository.toppingUpThePhoneBillById(user_id, amount);
    }

    @Transactional
    public void toppingUpThePhoneBillByPhone(String phoneNumber, int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
        userRepository.toppingUpThePhoneBillByPhone(phoneNumber, amount);
    }

    public int getThePhoneBalanceAmountById(Long user_id) {
        return userRepository.checkThePhoneBalanceAmountById(user_id);
    }

    public boolean checkIfThereIsMoneyOnTheBalanceOfThePhoneById(Long user_id) {
        int balance = userRepository.checkThePhoneBalanceAmountById(user_id);
        return balance > 0;
    }

    public int getThePhoneBalanceAmountByPhoneNumber(String phoneNumber) {
        return userRepository.getThePhoneBalanceAmountByPhoneNumber(phoneNumber);
    }

    public boolean checkIfThereIsEnoughMoneyOnTheBalanceOfThePhone(String phoneNumber) {
        int balance = userRepository.getThePhoneBalanceAmountByPhoneNumber(phoneNumber);
        return balance > 0;
    }

    @Transactional
    public void rewriteThePhoneBalanceAfterCall(String phoneNumber, int callMinutes) {
        int callCostMinute = 5;
        if(checkIfThereIsEnoughMoneyOnTheBalanceOfThePhone(phoneNumber)) {
            int amountCallCost = callMinutes * callCostMinute;
            if (callMinutes >= 1) {
                userRepository.rewriteThePhoneBalanceAfterCall(phoneNumber, amountCallCost);
            }
        }

    }

    public void saveUser(UserDto userDto) {
        try {
            UserEntity userEntity = userMapper.toEntity(userDto);
            userRepository.save(userEntity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
