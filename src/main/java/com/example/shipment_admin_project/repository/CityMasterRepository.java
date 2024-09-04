package com.example.shipment_admin_project.repository;

import com.example.shipment_admin_project.model.CityMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CityMasterRepository extends JpaRepository<CityMaster,Long> {

    @Query(value = "SELECT c FROM CityMaster as c",nativeQuery = false)
    Page<CityMaster> getAllCityMaster(Pageable pageable);
}
