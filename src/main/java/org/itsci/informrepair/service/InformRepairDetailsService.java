package org.itsci.informrepair.service;

import org.itsci.informrepair.model.Building;
import org.itsci.informrepair.model.InformRepair;
import org.itsci.informrepair.model.InformRepairDetails;

import java.util.List;
import java.util.Map;

public interface InformRepairDetailsService {
    List<InformRepairDetails> getAllInformRepairDetails();

    InformRepairDetails saveInformRepairDetails(Map<String, String> map);

    InformRepairDetails updateInformRepairDetails(Map<String, String> map);

    InformRepairDetails getInformRepairDetailsById(Integer informdetails_id);

}
