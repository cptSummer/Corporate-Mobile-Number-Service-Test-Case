package com.corporate_mobile_number_service.contrlollers;

import com.corporate_mobile_number_service.dao.user_services.UserServicesService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/userServices")
public class UserServicesController {

    private final UserServicesService userServicesService;

    @Transactional
    @PostMapping("/connect")
    public ResponseEntity<String> connectUserToService(@Param("user_id") Long user_id,
                                                       @Param("service_id") Long service_id) {
        return ResponseEntity.ok("User connected to service = " +
                userServicesService.connectUserToService(user_id, service_id));
    }

}
