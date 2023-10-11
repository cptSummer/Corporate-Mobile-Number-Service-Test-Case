package com.corporate_mobile_number_service.dao.user_services.jpa;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class UserServicesId implements Serializable {
    private Long user_id;
    private Long service_id;

}
