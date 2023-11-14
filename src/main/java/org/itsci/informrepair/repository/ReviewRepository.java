package org.itsci.informrepair.repository;

import org.itsci.informrepair.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ReviewRepository extends JpaRepository<Review,Integer> {
    @Query(value = "select count(*) from review where informrepair_id =  :informrepair_id",nativeQuery = true)
    int countReviewByInformrepair_id(int informrepair_id);
}
