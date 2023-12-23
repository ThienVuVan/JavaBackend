package com.springbootsummary.modules.Account;

import com.springbootsummary.BeanUtils;
import com.springbootsummary.common.Service.UserService;
import com.springbootsummary.common.entity.Account;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class AccountController {
    private final UserService userService;
    // ví dụ đơn giản về controller.
    // có thể dùng các anotation rút gọn như @GetMapping, @PostMapping.

    // @RequestMapping(method = RequestMethod.GET, value = "/hello")
    // như đã biết @RestController là sự kết hợp của @Controller và @ResponseBody.
    @GetMapping("/hello")
    public ResponseEntity<?> GetUser(@RequestParam int id){
        return ResponseEntity.ok(userService.retrieveAccountById(id));
    }

    @GetMapping("/test")
    public ResponseEntity<?> TestUser(){
        userService.test();
        return ResponseEntity.ok("ok");
    }

    // catching error
    @GetMapping("/error")
    public ResponseEntity<?> PostError(@RequestParam int id){
        if(id == 0){
            throw new NullPointerException("loi roi check exeption");
        }
        return ResponseEntity.ok("khong loi");
    }

    @GetMapping("/error1")
    public ResponseEntity<?> PostError1(@RequestParam int id) throws IOException {
        if(id == 0){
            throw new IOException("loi roi check exeption");
        }
        return ResponseEntity.ok("khong loi");
    }
}
