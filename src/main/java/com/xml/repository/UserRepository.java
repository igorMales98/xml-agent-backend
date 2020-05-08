package com.xml.repository;

import com.xml.model.Customer;
import com.xml.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getOneById(Long idCommenter);

    User findOneById(Long id);
}
