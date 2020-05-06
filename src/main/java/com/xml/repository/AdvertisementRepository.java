package com.xml.repository;

import com.xml.model.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {

    @Query(value = "SELECT * FROM advertisement a WHERE (:dateFrom BETWEEN a.available_from AND a.available_to) AND (:dateTo BETWEEN a.available_from AND a.available_to)", nativeQuery = true)
    List<Advertisement> getInPeriod(LocalDateTime dateFrom, LocalDateTime dateTo);

    List<Advertisement> getAdvertisementByAdvertiser_id(Long agentId);

    @Query(value = "SELECT COUNT(ra.advertisement_id) FROM rented_advertisements ra WHERE ra.advertisement_id IN (SELECT a.id FROM advertisement a WHERE a.car_id = :id)", nativeQuery = true)
    Integer getTimesRented(Long id);
}
