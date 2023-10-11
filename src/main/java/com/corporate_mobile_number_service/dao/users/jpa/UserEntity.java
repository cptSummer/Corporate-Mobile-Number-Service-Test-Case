package com.corporate_mobile_number_service.dao.users.jpa;

import com.corporate_mobile_number_service.dao.user_services.jpa.UserServicesEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String first_name;
    private String last_name;
    private String phone_number;
    private String password;
    private int phone_balance;


    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
    private List<UserServicesEntity> userServices = new ArrayList<>();
}
