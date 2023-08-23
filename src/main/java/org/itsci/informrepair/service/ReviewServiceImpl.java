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
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ReportrepairRepository reportrepairRepository;

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Review getReviewById(Integer review_id) {

        return reviewRepository.getReferenceById(review_id);
    }

    @Override
    public Review saveReview(Map<String, String> map) {
        Integer review_id = generateReviewId(reviewRepository.count()+1);
        String reviewer = map.get("reviewer");
        String repairscore = map.get("repairscore");
        String comment = map.get("comment");
        Date reviewdate = new Date();
        Integer report_id = Integer.parseInt(map.get("report_id"));
        Reportrepair reportrepair = reportrepairRepository.getReferenceById(report_id);
        Review review = new Review(review_id,reviewer,reviewdate,repairscore,comment,reportrepair);
        return reviewRepository.save(review);
    }

    @Override
    public Review updateReview(Map<String, String> map) {
        Integer review_id = Integer.parseInt(map.get("review_id"));
        String reviewer = map.get("reviewer");
        String repairscore = map.get("repairscore");
        String comment = map.get("comment");
        Date reviewdate = new Date();
        Integer report_id = Integer.parseInt(map.get("report_id"));
        Reportrepair reportrepair = reportrepairRepository.getReferenceById(report_id);
        Review review = new Review(review_id,reviewer,reviewdate,repairscore,comment,reportrepair);
        return reviewRepository.save(review);
    }

    @Override
    public void deleteReview(Integer review_id) {
        Review review = reviewRepository.getReferenceById(review_id);
        reviewRepository.delete(review);

    }

    public Integer generateReviewId(long rewId){
        Integer result = Integer.parseInt(Long.toString(rewId));
        result =  10000 + result;
        return result;
    }
}
