package com.example.shipment_admin_project.controller;

import com.example.shipment_admin_project.model.request.CarrierMasterRequest;
import com.example.shipment_admin_project.model.request.IndustryMasterRequest;
import com.example.shipment_admin_project.model.response.CustomResponse;
import com.example.shipment_admin_project.model.response.EntityResponse;
import com.example.shipment_admin_project.service.IMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@RestController
@RequestMapping("/masterApi")
public class MasterController {

    @Autowired
    private IMasterService iMasterService;

    @PostMapping("/saveOrUpdateIndustryMaster")
    public ResponseEntity<?>saveOrUpdateMaster(@RequestBody IndustryMasterRequest industryMasterRequest){
        try{
            return new ResponseEntity<>(new CustomResponse(iMasterService.saveOrUpdateMaster(industryMasterRequest),0), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new EntityResponse(e.getMessage(),-1),HttpStatus.OK);
        }
    }
    @GetMapping("/getIndustryMasterById")
    public ResponseEntity<?>getMasterById(@RequestParam Long industryId){
        try {
            return new ResponseEntity<>(new CustomResponse(iMasterService.getMasterById(industryId),0),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new EntityResponse(e.getMessage(),-1),HttpStatus.OK);
        }
    }
    @GetMapping("/getAllIndustryMaster")
    public ResponseEntity<?>getAllMaster(@RequestParam(value = "pageNumber",defaultValue = "0",required = false)Integer pageNumber,
                                         @RequestParam(value = "pageSize",defaultValue = "10",required = false)Integer pageSize){
        try{
            Pageable pageable = PageRequest.of(Optional.ofNullable(pageNumber).orElse(0),Optional.ofNullable(pageSize).orElse(30));
            return new ResponseEntity<>(new CustomResponse(iMasterService.getAllMaster(pageable),0),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new EntityResponse(e.getMessage(),-1),HttpStatus.OK);
        }
    }
    @DeleteMapping("/deleteByIndustryMasterId")
    public ResponseEntity<?>deleteByMasterId(@RequestParam Long industryId){
        try{
            return new ResponseEntity<>(new CustomResponse(iMasterService.deleteByMasterId(industryId),0),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new EntityResponse(e.getMessage(),-1),HttpStatus.OK);
        }
    }

    @PostMapping("/saveOrUpdateCarrierMaster")
    public ResponseEntity<?>saveOrUpdateCarrierMaster(@ModelAttribute CarrierMasterRequest carrierMasterRequest){
        try{
            return new ResponseEntity<>(new CustomResponse(iMasterService.saveOrUpdateCarrierMaster(carrierMasterRequest),0),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new EntityResponse(e.getMessage(),-1),HttpStatus.OK);
        }
    }
    @GetMapping("/getCarrierById")
    public ResponseEntity<?>getCarrierById(@RequestParam Long carrierId){
        try{
            return new ResponseEntity<>(new CustomResponse(iMasterService.getCarrierById(carrierId),0),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new EntityResponse(e.getMessage(),-1),HttpStatus.OK);
        }
    }
    @GetMapping("/getAllCarrierMaster")
    public ResponseEntity<?>getAllCarrierMaster(@RequestParam(value = "pageNumber",defaultValue = "0",required = false)Integer pageNumber,
                                                @RequestParam(value = "pageSize",defaultValue = "20",required = false)Integer pageSize){
        try{
            Pageable pageable = PageRequest.of(Optional.ofNullable(pageNumber).orElse(0),Optional.ofNullable(pageSize).orElse(20));
            return new ResponseEntity<>(new CustomResponse(iMasterService.getAllCarrierMaster(pageable),0),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new EntityResponse(e.getMessage(),-1),HttpStatus.OK);
        }
    }
    @DeleteMapping("/deleteByCarrierId")
    public ResponseEntity<?>deleteByCarrierId(@RequestParam Long carrierId){
        try{
            return new ResponseEntity<>(new CustomResponse(iMasterService.deleteByCarrierId(carrierId),0),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new EntityResponse(e.getMessage(),-1),HttpStatus.OK);
        }
    }
    @PostMapping("/carrierLogoImage")
    public ResponseEntity<?>carrierLogoImage(@ModelAttribute("logo")MultipartFile logo){
        try{
            return new ResponseEntity<>(new CustomResponse(iMasterService.carrierLogoImage(logo),0),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new EntityResponse(e.getMessage(),-1),HttpStatus.OK);
        }
    }
    @GetMapping("/getAllStates")
    public ResponseEntity<?>getAllStates(@RequestParam(value = "pageNumber",defaultValue = "0",required = false)Integer pageNumber,
                                         @RequestParam(value = "pageSize",defaultValue = "20",required = false)Integer pageSize){
        try{
            Pageable pageable = PageRequest.of(Optional.ofNullable(pageNumber).orElse(0),Optional.ofNullable(pageSize).orElse(20));
            return new ResponseEntity<>(new EntityResponse(iMasterService.getAllStates(pageable),0),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new CustomResponse(e.getMessage(),-1),HttpStatus.OK);
        }

    }
    @GetMapping("/getByStateId")
    public ResponseEntity<?>getByStateId(@RequestParam Long stateId){
        try{
            return new ResponseEntity<>(new EntityResponse(iMasterService.getByStateId(stateId),0),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new CustomResponse(e.getMessage(),-1),HttpStatus.OK);
        }
    }
    @GetMapping("/getAllCountries")
    public ResponseEntity<?>getAllCountries(@RequestParam(value = "pageNumber",defaultValue = "0",required = false)Integer pageNumber,
                                            @RequestParam(value = "pageSize",defaultValue = "50",required = false)Integer pageSize){
        try {
            Pageable pageable = PageRequest.of(Optional.ofNullable(pageNumber).orElse(0),Optional.ofNullable(pageSize).orElse(50));
            return new ResponseEntity<>(new EntityResponse(iMasterService.getAllCountries(pageable),0),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new CustomResponse(e.getMessage(),-1),HttpStatus.OK);
        }
    }
    @GetMapping("/getByCountryId")
    public ResponseEntity<?>getByCountryId(@RequestParam Long countryId){
        try {
            return new ResponseEntity<>(new EntityResponse(iMasterService.getByCountryId(countryId),0),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new CustomResponse(e.getMessage(),-1),HttpStatus.OK);
        }
    }
    @GetMapping("/getAllCities")
    public ResponseEntity<?>getAllCities(@RequestParam(value = "pageNumber",defaultValue = "0",required = false)Integer pageNumber,
                                         @RequestParam(value = "pageSize",defaultValue = "50",required = false)Integer pageSize){
        try{
            Pageable pageable = PageRequest.of(Optional.ofNullable(pageNumber).orElse(0),Optional.ofNullable(pageSize).orElse(50));
            return new ResponseEntity<>(new EntityResponse(iMasterService.getAllCities(pageable),0),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new CustomResponse(e.getMessage(),-1),HttpStatus.OK);
        }
    }
    @GetMapping("/getCityById")
    public ResponseEntity<?>getByCityId(@RequestParam Long cityId){
        try{
            return new ResponseEntity<>(new EntityResponse(iMasterService.getByCityId(cityId),0),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new CustomResponse(e.getMessage(),-1),HttpStatus.OK);
        }
    }



}
