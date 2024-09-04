package com.example.shipment_admin_project.service.impl;

import com.example.shipment_admin_project.model.Admin;
import com.example.shipment_admin_project.repository.AdminRepository;
import com.example.shipment_admin_project.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService implements IAdminService {

    @Autowired
    private AdminRepository adminRepository;
    @Override
    public Object adminSignUp(String email, String password) {
        Admin admin = new Admin();
        admin.setEmail(email);
        admin.setPassword(password);
        admin.setIsActive(true);
        admin.setIsDeleted(false);
        adminRepository.save(admin);
        return "Admin registered successfully";
    }

    @Override
    public Object login(String email, String password) {
        if (adminRepository.existsByEmail(email)){
            Admin admin = adminRepository.findByEmail(email);
            if (admin.getPassword().equals(password)){
                return "admin login successfully";
            }else {
                return "login failed";
            }
        }
        return "admin not found";
    }
}
