package com.corporate_mobile_number_service.userServicesServiceTest;


import com.corporate_mobile_number_service.dao.user_services.UserServicesService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class UserServicesControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserServicesService userServicesService;

    @Test
    public void connectUserToServiceTest() throws Exception {
        Long user_id = 1L;
        Long service_id = 2L;
        
        mockMvc.perform(post("/userServices/connect")
                .param("user_id", String.valueOf(user_id))
                .param("service_id", String.valueOf(service_id)))
                .andExpect(status().isOk());

        verify(userServicesService).connectUserToService(user_id, service_id);
    }
}
