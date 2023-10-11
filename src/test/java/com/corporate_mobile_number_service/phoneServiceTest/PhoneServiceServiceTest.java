package com.corporate_mobile_number_service.phoneServiceTest;

import com.corporate_mobile_number_service.dao.phoneServices.PhoneServiceDto;
import com.corporate_mobile_number_service.dao.phoneServices.PhoneServiceService;
import com.corporate_mobile_number_service.dao.phoneServices.PhoneServicesMapper;
import com.corporate_mobile_number_service.dao.phoneServices.jpa.PhoneServiceEntity;
import com.corporate_mobile_number_service.dao.phoneServices.jpa.PhoneServiceRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
@Transactional
@ExtendWith(SpringExtension.class)
public class PhoneServiceServiceTest {
    @InjectMocks
    private PhoneServiceService phoneServiceService;
    @Mock
    private PhoneServicesMapper phoneServicesMapper;
    @Mock
    private PhoneServiceRepository phoneServiceRepository;

    @Test
    public void getAllPhoneServicesTest() {
        PhoneServiceDto phoneServiceDto = new PhoneServiceDto(1L,"test", 10);
        PhoneServiceEntity phoneServiceEntity = phoneServicesMapper.toEntity(phoneServiceDto);
        when(phoneServiceRepository.findServices()).thenReturn(Collections.singletonList(phoneServiceEntity));
        List<PhoneServiceDto> phoneServiceDtos = phoneServiceService.getAllPhoneServices();
        assertThat(phoneServiceDtos).isNotNull();
        assertThat(phoneServiceDtos).hasSize(1);

    }

    @Test
    public void createPhoneServiceTest() {
        PhoneServiceDto phoneServiceDto = new PhoneServiceDto(null,"test", 10);
        phoneServiceService.createPhoneService(phoneServiceDto);
        verify(phoneServiceRepository).save(phoneServicesMapper.toEntity(phoneServiceDto));
    }
}
