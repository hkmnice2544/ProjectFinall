package org.itsci.informrepair.service;

import org.itsci.informrepair.model.Report_pictures;
import org.itsci.informrepair.repository.Report_picturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Report_picturesServicelmpl implements Report_picturesService{
    @Autowired
    private Report_picturesRepository reportPicturesRepository;


    @Override
    public List<Report_pictures> ListReport_pictures() {
        return reportPicturesRepository.findAll();
    }
    @Override
    public List<Report_pictures> getReportPicturesByReportpicturesId(Integer report_id) {
        return reportPicturesRepository.findByReportpicturesId(report_id);
    }


    public List<Report_pictures> saveReport_pictures(List<Report_pictures> Report_picturesList) {
        List<Report_pictures> savedsaveReport_pictures = new ArrayList<>();

        for (Report_pictures Report_pictures : Report_picturesList) {
            long nextId = reportPicturesRepository.count() + 1;
            Integer reportpictures_id = generateReport_picturesId(nextId);
            Report_pictures.setReportpictures_id(reportpictures_id);

            // บันทึกข้อมูลรูปภาพลงในฐานข้อมูลและเก็บใน savedInformPictures
            savedsaveReport_pictures.add(reportPicturesRepository.save(Report_pictures));
        }

        return savedsaveReport_pictures;
    }
    public Integer generateReport_picturesId(long nextId) {
        int result = (int) nextId;
        result = 1000 + result;
        return result;
    }





}
