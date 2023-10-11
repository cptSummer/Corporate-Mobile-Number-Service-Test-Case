package com.corporate_mobile_number_service.phoneServiceTest;


import com.corporate_mobile_number_service.dao.phoneServices.PhoneServiceDto;
import com.corporate_mobile_number_service.dao.phoneServices.PhoneServiceService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class PhoneServiceControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PhoneServiceService phoneServiceService;

    @Test
    public void testGetAllPhoneServices() throws Exception {
        mockMvc.perform(get("/phoneServices/getAllPhoneServices"))
                .andExpect(status().isOk());
        verify(phoneServiceService).getAllPhoneServices();
    }

    @Test
    public void testCreatePhoneService() throws Exception {
        PhoneServiceDto phoneServiceDto = new PhoneServiceDto(1L, "test", 10);
        String expectedResponse = "Phone service created";

        mockMvc.perform(post("/phoneServices/createPhoneService")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(phoneServiceDto)))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedResponse));

        verify(phoneServiceService, times(1)).createPhoneService(phoneServiceDto);
    }
}
