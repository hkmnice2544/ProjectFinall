package org.itsci.informrepair.service;

import org.itsci.informrepair.model.Review;

import java.util.List;
import java.util.Map;

public interface ReviewService {
    List<Review> getAllReviews();
    Review getReviewById(Integer review_id);
    Review saveReview(Map<String, String> map);
    Review updateReview(Map<String, String> map);
//    String uploadInformRepairImg (MultipartFile file) throws IOException;

    //    Path downloadPostImg (String filePath) ;
    void deleteReview(Integer review_id);
}
