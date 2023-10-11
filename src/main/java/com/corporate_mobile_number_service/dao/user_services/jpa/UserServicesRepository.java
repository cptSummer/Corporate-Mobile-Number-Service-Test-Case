package com.corporate_mobile_number_service.dao.user_services.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserServicesRepository extends JpaRepository<UserServicesEntity, Long>,
        JpaSpecificationExecutor<UserServicesEntity> {
    @Modifying
    @Query(value = "insert into user_services (user_id, service_id) values (:userId, :serviceId)", nativeQuery = true)
    void connectUserToService(@Param("userId") Long userId, @Param("serviceId") Long serviceId);

    @Query(value = "select deduct_service_cost(:userId, :serviceId)", nativeQuery = true)
    boolean debitingFondsFromTheAccountForTheService(@Param("userId") Long userId,@Param("serviceId") Long serviceId);
}
