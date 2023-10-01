package org.itsci.informrepair.service;
import org.itsci.informrepair.model.Report_pictures;
import org.itsci.informrepair.model.Review_pictures;
import org.itsci.informrepair.repository.Report_picturesRepository;
import org.itsci.informrepair.repository.Review_picturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Review_picturesServicelmpl implements Review_picturesService {
    @Autowired
    private Review_picturesRepository reviewPicturesRepository;

    public List<Review_pictures> saveReview_pictures(List<Review_pictures> Review_picturesList ) {
        List<Review_pictures> savedsaveReview_pictures = new ArrayList<>();

        for (Review_pictures Review_pictures : Review_picturesList) {
            long nextId = reviewPicturesRepository.count() + 1;
            Integer Reviewpictures_id = generateReview_picturesId(nextId);
            Review_pictures.setReviewpictures_id(Reviewpictures_id);

            // บันทึกข้อมูลรูปภาพลงในฐานข้อมูลและเก็บใน savedInformPictures
            savedsaveReview_pictures.add(reviewPicturesRepository.save(Review_pictures));
        }

        return savedsaveReview_pictures;
    }
    public Integer generateReview_picturesId(long nextId) {
        int result = (int) nextId;
        result = 1000 + result;
        return result;
    }
}
