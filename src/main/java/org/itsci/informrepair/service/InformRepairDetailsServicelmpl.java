package org.itsci.informrepair.service;

import jakarta.persistence.EntityManagerFactory;
import org.itsci.informrepair.model.*;
import org.itsci.informrepair.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import java.util.Date;
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

    @PersistenceContext
    private EntityManager entityManager; // ตั้งค่า EntityManager ด้วย @PersistenceContext

    @Override
    public List<InformRepairDetails> getAllInformRepairDetails() {
        return informRepiarDetailsRepository.findAll();
    }
    public InformRepairDetails saveInformRepairDetails(Map<String, String> map) {
        Integer informdetails_id = generateInformRepairDetailsId(informRepiarDetailsRepository.count() + 1);
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

        if (roomEquipment == null) {
            roomEquipment = new RoomEquipment();
            roomEquipment.setRoomEquipmentId(roomEquipmentId);
            roomEquipmentRepository.save(roomEquipment);
        }

        informRepairDetails.setRoomEquipment(roomEquipment);

        return informRepiarDetailsRepository.save(informRepairDetails);
    }



    public Integer generateInformRepairDetailsId(long rewId) {
        int result = (int) rewId;
        result = 1000 + result;
        return result;
    }
}
