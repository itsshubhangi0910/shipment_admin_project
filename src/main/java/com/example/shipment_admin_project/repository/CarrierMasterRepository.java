package com.example.shipment_admin_project.repository;

import com.example.shipment_admin_project.model.CarrierMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrierMasterRepository extends JpaRepository<CarrierMaster,Long> {

    @Query(value = "select * from sp_carrier_master",nativeQuery = true)
    Page<CarrierMaster> getAllCarrierMaster(Pageable pageable);
}
