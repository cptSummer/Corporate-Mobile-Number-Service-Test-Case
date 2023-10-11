package com.corporate_mobile_number_service.dao.user_services;

import com.corporate_mobile_number_service.dao.user_services.jpa.UserServicesRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserServicesConfiguration {

    @Bean
    UserServicesMapper userServicesMapper() {
        return new UserServicesMapper();
    }

    @Bean
    UserServicesService userServicesService(UserServicesRepository userServicesRepository, UserServicesMapper userServicesMapper) {
        return new UserServicesService(userServicesRepository, userServicesMapper);
    }
}
