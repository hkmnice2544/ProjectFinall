package org.itsci.informrepair.service;

import org.itsci.informrepair.model.Building;
import org.itsci.informrepair.model.InformRepair;
import org.itsci.informrepair.model.InformRepairDetails;

import java.util.List;
import java.util.Map;

public interface InformRepairDetailsService {
    List<InformRepairDetails> getAllInformRepairDetails();

    InformRepairDetails getInformRepairDetailsById(Integer informdetails_id);

    List<InformRepairDetails> saveInformRepairDetails(List<Map<String, String>> dataList);

//    List<InformRepairDetails> updateInformRepairDetails(List<Map<String, String>> dataList);
}
