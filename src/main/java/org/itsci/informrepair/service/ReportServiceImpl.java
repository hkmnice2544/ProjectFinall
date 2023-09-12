package org.itsci.informrepair.service;

import org.itsci.informrepair.model.InformRepair;
import org.itsci.informrepair.model.Reportrepair;
import org.itsci.informrepair.model.Review;
import org.itsci.informrepair.repository.InformRepairRepository;
import org.itsci.informrepair.repository.ReportrepairRepository;
import org.itsci.informrepair.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportrepairService {

    @Autowired
    private ReportrepairRepository reportrepairRepository;

    @Autowired
    private InformRepairRepository informRepairRepository;

    @Autowired
    private ReviewRepository reviewRepository;
    @Override
    public List<Reportrepair> getAllReportrepairs() {
        return reportrepairRepository.findAll();
    }

    @Override
    public Reportrepair getReportrepairById(Integer report_id) {
        return reportrepairRepository.getReferenceById(report_id);
    }

    @Override
    public Reportrepair saveReportrepair(Map<String, String> map) {
        Integer report_id = generateReportRepairId(reportrepairRepository.count()+1);// หาค่า report_id ล่าสุด

        if (report_id <= 0) {
            // กรณีค่า report_id เป็น 0 หรือน้อยกว่า 0 ให้ทำการจัดการใหม่ที่นี่
            // ยกเลิกการบันทึกหรือทำการแจ้งเตือนเพื่อแก้ไขปัญหา
            return null;
        }

        String repairer = map.get("repairer");
        String details = map.get("details");
        Date reportdate = new Date();
        Date enddate = new Date();

        Integer informrepair_id = Integer.parseInt(map.get("informrepair_id"));
        InformRepair informRepair = informRepairRepository.getReferenceById(informrepair_id);

        if (informRepair == null) {
            // กรณีไม่พบ InformRepair ที่ต้องการ
            // ทำการจัดการใหม่ที่นี่
            // ยกเลิกการบันทึกหรือทำการแจ้งเตือนเพื่อแก้ไขปัญหา
            return null;
        }

        Reportrepair reportrepair = new Reportrepair(report_id, repairer, reportdate, enddate, details, informRepair);
        return reportrepairRepository.save(reportrepair);
    }


    @Override
    public Reportrepair updateReportrepair(Map<String, String> map) {
        Integer report_id = Integer.parseInt(map.get("report_id"));
        String repairer = map.get("repairer");
        String details = map.get("details");
        Date reportdate = new Date();
        Date enddate = new Date();
        Integer informrepair_id = Integer.parseInt(map.get("informrepair_id"));
        InformRepair informRepair = informRepairRepository.getReferenceById(informrepair_id);
        Reportrepair reportrepair = new Reportrepair(report_id,repairer,reportdate,enddate,details,informRepair);
        return reportrepairRepository.save(reportrepair);
    }

    @Override
    public void deleteReportrepair(Integer report_id) {
        Reportrepair reportrepair = reportrepairRepository.getReferenceById(report_id);
        reportrepairRepository.delete(reportrepair);

    }
    public Integer generateReportRepairId(long report_id){
        Integer result = Integer.parseInt(Long.toString(report_id));
        result =  10000 + result;
        return result;
    }
}
