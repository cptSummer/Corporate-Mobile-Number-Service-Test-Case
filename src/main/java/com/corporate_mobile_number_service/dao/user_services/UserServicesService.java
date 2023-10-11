package com.corporate_mobile_number_service.dao.user_services;

import com.corporate_mobile_number_service.dao.user_services.jpa.UserServicesRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserServicesService {

    private final UserServicesRepository userServicesRepository;
    private final UserServicesMapper userServicesMapper;

    @Transactional
    public boolean connectUserToService(Long user_id, Long service_id) {
        if(userServicesRepository.debitingFondsFromTheAccountForTheService(user_id, service_id)){
            userServicesRepository.connectUserToService(user_id, service_id);
            return true;
        }
       return false;
    }
}
