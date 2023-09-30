package org.itsci.informrepair.service;


import org.itsci.informrepair.model.*;
import org.itsci.informrepair.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private Inform_picturesRepository inform_picturesRepository;

//    @PersistenceContext
//    private EntityManager entityManager;
    public InformRepairDetails findInformRepairDetailsById(Integer informdetails_id) {
        return informRepiarDetailsRepository.findById(informdetails_id).orElse(null);
    }


    public List<InformRepairDetails> saveInformRepairDetails(List<Map<String, String>> dataList) {
        List<InformRepairDetails> savedDetailsList = new ArrayList<>();


        for (Map<String, String> map : dataList) {
            String amountStr = map.get("amount");
            String details = map.get("details");
            Integer informrepair_id = Integer.parseInt(map.get("informrepair_id"));
            InformRepair informRepair = informRepairRepository.getReferenceById(informrepair_id);

            Integer amount = Integer.parseInt(amountStr);

            InformRepairDetails informRepairDetails = new InformRepairDetails();
            informRepairDetails.setAmount(amount);
            informRepairDetails.setDetails(details);

             Integer informdetails_id = generateInformRepairDetailsId(informRepiarDetailsRepository.count() + 1);
             informRepairDetails.setInformdetails_id(informdetails_id);

            informRepairDetails.setInformRepair(informRepair);

            Integer equipment_id = Integer.parseInt(map.get("equipment_id"));
            Integer room_id = Integer.parseInt(map.get("room_id"));
            RoomEquipmentId roomEquipmentId = new RoomEquipmentId(equipment_id, room_id);

            RoomEquipment roomEquipment = (RoomEquipment) roomEquipmentRepository.findById(roomEquipmentId).orElse(null);

            if (roomEquipment == null) {
                roomEquipment = new RoomEquipment();
                roomEquipment.setRoomEquipmentId(roomEquipmentId);
                roomEquipmentRepository.save(roomEquipment);
            }

            informRepairDetails.setRoomEquipment(roomEquipment);

            // บันทึกข้อมูลแต่ละรายการแยกกัน
            InformRepairDetails savedInformRepairDetails = informRepiarDetailsRepository.save(informRepairDetails);

            // Update "status" in RoomEquipment
            String status = map.get("status");

            if (roomEquipment != null) {
                roomEquipment.setStatus(status);
                roomEquipmentRepository.save(roomEquipment);
            } else {
                // Create RoomEquipment and set "status" if it doesn't exist
                roomEquipment = new RoomEquipment();
                roomEquipment.setRoomEquipmentId(roomEquipmentId);
                roomEquipment.setStatus(status);
                roomEquipmentRepository.save(roomEquipment);
            }

            savedDetailsList.add(savedInformRepairDetails);
        }

        return savedDetailsList;
    }



    public InformRepairDetails updateInformRepairDetails (Map<String, String> map) {
        Integer informdetails_id = Integer.parseInt(map.get("informdetails_id"));
        String amountStr = map.get("amount");
        String details = map.get("details");
        Integer informrepair_id = Integer.parseInt(map.get("informrepair_id"));
        InformRepair informRepair = informRepairRepository.getReferenceById(informrepair_id);

        Integer amount = Integer.parseInt(amountStr);

        InformRepairDetails informRepairDetails = new InformRepairDetails();
        informRepairDetails.setAmount(amount);
        informRepairDetails.setDetails(details);
        informRepairDetails.setInformdetails_id(informdetails_id);
        informRepairDetails.setInformRepair(informRepair);

        Integer equipment_id = Integer.parseInt(map.get("equipment_id"));
        Integer room_id = Integer.parseInt(map.get("room_id"));
        RoomEquipmentId roomEquipmentId = new RoomEquipmentId(equipment_id, room_id);

        RoomEquipment roomEquipment = (RoomEquipment) roomEquipmentRepository.findById(roomEquipmentId).orElse(null);

        if (roomEquipment != null) {
            // อัปเดต "status" ใน RoomEquipment หากมีอยู่แล้ว
            String status = map.get("status");
            roomEquipment.setStatus(status);
        } else {
            // สร้าง RoomEquipment และตั้งค่า "status" หากไม่มีอยู่
            roomEquipment = new RoomEquipment();
            roomEquipment.setRoomEquipmentId(roomEquipmentId);
            String status = map.get("status");
            roomEquipment.setStatus(status);
        }

        informRepairDetails.setRoomEquipment(roomEquipment);

        InformRepairDetails savedInformRepairDetails = informRepiarDetailsRepository.save(informRepairDetails);

        return savedInformRepairDetails;
    }



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
    public InformRepairDetails getInformRepairDetailsById(Integer informdetails_id) {
        return informRepiarDetailsRepository.getReferenceById(informdetails_id);
    }


    @Override
    public InformRepairDetails deleteInformRepairDetailsById(Integer informdetails_id) {
        InformRepairDetails informRepairDetails = informRepiarDetailsRepository.getReferenceById(informdetails_id);
        informRepiarDetailsRepository.delete(informRepairDetails);
        return informRepairDetails;
    }

    public List<Map<String, Object>> getInformRepairDetails() {
        List<Map<String, Object>> result = new ArrayList<>();

        List<Object[]> queryResult = informRepiarDetailsRepository.findAllDetailsWithSumAndDate();

        for (Object[] row : queryResult) {
            Map<String, Object> details = new HashMap<>();
            details.put("informrepair_id", row[0]);
            details.put("TotalAmount", row[1]);
            details.put("Status", row[2]);
            details.put("InformDate", row[3]);

            result.add(details);
        }

        return result;
    }

    @Override
    public List<InformRepairDetails> findViewInformDetailsById(int informrepair_id) {
        return informRepiarDetailsRepository.findAllDetailsByInformRepairId(informrepair_id);
    }

    @Override
    public List<InformRepairDetails> ViewListInformDetails(int informrepair_id) {
        return informRepiarDetailsRepository.ViewListInformDetails(informrepair_id);
    }















}
