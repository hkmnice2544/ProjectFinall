package org.itsci.informrepair.service;

import org.itsci.informrepair.model.Equipment;
import org.itsci.informrepair.model.InformRepair;

import java.util.List;
import java.util.Map;

public interface InformRepairService { //เหมือนManager
    List<InformRepair> getAllInformRepairs();

    InformRepair getInformRepairById(Integer informrepair_id);
//
//    InformRepair saveInformRepair(Map<String, String> map);
//
//    int findSumamountById(int informrepair_id);
//
//    int findInformDetailIDById(int informrepair_id);
//
//    InformRepair saveRoomEquipment(Map<String, String> map);


//    InformRepair getInformEquip(Map<String, String> map);

    InformRepair saveInformRepair(Map<String, String> map);


//    List<InformRepair> saveInformRepair(List<Map<String, String>> informRepairDataList);
//
    InformRepair updateInformRepair(Map<String, String> map);
////    String uploadInformRepairImg (MultipartFile file) throws IOException;

    //    Path downloadPostImg (String filePath) ;
    InformRepair deleteInformRepair(Integer informrepair_id);

    List<InformRepair> ViewListByinformrepair_id(int informrepair_id);

//    Object getEquipmentFromInformRepair(Integer informrepairId);
}


