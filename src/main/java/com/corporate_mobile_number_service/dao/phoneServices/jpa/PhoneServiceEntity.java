package com.corporate_mobile_number_service.dao.phoneServices.jpa;

import com.corporate_mobile_number_service.dao.user_services.jpa.UserServicesEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "services")
public class PhoneServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String service_name;
    int service_cost;

    @OneToMany(mappedBy = "phoneServiceEntity", cascade = CascadeType.ALL)
    List<UserServicesEntity> userServices = new ArrayList<>();
}
