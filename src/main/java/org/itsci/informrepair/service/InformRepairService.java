package org.itsci.informrepair.service;

import org.itsci.informrepair.model.Equipment;
import org.itsci.informrepair.model.InformRepair;

import java.util.List;
import java.util.Map;

public interface InformRepairService { //เหมือนManager
    List<InformRepair> getAllInformRepairs();

    InformRepair getInformRepairById(Integer informrepair_id);

    InformRepair getInformEquip(Map<String, String> map);

//    InformRepair saveInformRepair(Map<String, String> map);

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
    List<InformRepair> saveInformRepair(List<Map<String, String>> informRepairDataList);

    InformRepair updateInformRepair(Map<String, String> map);
//    String uploadInformRepairImg (MultipartFile file) throws IOException;

    //    Path downloadPostImg (String filePath) ;
    InformRepair deleteInformRepair(Integer informrepair_id);

    Object getEquipmentFromInformRepair(Integer informrepairId);
}


