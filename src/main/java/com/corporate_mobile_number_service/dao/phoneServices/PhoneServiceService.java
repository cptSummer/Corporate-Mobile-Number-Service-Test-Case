package com.corporate_mobile_number_service.dao.phoneServices;

import com.corporate_mobile_number_service.dao.phoneServices.jpa.PhoneServiceRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class PhoneServiceService {

    private final PhoneServiceRepository phoneServiceRepository;

    private final PhoneServicesMapper phoneServicesMapper;

    public List<PhoneServiceDto> getAllPhoneServices() {
        return phoneServiceRepository
                .findServices()
                .stream()
                .map(phoneServicesMapper::toDto)
                .collect(Collectors.toList());
    }

    public void createPhoneService(PhoneServiceDto phoneServiceDto) {
        try {
            if (phoneServiceDto.getService_cost() < 0) {
                throw new IllegalArgumentException("Service cost must be greater or equal to 0");
            }
            phoneServiceRepository.save(phoneServicesMapper.toEntity(phoneServiceDto));
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
