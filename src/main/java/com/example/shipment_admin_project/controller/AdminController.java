package com.example.shipment_admin_project.controller;

import com.example.shipment_admin_project.model.response.CustomResponse;
import com.example.shipment_admin_project.model.response.EntityResponse;
import com.example.shipment_admin_project.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IAdminService iAdminService;

    @PostMapping("/adminSignUp")
    public ResponseEntity<?>adminSignUp(@RequestParam String email, @RequestParam String password){
        try{
            return new ResponseEntity<>(new CustomResponse(iAdminService.adminSignUp(email,password),0), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new EntityResponse(e.getMessage(),-1),HttpStatus.OK);
        }
    }
    @GetMapping("/login")
    public ResponseEntity<?>login(@RequestParam String email,String password){
        try{
            return new ResponseEntity<>(new CustomResponse(iAdminService.login(email,password),0),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new EntityResponse(e.getMessage(),-1),HttpStatus.OK);
        }
    }



}
