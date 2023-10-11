package com.corporate_mobile_number_service.dao.phoneServices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PhoneServiceRepository  extends JpaRepository<PhoneServiceEntity, Long> , JpaSpecificationExecutor<PhoneServiceEntity> {

    @Query(value = "select id, service_name, service_cost from services",nativeQuery = true)
    List<PhoneServiceEntity> findServices();
}
