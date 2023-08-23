package org.itsci.informrepair.service;

import org.itsci.informrepair.model.Equipment;
import org.itsci.informrepair.model.Room;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface EquipmentService {
    List<Equipment> getRoomEquipments();
    Equipment getEquipmentById(Integer equipment_id);
    Equipment saveEquipment(Map<String, String> map);
    Equipment updateEquipment(Map<String, String> map);
//    String uploadEquipmentImg (MultipartFile file) throws IOException;

    //    Path downloadPostImg (String filePath) ;
    Equipment deleteEquipment(Integer equipment_id);

    Set<Room> getRoomDoesNotHaveEquipment(Integer map);
}
