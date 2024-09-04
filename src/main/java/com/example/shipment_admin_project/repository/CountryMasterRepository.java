package com.example.shipment_admin_project.repository;

import com.example.shipment_admin_project.model.CountryMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryMasterRepository extends JpaRepository<CountryMaster,Long> {

    @Query(value = "SELECT  * FROM countries",nativeQuery = true)
    Page<CountryMaster> getAllCountryMaster(Pageable pageable);
}
