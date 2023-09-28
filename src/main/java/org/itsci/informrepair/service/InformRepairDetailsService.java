package org.itsci.informrepair.service;

import org.itsci.informrepair.model.InformRepairDetails;

import java.util.List;
import java.util.Map;

public interface InformRepairDetailsService {
    List<InformRepairDetails> getAllInformRepairDetails();

    InformRepairDetails getInformRepairDetailsById(Integer informdetails_id);

    List<InformRepairDetails> saveInformRepairDetails(List<Map<String, String>> dataList);

    InformRepairDetails updateInformRepairDetails(Map<String, String> map);

    InformRepairDetails deleteInformRepairDetailsById(Integer informdetailsId);


    List<Map<String, Object>> getInformRepairDetails();

    List<Object[]> findViewInformDetailsById(int informrepair_id) ;


}
