package com.example.shipment_admin_project.repository;

import com.example.shipment_admin_project.model.StateMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StateMasterRepository extends JpaRepository<StateMaster,Long> {

    @Query(value = "select * from states",nativeQuery = true)
    Page<StateMaster> getAllStateMaster(Pageable pageable);
}
