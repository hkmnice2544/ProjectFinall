package org.itsci.informrepair.repository;

import org.itsci.informrepair.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Integer> {
}
