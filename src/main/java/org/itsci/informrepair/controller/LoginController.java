package org.itsci.informrepair.controller;

import org.itsci.informrepair.model.User;
import org.itsci.informrepair.service.InformRepairService;
import org.itsci.informrepair.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/loginController", produces = "application/json; charset=UTF-8")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @RequestMapping("/test")
    public String test() {
        return "hi";
    }
    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody Map<String, String> loginData) {
        // ตรวจสอบการเข้าสู่ระบบโดยใช้ LoginService
        User user = loginService.loginUser(loginData);


        if (user != null) {
            // เข้าสู่ระบบสำเร็จ
            return ResponseEntity.ok(user);
        } else {
            // เข้าสู่ระบบไม่สำเร็จ
            return ResponseEntity.notFound().build();
        }
    }

}
