package com.xml.repository;

import com.xml.model.Pricelist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PricelistRepository extends JpaRepository<Pricelist, Long> {

    @Query(value = "SELECT * FROM pricelist WHERE pricelist.id = :id", nativeQuery = true)
    Pricelist findOneById(Long id);
}
