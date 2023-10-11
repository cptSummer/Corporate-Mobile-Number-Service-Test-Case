package com.corporate_mobile_number_service.dao.user_services;

import com.corporate_mobile_number_service.dao.user_services.jpa.UserServicesEntity;
import com.corporate_mobile_number_service.dao.user_services.jpa.UserServicesId;
import com.corporate_mobile_number_service.utils.Mapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserServicesMapper implements Mapper<UserServicesDto, UserServicesEntity> {
    @Override
    public UserServicesDto toDto(UserServicesEntity userServicesEntity) {
        return new UserServicesDto(
                userServicesEntity.getUserServicesId().getUser_id(),
                userServicesEntity.getUserServicesId().getService_id()
        );
    }

    @Override
    public UserServicesEntity toEntity(UserServicesDto userServicesDto) {
        UserServicesEntity entity = new UserServicesEntity();
        UserServicesId userServicesId = new UserServicesId();
        userServicesId.setUser_id(userServicesDto.getUser_id());
        userServicesId.setService_id(userServicesDto.getService_id());
        entity.setUserServicesId(userServicesId);
        return entity;
    }
}
