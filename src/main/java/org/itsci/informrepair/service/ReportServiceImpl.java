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

    @Autowired
    private InformRepiarDetailsRepository informRepiarDetailsRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private RoomEquipmentRepository roomEquipmentRepository;
//
//    @Autowired
//    private ReviewRepository reviewRepository;


//    @Override
//    public List<Reportrepair> getAllReportrepairs() {
//        return reportrepairRepository.findAll();
//    }
//
//
//    @Override
//    public Reportrepair getReportrepairById(Integer report_id) {
//        return reportrepairRepository.getReferenceById(report_id);
//    }
//
//    @Override
//    public List<Reportrepair> findViewInformRepairDetailsById(int informdetails_id) {
//        return reportrepairRepository.findAllDetailsByInformRepairId(informdetails_id);
//    }



    @Override
    public Reportrepair saveReportrepair(Map<String, String> map) {
        Integer report_id = generateReportRepairId(reportrepairRepository.count() + 1);
        String repairer = map.get("repairer");
        Date reportdate = new Date();
        String details = map.get("details");
        String status = map.get("status");
        Date statusdate = new Date();
        Integer equipment_id = Integer.parseInt(map.get("equipment_id"));
        Integer room_id = Integer.parseInt(map.get("room_id"));
        Integer informrepair_id = Integer.parseInt(map.get("informrepair_id"));
        InformRepairDetailsID informRepairDetailsID = new InformRepairDetailsID(equipment_id, room_id, informrepair_id);

        // สร้าง InformRepairDetails จาก informRepairDetailsID
        InformRepairDetails informRepairDetails = new InformRepairDetails();
        informRepairDetails.setId(informRepairDetailsID);

        // เริ่มต้นการสร้าง Reportrepair
        Reportrepair reportrepair = new Reportrepair(report_id, repairer, reportdate, details, status, statusdate, informRepairDetails);

        // บันทึก Reportrepair ใหม่
        Reportrepair savedReportrepair = reportrepairRepository.save(reportrepair);

        // อัปเดตค่า status ใน InformRepair

        return savedReportrepair;
    }




    //
//
//    @Override
//    public Reportrepair updateReportrepair(Map<String, String> map) {
//        Integer report_id = Integer.parseInt(map.get("report_id"));
//        String repairer = map.get("repairer");
//        String details = map.get("details");
//        Date reportdate = new Date();
//        Date enddate = new Date();
//        Integer informrepair_id = Integer.parseInt(map.get("informrepair_id"));
//        InformRepair informRepair = informRepairRepository.getReferenceById(informrepair_id);
//
//        // สร้าง Reportrepair ใหม่
//        Reportrepair reportrepair = new Reportrepair(report_id, repairer, reportdate, enddate, details, informRepair);
//
//        // อัปเดตค่า informRepair!.status
//        informRepair.setStatus(map.get("status"));
//
//        // บันทึกการเปลี่ยนแปลงในฐานข้อมูล
//        informRepairRepository.save(informRepair);
//
//        // คืนค่า Reportrepair
//        return reportrepair;
//    }
//
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
