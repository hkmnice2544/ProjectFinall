package org.itsci.informrepair.service;

import org.itsci.informrepair.model.*;
import org.itsci.informrepair.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
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


    @Override
    public List<Reportrepair> getAllReportrepairs() {
        return reportrepairRepository.findAll();
    }


    @Override
    public Reportrepair getReportrepairById(Integer report_id) {
        return reportrepairRepository.getReferenceById(report_id);
    }

    @Override
    public List<Reportrepair> findViewInformRepairDetailsById(int informdetails_id) {
        return reportrepairRepository.findAllDetailsByInformRepairId(informdetails_id);
    }



    @Override
    public Reportrepair saveReportrepair(Map<String, String> map) {
        Integer report_id = generateReportRepairId(reportrepairRepository.count() + 1);
        String repairer = map.get("repairer");
        Date reportdate = new Date();
        String details = map.get("details");
        String status = map.get("status");
        Integer informrepair_id = Integer.parseInt(map.get("informrepair_id"));
        InformRepair informRepairs = informRepairRepository.getReferenceById(informrepair_id);


        // เริ่มต้นการสร้าง Reportrepair
        Reportrepair reportrepair = new Reportrepair(report_id, repairer, reportdate, details, status,informRepairs);

        // บันทึก Reportrepair ใหม่
        Reportrepair savedReportrepair = reportrepairRepository.save(reportrepair);

        String newStatus = map.get("status"); // ดึงค่า status ใหม่จาก Map

        InformRepair informRepair = informRepairRepository.findById(informrepair_id).orElse(null); // ค้นหา informRepair โดยใช้ informrepair_id

        if (informRepair != null) {
            informRepair.setStatus(newStatus); // อัปเดตค่า status ใน informRepair
            informRepairRepository.save(informRepair); // บันทึกการเปลี่ยนแปลงลงในฐานข้อมูล
        } else {
            // คุณอาจจะต้องจัดการข้อผิดพลาดหากไม่พบ informRepair ที่ถูกต้อง
            // เช่น สร้างข้อความผิดพลาดหรือการจัดการข้อผิดพลาดอื่น ๆ ตามสภาพความเป็นจริงของแอปของคุณ
        }


        return savedReportrepair;
    }

    @Override
    public Reportrepair updateReportrepair(Map<String, String> map) {
        Integer report_id = Integer.parseInt(map.get("report_id"));
        String repairer = map.get("repairer");
        Date reportdate = new Date();
        String details = map.get("details");
        String status = map.get("status");
        Integer informrepair_id = Integer.parseInt(map.get("informrepair_id"));
        InformRepair informRepairs = informRepairRepository.getReferenceById(informrepair_id);


        // เริ่มต้นการสร้าง Reportrepair
        Reportrepair reportrepair = new Reportrepair(report_id, repairer, reportdate, details, status,informRepairs);

        // บันทึก Reportrepair ใหม่
        Reportrepair savedReportrepair = reportrepairRepository.save(reportrepair);

        String newStatus = map.get("status"); // ดึงค่า status ใหม่จาก Map

        InformRepair informRepair = informRepairRepository.findById(informrepair_id).orElse(null); // ค้นหา informRepair โดยใช้ informrepair_id

        if (informRepair != null) {
            informRepair.setStatus(newStatus); // อัปเดตค่า status ใน informRepair
            informRepairRepository.save(informRepair); // บันทึกการเปลี่ยนแปลงลงในฐานข้อมูล
        } else {
            // คุณอาจจะต้องจัดการข้อผิดพลาดหากไม่พบ informRepair ที่ถูกต้อง
            // เช่น สร้างข้อความผิดพลาดหรือการจัดการข้อผิดพลาดอื่น ๆ ตามสภาพความเป็นจริงของแอปของคุณ
        }
        // คืนค่า Reportrepair
        return reportrepair;
    }

//    @Override
//    public void deleteReportrepair(Integer report_id) {
//        Reportrepair reportrepair = reportrepairRepository.getReferenceById(report_id);
//        reportrepairRepository.delete(reportrepair);
//
//    }
//
//
    public Integer generateReportRepairId(long report_id){
        Integer result = Integer.parseInt(Long.toString(report_id));
        result =  10000 + result;
        return result;
    }
}
