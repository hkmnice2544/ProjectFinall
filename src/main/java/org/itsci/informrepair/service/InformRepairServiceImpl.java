package org.itsci.informrepair.service;

import org.itsci.informrepair.model.InformRepair;
import org.itsci.informrepair.model.Reportrepair;
import org.itsci.informrepair.model.Review;
import org.itsci.informrepair.model.User;
import org.itsci.informrepair.repository.EquipmentRepository;
import org.itsci.informrepair.repository.InformRepairRepository;
import org.itsci.informrepair.repository.RoomRepository;
import org.itsci.informrepair.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class InformRepairServiceImpl implements InformRepairService{

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private InformRepairRepository informRepairRepository;

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate; // สร้าง JdbcTemplate สำหรับทำงานกับฐานข้อมูล




    @Override
    public List<InformRepair> getAllInformRepairs() {
        return informRepairRepository.findAll(); //เรียกข้อมูลทั้งหมด
    }
//    @Override
//    public List<InformRepair> getAllInformRepairs() {
//        List<InformRepair> informRepairs = informRepairRepository.findAll(); // เรียกข้อมูลทั้งหมด
//
//        // ดึงข้อมูล Equipment ที่มีข้อมูลแอตทริบิวต์ "status" มาด้วย
//        informRepairs.forEach(informRepair -> {
//            Set<Equipment> equipments = informRepair.getEquipment();
//            for (Equipment equipment : equipments) {
//            }
//        });
//
//        return informRepairs;
//    }


    @Override
    public InformRepair getInformRepairById(Integer informrepair_id) {
        return informRepairRepository.getReferenceById(informrepair_id);
    }

//    @Override
//    public InformRepair getInformEquip(Map<String, String> map) {
//        return null;
//    }
//
//    }

//    @Override
//    public InformRepair saveInformRepair(Map<String, String> map) {
//        return null;
//    }


    @Override
    public InformRepair saveInformRepair(Map<String, String> map) {
        Integer informrepair_id = generateInformRepairId(informRepairRepository.count() + 1);
        String informtype = map.get("informtype");
        Date informdate = new Date();
        String status = map.get("status");
        Integer user_id = Integer.parseInt(map.get("user_id"));
        User user = userRepository.getReferenceById(user_id);

        InformRepair informRepair = new InformRepair(informrepair_id,informdate,informtype,status,user);
        return informRepairRepository.save(informRepair);
    }




    @Override
    public InformRepair saveRoomEquipment(Map<String, String> map) {
        Integer informrepair_id = Integer.parseInt(map.get("informrepair_id"));
        Integer equipment_id = Integer.parseInt(map.get("equipment_id"));
        Integer room_id = Integer.parseInt(map.get("room_id"));

        // ทำการบันทึกข้อมูลลงในตาราง roomequipment
        String sql = "INSERT INTO roomequipment (informrepair_id, equipment_id, room_id) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, informrepair_id, equipment_id, room_id);

        // หลังจากบันทึกเรียบร้อยแล้ว คุณสามารถสร้าง InformRepair หรือดึงข้อมูลที่เกี่ยวข้อง
        // เพื่อคืนค่า InformRepair หรือค่าที่ต้องการกลับไปใน Controller
        InformRepair informRepair = new InformRepair(); // สร้างหรือดึงข้อมูลที่ต้องการคืนค่า
        return informRepair;
    }

//    @Override
//    public List<InformRepair> saveInformRepair(List<Map<String, String>> informRepairDataList) {
//        List<InformRepair> informRepairs = new ArrayList<>();
//
//        Integer informrepair_id = generateInformRepairId(informRepairRepository.count() + 1); // สร้าง informrepair_id เป็นค่าเดิม
//
//        Map<Integer, Integer> equipmentIdToInformRepairIdMap = new HashMap<>(); // เพิ่มแผนที่เพื่อตรวจสอบ equipment_id และ informrepair_id ที่มีอยู่แล้ว
//
//        for (Map<String, String> map : informRepairDataList) {
//            String informdetails = map.get("informdetails");
//            Date informdate = new Date();
//            String status = map.get("status");
//            Integer equipment_id = Integer.parseInt(map.get("equipment_id"));
//            if (equipmentIdToInformRepairIdMap.containsKey(equipment_id)) {
//                informrepair_id = equipmentIdToInformRepairIdMap.get(equipment_id);
//            } else {
//                informrepair_id = generateInformRepairId(informRepairRepository.count() + 1);
//                equipmentIdToInformRepairIdMap.put(equipment_id, informrepair_id);
//            }
//
//            Equipment equipment = equipmentRepository.getReferenceById(equipment_id);
//            Integer user_id = Integer.parseInt(map.get("user_id"));
//            User user = userRepository.getReferenceById(user_id); // ใช้อ็อบเจกต์ userRepository ที่ถูกสร้างขึ้นแล้ว
//
//            InformRepair informRepair = new InformRepair(informrepair_id, informdate, informdetails, status, equipment,user);
//            informRepairs.add(informRepairRepository.save(informRepair));
//        }
//
//        return informRepairs;
//    }







//    @Override
//    public InformRepair updateInformRepair(Map<String, String> map) {
//        Integer informrepair_id = Integer.parseInt(map.get("informrepair_id"));
//        String informdetails = map.get("informdetails");
//        Date informdate = new Date();
//        String status = map.get("status");
//        Integer equipment_id = Integer.parseInt(map.get("equipment_id"));
//        Equipment equipment = equipmentRepository.getReferenceById(equipment_id);Integer user_id = Integer.parseInt(map.get("user_id"));
//        User user = userRepository.getReferenceById(user_id); // ใช้อ็อบเจกต์ userRepository ที่ถูกสร้างขึ้นแล้ว
//
//
//        InformRepair informRepair = new InformRepair( informrepair_id, informdate, informdetails, status,equipment,user);
//        return informRepairRepository.save(informRepair);
//    }
//    @Override
//    public InformRepair deleteInformRepair(Integer informrepair_id) {
//        InformRepair informRepair = informRepairRepository.getReferenceById(informrepair_id);
//        informRepairRepository.delete(informRepair);
//        return informRepair;
//    }
//
//    @Override
//    public Equipment getEquipmentFromInformRepair(Integer informrepair_id) {
//        InformRepair informRepair = informRepairRepository.getReferenceById(informrepair_id);
//        if (informRepair != null) {
//            return informRepair.getEquipment();
//        }
//        return null;
//    }

    public Integer generateInformRepairId(long rewId){
        int result = (int) rewId;
        result = 10000 + result;
        return result;
    }























}
