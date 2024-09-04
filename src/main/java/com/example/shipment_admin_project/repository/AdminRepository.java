package com.example.shipment_admin_project.repository;

import com.example.shipment_admin_project.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Long> {
    boolean existsByEmail(String email);

    Admin findByEmail(String email);
}
