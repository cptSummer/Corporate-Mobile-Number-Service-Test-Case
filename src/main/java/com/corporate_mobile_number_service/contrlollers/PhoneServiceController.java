package com.corporate_mobile_number_service.contrlollers;

import com.corporate_mobile_number_service.dao.phoneServices.PhoneServiceDto;
import com.corporate_mobile_number_service.dao.phoneServices.PhoneServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/phoneServices")
public class PhoneServiceController {
    private final PhoneServiceService phoneServiceService;

    @GetMapping("/getAllPhoneServices")
    public ResponseEntity<List<PhoneServiceDto>> getAllPhoneServices(){
        return ResponseEntity.ok(phoneServiceService.getAllPhoneServices());
    }

    @PostMapping("/createPhoneService")
    public ResponseEntity<String> createPhoneService(@RequestBody PhoneServiceDto phoneServiceDto){
        phoneServiceService.createPhoneService(phoneServiceDto);
        return ResponseEntity.ok("Phone service created");
    }

}
