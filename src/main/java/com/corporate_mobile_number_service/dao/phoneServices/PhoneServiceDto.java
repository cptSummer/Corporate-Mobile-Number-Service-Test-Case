package com.corporate_mobile_number_service.dao.phoneServices;

import lombok.Value;

@Value
public class PhoneServiceDto {
    Long id;
    String service_name;
    int service_cost;
}
