package com.corporate_mobile_number_service.users;

import com.corporate_mobile_number_service.dao.users.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserService userService;

    @Test
    public void testToppingUpThePhoneBill() throws Exception {
        Long user_id = 1L;
        int amount = 10;

        String expectedResponse = "Topping success";

        doNothing().when(userService).toppingUpThePhoneBillById(user_id, amount);

        MvcResult result = mockMvc.perform(post("/user/toppingUpThePhoneBillById")
                        .param("user_id", String.valueOf(user_id))
                        .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andReturn();

        String actualResponse = result.getResponse().getContentAsString();
        assertThat(actualResponse).isEqualTo(expectedResponse);
        verify(userService).toppingUpThePhoneBillById(user_id, amount);
    }


    @Test
    public void checkIfThereIsEnoughMoneyOnTheBalanceOfThePhoneTest() throws Exception {
        Long user_id = 1L;
        mockMvc.perform(get("/user/checkIfHasMoneyOnPhoneById")
                        .param("user_id", String.valueOf(user_id)))
                .andExpect(status().isOk());
    }


}

