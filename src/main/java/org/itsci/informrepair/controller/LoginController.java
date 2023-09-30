package org.itsci.informrepair.controller;

import org.itsci.informrepair.model.Reportrepair;
import org.itsci.informrepair.model.Review;
import org.itsci.informrepair.model.User;
import org.itsci.informrepair.service.InformRepairService;
import org.itsci.informrepair.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @PostMapping("/getidlogin/{username}")
    public ResponseEntity login(@PathVariable String username) {
        try {
            // ค้นหาข้อมูลผู้ใช้จาก username
            User user = loginService.getUserByUsername(username);

            if (user != null) {
                // ถ้าพบผู้ใช้ ให้คืนค่า user_id
                return ResponseEntity.ok(user.getUser_id());
            } else {
                // ถ้าไม่พบผู้ใช้ คืนค่า not found
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            // ถ้าเกิดข้อผิดพลาดอื่น ๆ ในการค้นหา
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/get/{user_id}")
    public ResponseEntity<?> getLoginById(@PathVariable Integer user_id) {
        try {
            User user = loginService.getLoginById(user_id);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/list", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<User>> listUser() {
        try {
            List<User> users = loginService.getAllUsers();
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
