package com.corporate_mobile_number_service.dao.user_services.jpa;

import com.corporate_mobile_number_service.dao.phoneServices.jpa.PhoneServiceEntity;
import com.corporate_mobile_number_service.dao.users.jpa.UserEntity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user_services")
public class UserServicesEntity {
    @EmbeddedId
    private UserServicesId userServicesId;

    @ManyToOne
    @MapsId("user_id")
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("service_id")
    @JoinColumn(name = "service_id")
    private PhoneServiceEntity phoneServiceEntity;

}
