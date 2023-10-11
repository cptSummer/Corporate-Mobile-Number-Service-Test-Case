package com.corporate_mobile_number_service.dao.users;

import lombok.Value;

@Value
public class UserDto {
    Long id;
    String first_name;
    String last_name;
    String phone_number;
    String password;
    int phone_balance;
}
