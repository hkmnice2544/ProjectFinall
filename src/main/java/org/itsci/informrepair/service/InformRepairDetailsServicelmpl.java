package org.itsci.informrepair.service;

import jakarta.transaction.Transactional;
import org.itsci.informrepair.model.*;
import org.itsci.informrepair.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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



//    public List<InformRepairDetails> updateInformRepairDetails(List<Map<String, String>> dataList) {
//        List<InformRepairDetails> savedDetailsList = new ArrayList<>();
//
//        Integer informdetails_id = Integer.parseInt(map.get("informdetails_id"));
//
//
//        for (Map<String, String> map : dataList) {
//            Integer informdetails_id = Integer.parseInt(map.get("informdetails_id"));
//            String amountStr = map.get("amount");
//            String details = map.get("details");
//            Integer informrepair_id = Integer.parseInt(map.get("informrepair_id"));
//            InformRepair informRepair = informRepairRepository.getReferenceById(informrepair_id);
//
//            Integer amount = Integer.parseInt(amountStr);
//
//            InformRepairDetails informRepairDetails = new InformRepairDetails();
//            informRepairDetails.setAmount(amount);
//            informRepairDetails.setDetails(details);
//            informRepairDetails.setInformdetails_id(informdetails_id);
//            informRepairDetails.setInformRepair(informRepair);
//
//            Integer equipment_id = Integer.parseInt(map.get("equipment_id"));
//            Integer room_id = Integer.parseInt(map.get("room_id"));
//            RoomEquipmentId roomEquipmentId = new RoomEquipmentId(equipment_id, room_id);
//
//            RoomEquipment roomEquipment = (RoomEquipment) roomEquipmentRepository.findById(roomEquipmentId).orElse(null);
//
//            if (roomEquipment != null) {
//                // Update "status" in RoomEquipment if it already exists
//                String status = map.get("status");
//                roomEquipment.setStatus(status);
//            } else {
//                // Create RoomEquipment and set "status" if it doesn't exist
//                roomEquipment = new RoomEquipment();
//                roomEquipment.setRoomEquipmentId(roomEquipmentId);
//                String status = map.get("status");
//                roomEquipment.setStatus(status);
//            }
//
//            informRepairDetails.setRoomEquipment(roomEquipment);
//
//            InformRepairDetails savedInformRepairDetails = informRepiarDetailsRepository.save(informRepairDetails);
//            savedDetailsList.add(savedInformRepairDetails);
//        }
//
//        return savedDetailsList;
//    }



    public Integer generateInformRepairDetailsId(long rewId) {
        int result = (int) rewId;
        result = 1000 + result;
        return result;
    }

    @Override
    public List<InformRepairDetails> getAllInformRepairDetails() {
        return null;
    }

    @Override
    public InformRepairDetails getInformRepairDetailsById(Integer informdetails_id) {
        return informRepiarDetailsRepository.getReferenceById(informdetails_id);
    }
//    @Override
//    @Transactional
//    public void deleteInformRepairDetailsById(Integer informdetails_id) {
//        // ลบข้อมูลในตาราง inform_pictures ที่มี informdetails_id เท่ากับ informdetails_id ที่ต้องการลบ
//        inform_picturesRepository.deleteByInformRepairDetailsInformdetails_id(informdetails_id);
//
//        // ลบข้อมูลในตาราง inform_repairdetails
//        informRepiarDetailsRepository.deleteById(informdetails_id);
//    }
}
