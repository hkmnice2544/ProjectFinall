package org.itsci.informrepair.service;

import org.itsci.informrepair.model.User;
import org.itsci.informrepair.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LoginServicelmpl implements LoginService{


    @Autowired
    private UserRepository userRepository;

    @Override
    public User loginUser(Map<String, String> map) {
        // รับข้อมูลจาก map ในกรณีนี้คือ username และ password
        String username = map.get("username");
        String password = map.get("password");

        // ค้นหาผู้ใช้โดยใช้ชื่อผู้ใช้ (username) จากฐานข้อมูล
        User user = userRepository.findByUsername(username);

        // ตรวจสอบว่าพบผู้ใช้และรหัสผ่านถูกต้องหรือไม่
        if (user != null && user.getPassword().equals(password)) {
            // ถ้าถูกต้องคืนอ็อบเจกต์ User
            return user;
        } else {
            // ถ้าไม่ถูกต้องคืนค่า null หรือทำการระบบการยืนยันตัวตนเพิ่มเติมตามความเหมาะสม
            return null;
        }
    }

}
