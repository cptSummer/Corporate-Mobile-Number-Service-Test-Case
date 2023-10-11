package com.corporate_mobile_number_service.contrlollers;

import com.corporate_mobile_number_service.dao.users.UserDto;
import com.corporate_mobile_number_service.dao.users.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/saveUser")
    public ResponseEntity<String> saveUser(@RequestBody UserDto userDto){
        userService.saveUser(userDto);
        return ResponseEntity.ok("User saved");
    }

    @PostMapping("/toppingUpThePhoneBillById")
    public ResponseEntity<String> toppingUpThePhoneBillById(@Param("user_id") Long user_id,
                                                            @Param("amount") int amount){
        userService.toppingUpThePhoneBillById(user_id, amount);
        return ResponseEntity.ok("Topping success");
    }

    @PostMapping("/toppingUpThePhoneBillByPhone")
    public ResponseEntity<String> toppingUpThePhoneBillByPhone(@Param("phoneNumber") String phoneNumber,
                                                            @Param("amount") int amount){
        userService.toppingUpThePhoneBillByPhone(phoneNumber, amount);
        return ResponseEntity.ok("Topping success");
    }

    @GetMapping("/checkIfHasMoneyOnPhoneByPhone")
    public ResponseEntity<Boolean> checkIfThereIsEnoughMoneyOnTheBalanceOfThePhone(@Param("phoneNumber") String phoneNumber){
        return ResponseEntity.ok(userService.checkIfThereIsEnoughMoneyOnTheBalanceOfThePhone(phoneNumber));
    }

    @GetMapping("/getThePhoneBalanceAmountByPhone")
    public ResponseEntity<Integer> getThePhoneBalanceAmountByPhoneNumber(@Param("phoneNumber") String phoneNumber){
        return ResponseEntity.ok(userService.getThePhoneBalanceAmountByPhoneNumber(phoneNumber));
    }
    @Transactional
    @PostMapping("/setThePhoneBalanceAfterCall")
    public ResponseEntity<String> setThePhoneBalanceAfterCall(@Param("phoneNumber") String phoneNumber,
                                                              @Param("callMinutes") int callMinutes){
        userService.rewriteThePhoneBalanceAfterCall(phoneNumber, callMinutes);
        return ResponseEntity.ok("Call success");
    }

    @GetMapping("/getThePhoneBalanceAmountById")
    public ResponseEntity<Integer> checkThePhoneBalanceAmountById(@Param("user_id") Long user_id){
        return ResponseEntity.ok(userService.getThePhoneBalanceAmountById(user_id));
    }

    @GetMapping("/checkIfHasMoneyOnPhoneById")
    public ResponseEntity<Boolean> checkIfThereIsEnoughMoneyOnTheBalanceOfThePhone(@Param("user_id") Long user_id){
        return ResponseEntity.ok(userService.checkIfThereIsMoneyOnTheBalanceOfThePhoneById(user_id));
    }



}
