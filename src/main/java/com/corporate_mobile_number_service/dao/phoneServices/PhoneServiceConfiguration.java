package com.corporate_mobile_number_service.dao.phoneServices;

import com.corporate_mobile_number_service.dao.phoneServices.jpa.PhoneServiceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PhoneServiceConfiguration {

    @Bean
    PhoneServicesMapper phoneServicesMapper() {
        return new PhoneServicesMapper();
    }

    @Bean
    PhoneServiceService phoneServiceService(PhoneServiceRepository phoneServiceRepository, PhoneServicesMapper phoneServicesMapper) {
        return new PhoneServiceService(phoneServiceRepository, phoneServicesMapper);
    }
}
