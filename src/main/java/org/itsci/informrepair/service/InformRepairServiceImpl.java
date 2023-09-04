package org.itsci.informrepair.service;

import org.itsci.informrepair.model.Equipment;
import org.itsci.informrepair.model.InformRepair;
import org.itsci.informrepair.model.Inform_pictures;
import org.itsci.informrepair.model.User;
import org.itsci.informrepair.repository.EquipmentRepository;
import org.itsci.informrepair.repository.InformRepairRepository;
import org.itsci.informrepair.repository.RoomRepository;
import org.itsci.informrepair.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InformRepairServiceImpl implements InformRepairService{

    @Autowired
    private InformRepairRepository informRepairRepository;

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<InformRepair> getAllInformRepairs() {
        return informRepairRepository.findAll(); //เรียกข้อมูลทั้งหมด
    }


    @Override
    public InformRepair getInformRepairById(Integer informrepair_id) {
        return informRepairRepository.getReferenceById(informrepair_id);
    }

    @Override
    public InformRepair getInformEquip(Map<String, String> map) {
        return null;
    }

//    @Override
//    public InformRepair saveInformRepair(Map<String, String> map) {
//        return null;
//    }


    //    @Override
//    public InformRepair saveInformRepair(Map<String, String> map) {
//        Integer informrepair_id = generateInformRepairId(informRepairRepository.count() + 1);
//        String informdetails = map.get("informdetails");
//        Date informdate = new Date();
//        String status = map.get("status");
//        Integer equipment_id = Integer.parseInt(map.get("equipment_id"));
//        Equipment equipment = equipmentRepository.getReferenceById(equipment_id);
//
//
//        InformRepair informRepair = new InformRepair(informrepair_id, informdate, informdetails, status,equipment);
//        return informRepairRepository.save(informRepair);
//    }
    @Override
    public List<InformRepair> saveInformRepair(List<Map<String, String>> informRepairDataList) {
        List<InformRepair> informRepairs = new ArrayList<>();

        Integer informrepair_id = generateInformRepairId(informRepairRepository.count() + 1); // สร้าง informrepair_id เป็นค่าเดิม

        Map<Integer, Integer> equipmentIdToInformRepairIdMap = new HashMap<>(); // เพิ่มแผนที่เพื่อตรวจสอบ equipment_id และ informrepair_id ที่มีอยู่แล้ว

        for (Map<String, String> map : informRepairDataList) {
            String informdetails = map.get("informdetails");
            Date informdate = new Date();
            String status = map.get("status");
            Integer equipment_id = Integer.parseInt(map.get("equipment_id"));
            if (equipmentIdToInformRepairIdMap.containsKey(equipment_id)) {
                informrepair_id = equipmentIdToInformRepairIdMap.get(equipment_id);
            } else {
                informrepair_id = generateInformRepairId(informRepairRepository.count() + 1);
                equipmentIdToInformRepairIdMap.put(equipment_id, informrepair_id);
            }

            Equipment equipment = equipmentRepository.getReferenceById(equipment_id);
            Integer user_id = Integer.parseInt(map.get("user_id"));
            User user = userRepository.getReferenceById(user_id); // ใช้อ็อบเจกต์ userRepository ที่ถูกสร้างขึ้นแล้ว

            InformRepair informRepair = new InformRepair(informrepair_id, informdate, informdetails, status, equipment,user);
            informRepairs.add(informRepairRepository.save(informRepair));
        }

        return informRepairs;
    }







    @Override
    public InformRepair updateInformRepair(Map<String, String> map) {
        Integer informrepair_id = Integer.parseInt(map.get("informrepair_id"));
        String informdetails = map.get("informdetails");
        Date informdate = new Date();
        String status = map.get("status");
        Integer equipment_id = Integer.parseInt(map.get("equipment_id"));
        Equipment equipment = equipmentRepository.getReferenceById(equipment_id);Integer user_id = Integer.parseInt(map.get("user_id"));
        User user = userRepository.getReferenceById(user_id); // ใช้อ็อบเจกต์ userRepository ที่ถูกสร้างขึ้นแล้ว


        InformRepair informRepair = new InformRepair( informrepair_id, informdate, informdetails, status,equipment,user);
        return informRepairRepository.save(informRepair);
    }
    @Override
    public InformRepair deleteInformRepair(Integer informrepair_id) {
        InformRepair informRepair = informRepairRepository.getReferenceById(informrepair_id);
        informRepairRepository.delete(informRepair);
        return informRepair;
    }

    @Override
    public Equipment getEquipmentFromInformRepair(Integer informrepair_id) {
        InformRepair informRepair = informRepairRepository.getReferenceById(informrepair_id);
        if (informRepair != null) {
            return informRepair.getEquipment();
        }
        return null;
    }

    public Integer generateInformRepairId(long rewId){
        Integer result = Integer.parseInt(Long.toString(rewId));
        result =  10000 + result;
        return result;
    }























}
