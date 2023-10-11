package com.corporate_mobile_number_service.userServicesServiceTest;


import com.corporate_mobile_number_service.dao.user_services.UserServicesMapper;
import com.corporate_mobile_number_service.dao.user_services.UserServicesService;
import com.corporate_mobile_number_service.dao.user_services.jpa.UserServicesRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@Transactional
@ExtendWith(SpringExtension.class)
public class UserServicesServiceTest {
    @InjectMocks
    private UserServicesService userServicesService;
    @Mock
    private UserServicesRepository userServicesRepository;
    @Mock
    private UserServicesMapper userServicesMapper;

    @Test
    public void testConnectUserToService_WhenDebitingSuccessful() {
        Long userId = 1L;
        Long serviceId = 2L;

        when(userServicesRepository.debitingFondsFromTheAccountForTheService(userId, serviceId)).thenReturn(true);

        boolean result = userServicesService.connectUserToService(userId, serviceId);

        assertTrue(result);

        verify(userServicesRepository, times(1)).connectUserToService(userId, serviceId);
    }

    @Test
    public void testConnectUserToService_WhenDebitingFailed() {
        Long userId = 1L;
        Long serviceId = 2L;

        when(userServicesRepository.debitingFondsFromTheAccountForTheService(userId, serviceId)).thenReturn(false);

        boolean result = userServicesService.connectUserToService(userId, serviceId);

        assertFalse(result);

        verify(userServicesRepository, never()).connectUserToService(userId, serviceId);
    }
}
