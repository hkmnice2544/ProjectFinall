package org.itsci.informrepair.service;

import org.itsci.informrepair.model.Report_pictures;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public interface Report_picturesService {

    List<Report_pictures> ListReport_pictures();

    List<Report_pictures> saveReport_pictures(List<Report_pictures> Report_picturesList);

    Report_pictures addReportPictures (Map<String, String> map);

    List<Report_pictures> getReportPicturesByReportpicturesId(Integer report_id);

    Path downloadImage(String filePath);
    String uploadImage(MultipartFile file) throws IOException;

    void deleteReportPictures (int reportpictures_id);
}
