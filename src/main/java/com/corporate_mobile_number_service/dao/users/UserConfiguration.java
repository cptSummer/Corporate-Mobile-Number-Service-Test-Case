package com.corporate_mobile_number_service.dao.users;

import com.corporate_mobile_number_service.dao.users.jpa.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {

    @Bean
    UserMapper userMapper() {
        return new UserMapper();
    }

    @Bean
    UserService userService(UserRepository userRepository, UserMapper userMapper) {
        return new UserService(userRepository, userMapper);
    }
}
