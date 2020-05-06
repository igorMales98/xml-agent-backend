package com.xml.repository;

import com.xml.model.RentRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentRequestRepository extends JpaRepository<RentRequest, Long> {

    @Query(value = "SELECT * FROM rent_request rr WHERE rr.status = 'PAID'", nativeQuery = true)
    List<RentRequest> getFinishedRents();
}
