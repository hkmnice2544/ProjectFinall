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
        Integer report_id = generateReportRepairId(reportrepairRepository.count()+1);
        String repairer = map.get("repairer");
        String details = map.get("details");
        Date reportdate = new Date();
        Date enddate = new Date();
        String status = map.get("status");
        Integer informrepair_id = Integer.parseInt(map.get("informrepair_id"));
        InformRepair informRepair = informRepairRepository.getReferenceById(informrepair_id);
        Reportrepair reportrepair = new Reportrepair(report_id,repairer,reportdate,enddate,details,status,informRepair);
        return reportrepairRepository.save(reportrepair);
    }

    @Override
    public Reportrepair updateReportrepair(Map<String, String> map) {
        Integer report_id = Integer.parseInt(map.get("report_id"));
        String repairer = map.get("repairer");
        String details = map.get("details");
        Date reportdate = new Date();
        Date enddate = new Date();
        String status = map.get("status");
        Integer informrepair_id = Integer.parseInt(map.get("informrepair_id"));
        InformRepair informRepair = informRepairRepository.getReferenceById(informrepair_id);
        Reportrepair reportrepair = new Reportrepair(report_id,repairer,reportdate,enddate,details,status,informRepair);
        return reportrepairRepository.save(reportrepair);
    }

    @Override
    public void deleteReportrepair(Integer report_id) {
        Reportrepair reportrepair = reportrepairRepository.getReferenceById(report_id);
        reportrepairRepository.delete(reportrepair);

    }
    public Integer generateReportRepairId(long rewId){
        Integer result = Integer.parseInt(Long.toString(rewId));
        result =  10000 + result;
        return result;
    }
}
