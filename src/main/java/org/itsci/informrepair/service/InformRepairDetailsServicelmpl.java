package org.itsci.informrepair.service;


import org.itsci.informrepair.model.*;
import org.itsci.informrepair.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InformRepairDetailsServicelmpl implements InformRepairDetailsService {
    @Autowired
    private InformRepiarDetailsRepository informRepiarDetailsRepository;
    @Autowired
    private InformRepairRepository informRepairRepository;
    @Autowired
    private RoomEquipmentRepository roomEquipmentRepository;
//    @Autowired
//    private Inform_picturesRepository inform_picturesRepository;

//    @PersistenceContext
//    private EntityManager entityManager;

    public InformRepairDetails findInformRepairDetailsById(InformRepairDetailsID id) {
        return informRepiarDetailsRepository.findById(id).orElse(null);
    }


    public List<InformRepairDetails> saveInformRepairDetails(List<Map<String, String>> dataList) {
        List<InformRepairDetails> savedDetailsList = new ArrayList<>();

        for (Map<String, String> map : dataList) {
            Integer informrepair_id = Integer.parseInt(map.get("informrepair_id"));
            InformRepair informRepair = informRepairRepository.findById(informrepair_id).orElse(null);

            if (informRepair == null) {
                // ทำการจัดการเมื่อไม่พบ InformRepair ที่เกี่ยวข้อง (ตามความเหมาะสม)
                // ยกเลิกการบันทึกหรือทำบางอย่างอื่นๆ ตามที่คุณต้องการ
                continue;
            }

            Integer equipment_id = Integer.parseInt(map.get("equipment_id"));
            Integer room_id = Integer.parseInt(map.get("room_id"));

            RoomEquipmentId roomEquipmentId = new RoomEquipmentId(equipment_id, room_id);
            RoomEquipment roomEquipment = (RoomEquipment) roomEquipmentRepository.findById(roomEquipmentId).orElse(null);

            if (roomEquipment == null) {
                // ทำการจัดการเมื่อไม่พบ RoomEquipment ที่เกี่ยวข้อง (ตามความเหมาะสม)
                // ยกเลิกการบันทึกหรือทำบางอย่างอื่นๆ ตามที่คุณต้องการ
                continue;
            }

            // คำนวณค่าอื่น ๆ เช่น amount, details ตามปกติ
            // ...

            // เมื่อคุณมี informrepair_id, informRepair, equipment_id, room_id, roomEquipment ที่ถูกต้องและมีค่า
            // สร้างและบันทึก InformRepairDetails
            String amountStr = map.get("amount");
            Integer amount = Integer.parseInt(amountStr);
            String details = map.get("details");
            String pictures = map.get("pictures");

            InformRepairDetails informRepairDetails = new InformRepairDetails();
            InformRepairDetailsID id = new InformRepairDetailsID(equipment_id, room_id, informrepair_id);
            informRepairDetails.setId(id);
            informRepairDetails.setAmount(amount);
            informRepairDetails.setDetails(details);
            informRepairDetails.setPictures(pictures);
            informRepairDetails.setInformrepairid(informRepair);
            informRepairDetails.setRoomEquipment(roomEquipment);

            InformRepairDetails savedInformRepairDetails = informRepiarDetailsRepository.save(informRepairDetails);
            savedDetailsList.add(savedInformRepairDetails);
        }

        return savedDetailsList;
    }


        public List<InformRepairDetails> updateInformRepairDetails(List<Map<String, String>> dataList) {
            List<InformRepairDetails> savedDetailsList = new ArrayList<>();

            for (Map<String, String> map : dataList) {
                Integer informrepair_id = Integer.parseInt(map.get("informrepair_id"));
                InformRepair informRepair = informRepairRepository.findById(informrepair_id).orElse(null);

                if (informRepair == null) {
                    // ทำการจัดการเมื่อไม่พบ InformRepair ที่เกี่ยวข้อง (ตามความเหมาะสม)
                    // ยกเลิกการบันทึกหรือทำบางอย่างอื่นๆ ตามที่คุณต้องการ
                    continue;
                }

                Integer equipment_id = Integer.parseInt(map.get("equipment_id"));
                Integer room_id = Integer.parseInt(map.get("room_id"));

                RoomEquipmentId roomEquipmentId = new RoomEquipmentId(equipment_id, room_id);
                RoomEquipment roomEquipment = (RoomEquipment) roomEquipmentRepository.findById(roomEquipmentId).orElse(null);

                if (roomEquipment == null) {
                    // ทำการจัดการเมื่อไม่พบ RoomEquipment ที่เกี่ยวข้อง (ตามความเหมาะสม)
                    // ยกเลิกการบันทึกหรือทำบางอย่างอื่นๆ ตามที่คุณต้องการ
                    continue;
                }

                // คำนวณค่าอื่น ๆ เช่น amount, details ตามปกติ
                // ...

                // เมื่อคุณมี informrepair_id, informRepair, equipment_id, room_id, roomEquipment ที่ถูกต้องและมีค่า
                // สร้างและบันทึก InformRepairDetails
                String amountStr = map.get("amount");
                Integer amount = Integer.parseInt(amountStr);
                String details = map.get("details");

                InformRepairDetails informRepairDetails = new InformRepairDetails();
                InformRepairDetailsID id = new InformRepairDetailsID(equipment_id, room_id, informrepair_id);
                informRepairDetails.setId(id);
                informRepairDetails.setAmount(amount);
                informRepairDetails.setDetails(details);
                informRepairDetails.setInformrepairid(informRepair);
                informRepairDetails.setRoomEquipment(roomEquipment);

                InformRepairDetails savedInformRepairDetails = informRepiarDetailsRepository.save(informRepairDetails);
                savedDetailsList.add(savedInformRepairDetails);
            }

            return savedDetailsList;
        }

    public void deleteInformRepairDetails(InformRepairDetailsID id) {
        informRepiarDetailsRepository.deleteById(id);
    }




//    public InformRepairDetails updateInformRepairDetails (Map<String, String> map) {
//        Integer informdetails_id = Integer.parseInt(map.get("informdetails_id"));
//        String amountStr = map.get("amount");
//        String details = map.get("details");
//        Integer informrepair_id = Integer.parseInt(map.get("informrepair_id"));
//        InformRepair informRepair = informRepairRepository.getReferenceById(informrepair_id);
//
//        Integer amount = Integer.parseInt(amountStr);
//
//        InformRepairDetails informRepairDetails = new InformRepairDetails();
//        informRepairDetails.setAmount(amount);
//        informRepairDetails.setDetails(details);
//        informRepairDetails.setInformdetails_id(informdetails_id);
//        informRepairDetails.setInformRepair(informRepair);
//
//        Integer equipment_id = Integer.parseInt(map.get("equipment_id"));
//        Integer room_id = Integer.parseInt(map.get("room_id"));
//        RoomEquipmentId roomEquipmentId = new RoomEquipmentId(equipment_id, room_id);
//
//        RoomEquipment roomEquipment = (RoomEquipment) roomEquipmentRepository.findById(roomEquipmentId).orElse(null);
//
//        if (roomEquipment != null) {
//            // อัปเดต "status" ใน RoomEquipment หากมีอยู่แล้ว
//            String status = map.get("status");
//            roomEquipment.setStatus(status);
//        } else {
//            // สร้าง RoomEquipment และตั้งค่า "status" หากไม่มีอยู่
//            roomEquipment = new RoomEquipment();
//            roomEquipment.setRoomEquipmentId(roomEquipmentId);
//            String status = map.get("status");
//            roomEquipment.setStatus(status);
//        }
//
//        informRepairDetails.setRoomEquipment(roomEquipment);
//
//        InformRepairDetails savedInformRepairDetails = informRepiarDetailsRepository.save(informRepairDetails);
//
//        return savedInformRepairDetails;
//    }



    public Integer generateInformRepairDetailsId(long rewId) {
        int result = (int) rewId;
        result = 1000 + result;
        return result;
    }

    @Override
    public List<InformRepairDetails> getAllInformRepairDetails() {
        return informRepiarDetailsRepository.findAll();
    }

    @Override
    public InformRepairDetails getInformRepairDetailsById(Integer equipmentId, Integer roomId, Integer informRepairId) {
        InformRepairDetailsID id = new InformRepairDetailsID(equipmentId, roomId, informRepairId);
        return (InformRepairDetails) informRepiarDetailsRepository.findById(id).orElse(null);
    }

//    public InformRepairDetails getInformRepairDetailsById(Integer equipment_id, Integer room_id, Integer informrepair_id) {
//        InformRepairDetailsID id = new InformRepairDetailsID(equipment_id, room_id, informrepair_id);
//        Optional<InformRepairDetails> detailsOptional = informRepiarDetailsRepository.findById(id);
//        return detailsOptional.orElse(null);
//    }





//    @Override
//    public InformRepairDetails deleteInformRepairDetailsById(Integer informdetails_id) {
//        InformRepairDetails informRepairDetails = informRepiarDetailsRepository.getReferenceById(informdetails_id);
//        informRepiarDetailsRepository.delete(informRepairDetails);
//        return informRepairDetails;
//    }
//
//
    @Override
    public List<InformRepairDetails> findViewInformDetailsById(int informrepair_id) {
        return informRepiarDetailsRepository.findAllDetailsByInformRepairId(informrepair_id);
    }

    @Override
    public List<InformRepairDetails> ViewListInformDetails(int informrepair_id) {
        return informRepiarDetailsRepository.ViewListInformDetails(informrepair_id);
    }


    @Override
    public List<InformRepairDetails> ListInformDetailsGroupbyinformrepair_id() {
        return informRepiarDetailsRepository.ListInformDetailsGroupbyinformrepair_id();
    }


    @Override
    public List<String> findequipment_idByIdByinformrepair_id(int informrepair_id) {
        return informRepiarDetailsRepository.findequipment_idByIdByinformrepair_id(informrepair_id);
    }

    @Override
    public List<String> finddetailsByIdByinformrepair_id(int informrepair_id) {
        return informRepiarDetailsRepository.finddetailsByIdByinformrepair_id(informrepair_id);
    }
    @Override
    public List<String> findamountByIdByinformrepair_id(int informrepair_id) {
        return informRepiarDetailsRepository.findamountByIdByinformrepair_id(informrepair_id);
    }

    @Override
    public List<String> findpicturesByIdByinformrepair_id(int informrepair_id) {
        return informRepiarDetailsRepository.findpicturesByIdByinformrepair_id(informrepair_id);
    }
















}
