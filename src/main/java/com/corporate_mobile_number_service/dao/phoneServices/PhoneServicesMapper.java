package com.corporate_mobile_number_service.dao.phoneServices;

import com.corporate_mobile_number_service.dao.phoneServices.jpa.PhoneServiceEntity;
import com.corporate_mobile_number_service.utils.Mapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PhoneServicesMapper implements Mapper<PhoneServiceDto, PhoneServiceEntity> {
    @Override
    public PhoneServiceDto toDto(PhoneServiceEntity phoneServiceEntity) {
        return new PhoneServiceDto(
                phoneServiceEntity.getId(),
                phoneServiceEntity.getService_name(),
                phoneServiceEntity.getService_cost());
    }

    @Override
    public PhoneServiceEntity toEntity(PhoneServiceDto phoneServiceDto) {
        PhoneServiceEntity entity = new PhoneServiceEntity();
        entity.setId(phoneServiceDto.getId());
        entity.setService_name(phoneServiceDto.getService_name());
        entity.setService_cost(phoneServiceDto.getService_cost());
        return entity;
    }
}
