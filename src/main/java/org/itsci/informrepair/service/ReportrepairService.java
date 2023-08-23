package org.itsci.informrepair.service;

import org.itsci.informrepair.model.Reportrepair;

import java.util.List;
import java.util.Map;

public interface ReportrepairService {
    List<Reportrepair> getAllReportrepairs();
    Reportrepair getReportrepairById(Integer report_id);
    Reportrepair saveReportrepair(Map<String, String> map);
    Reportrepair updateReportrepair(Map<String, String> map);
//    String uploadInformRepairImg (MultipartFile file) throws IOException;

    //    Path downloadPostImg (String filePath) ;
    void deleteReportrepair(Integer report_id);
}
