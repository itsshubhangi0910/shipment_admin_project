package com.example.shipment_admin_project.service;

import org.springframework.stereotype.Service;


public interface IAdminService {
    Object adminSignUp(String email, String password);

    Object login(String email, String password);
}
