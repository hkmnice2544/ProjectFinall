package org.itsci.informrepair.repository;

import org.itsci.informrepair.model.Equipment;
import org.itsci.informrepair.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}
