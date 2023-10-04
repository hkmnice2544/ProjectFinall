//package org.itsci.informrepair.repository;
//
//import org.itsci.informrepair.model.Report_pictures;
//import org.itsci.informrepair.model.Review_pictures;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import java.util.List;
//
//public interface Review_picturesRepository  extends JpaRepository<Review_pictures,Integer> {
//
//    @Query(value = "select*from review_pictures where review_id = :review_id", nativeQuery = true)
//    List<Review_pictures> findByReview_picturesId(int review_id);
//}
