package com.corporate_mobile_number_service.dao.users.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity> {

    @Query(value = "select phone_balance from users where id = :id", nativeQuery = true)
    int checkThePhoneBalanceAmountById(@Param("id") Long userId);

    @Modifying
    @Query(value = "update users set  phone_balance = phone_balance + :amount where id = :id", nativeQuery = true)
    void toppingUpThePhoneBillById(@Param("id") Long userId, @Param("amount") int amount);

    @Query(value = "select phone_balance from users where phone_number = :phoneNumber", nativeQuery = true)
    int getThePhoneBalanceAmountByPhoneNumber(String phoneNumber);

    @Modifying
    @Query(value = "update users set phone_balance = phone_balance - :amountCallCost " +
            "where phone_number = :phoneNumber", nativeQuery = true)
    void rewriteThePhoneBalanceAfterCall(@Param("phoneNumber") String phoneNumber,
                                         @Param("amountCallCost") int amountCallCost);

    @Modifying
    @Query(value = "update users set phone_balance = phone_balance + :amount where phone_number = :phoneNumber", nativeQuery = true)
    void toppingUpThePhoneBillByPhone(@Param("phoneNumber") String phoneNumber,@Param("amount") int amount);
}
