package com.xml.repository;

import com.xml.model.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarModelRepository extends JpaRepository<CarModel, Long> {

    @Query(value = "SELECT * FROM xml.car_model cm WHERE cm.car_brand_id = :modelId", nativeQuery = true)
    List<CarModel> getBrandModels(Long modelId);
}
