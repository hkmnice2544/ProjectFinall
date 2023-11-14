package org.itsci.informrepair.service;

import org.itsci.informrepair.model.Report_pictures;
import org.itsci.informrepair.model.Reportrepair;
import org.itsci.informrepair.repository.Report_picturesRepository;
import org.itsci.informrepair.repository.ReportrepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class Report_picturesServicelmpl implements Report_picturesService{
    @Autowired
    private Report_picturesRepository reportPicturesRepository;

    @Autowired
    private ReportrepairRepository reportrepairRepository;


    @Override
    public List<Report_pictures> ListReport_pictures() {
        return reportPicturesRepository.findAll();
    }
    @Override
    public List<Report_pictures> getReportPicturesByReportpicturesId(Integer report_id) {
        return reportPicturesRepository.findByReportpicturesId(report_id);
    }

    private final String imgPath = "C:\\Users\\HKMGF\\OneDrive - Maejo university\\Desktop\\New folder (3)\\flutterr\\images\\InformRepairs Pictures\\";

    @Override
    public Path downloadImage(String filePath) {
        return new File(imgPath + filePath).toPath();
    }

    @Override
    public void deleteReportPictures(int reportpictures_id) {
        reportPicturesRepository.deleteById(reportpictures_id);
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

    @Override
    public Report_pictures addReportPictures(Map<String, String> map) {
        long nextId = reportPicturesRepository.count() + 1;
        Integer reportpictures_id = generateReport_picturesId(nextId);

        int reportrepair_id = Integer.parseInt(map.get("report_id"));
        Reportrepair reportrepair = reportrepairRepository.getReferenceById(reportrepair_id);

        String picture_url = map.get("picture_url");



        Report_pictures reportPictures = new Report_pictures(reportpictures_id, picture_url, reportrepair);
        return reportPicturesRepository.save(reportPictures);
    }

    @Override
    public String uploadImage(MultipartFile file) throws IOException {
        System.out.println("FILE NAME IS : " + file.getOriginalFilename());
        String newFileName = System.currentTimeMillis() + ".png";
        file.transferTo(new File(imgPath + newFileName));
        return newFileName;
    }

    public Integer generateReport_picturesId(long nextId) {
        int result = (int) nextId;
        result = 1000 + result;
        return result;
    }





}
