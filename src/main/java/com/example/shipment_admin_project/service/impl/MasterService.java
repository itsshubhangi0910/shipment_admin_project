package com.example.shipment_admin_project.service.impl;

import com.example.shipment_admin_project.model.*;
import com.example.shipment_admin_project.model.request.CarrierMasterRequest;
import com.example.shipment_admin_project.model.request.IndustryMasterRequest;
import com.example.shipment_admin_project.model.response.PageDto;
import com.example.shipment_admin_project.repository.*;
import com.example.shipment_admin_project.service.IMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class MasterService implements IMasterService {

    @Autowired
    private IndustryMasterRepository industryMasterRepository;

    @Autowired
    private CarrierMasterRepository carrierMasterRepository;

    @Autowired
    private StateMasterRepository stateMasterRepository;

    @Autowired
    private CountryMasterRepository countryMasterRepository;

    @Autowired
    private CityMasterRepository cityMasterRepository;

    @Override
    public Object saveOrUpdateMaster(IndustryMasterRequest industryMasterRequest) {
        if (industryMasterRepository.existsById(industryMasterRequest.getIndustryId())) {
            IndustryMaster industryMaster = industryMasterRepository.findById(industryMasterRequest.getIndustryId()).get();
            industryMaster.setName(industryMasterRequest.getName());
            industryMaster.setDescription(industryMasterRequest.getDescription());
            industryMasterRepository.save(industryMaster);
            return "updated";
        } else {
            IndustryMaster industryMaster = new IndustryMaster();
            industryMaster.setName(industryMasterRequest.getName());
            industryMaster.setDescription(industryMasterRequest.getDescription());
            industryMaster.setIsActive(true);
            industryMaster.setIsDeleted(false);
            industryMasterRepository.save(industryMaster);
            return "save data successfully";

        }
    }

    @Override
    public Object getMasterById(Long industryId) throws Exception {
        if (industryMasterRepository.existsById(industryId)){
            IndustryMaster industryMaster = industryMasterRepository.findById(industryId).get();
            return industryMaster;
        }else
          throw new Exception("id not found");
    }

    @Override
    public Object getAllMaster(Pageable pageable) {
        Page<IndustryMaster> industryMasterPage = industryMasterRepository.getAllIndustryMaster(pageable);
        return new PageDto(industryMasterPage.getContent(),industryMasterPage.getTotalElements(),industryMasterPage.getTotalPages(),industryMasterPage.getNumber());
    }

    @Override
    public Object deleteByMasterId(Long industryId) throws Exception {
        if (industryMasterRepository.existsById(industryId)){
            IndustryMaster industryMaster = industryMasterRepository.findById(industryId).get();
            industryMaster.setIsDeleted(true);
            industryMasterRepository.save(industryMaster);
            return "deleted";

        }else {
            throw new Exception("id not found");
        }
    }

    @Override
    public Object saveOrUpdateCarrierMaster(CarrierMasterRequest carrierMasterRequest) throws Exception {

        if (industryMasterRepository.existsById(carrierMasterRequest.getCarrierId())) {
            CarrierMaster carrierMaster = carrierMasterRepository.findById(carrierMasterRequest.getCarrierId()).get();
            carrierMaster.setName(carrierMasterRequest.getName());
            carrierMaster.setDescription(carrierMasterRequest.getDescription());
            carrierMasterRepository.save(carrierMaster);
            return "updated";
        } else {
            CarrierMaster carrierMaster = new CarrierMaster();
            carrierMaster.setName(carrierMasterRequest.getName());
            carrierMaster.setDescription(carrierMasterRequest.getDescription());
            carrierMaster.setIsActive(true);
            carrierMaster.setIsDeleted(false);
            carrierMasterRepository.save(carrierMaster);
            carrierMaster.setLogo(this.carrierLogoImage(carrierMasterRequest.getLogo()));
            carrierMasterRepository.save(carrierMaster);
            return "save data successfully";
        }
    }

    @Override
    public Object getCarrierById(Long carrierId) throws Exception {
        if (carrierMasterRepository.existsById(carrierId)){
            CarrierMaster carrierMaster = carrierMasterRepository.findById(carrierId).get();
            return carrierMaster;
        }else {
            throw new Exception("id not found");
        }
    }

    @Override
    public Object getAllCarrierMaster(Pageable pageable) {
        Page<CarrierMaster>carrierMasterPage = carrierMasterRepository.getAllCarrierMaster(pageable);
        return new PageDto(carrierMasterPage.getContent(),carrierMasterPage.getTotalElements(),carrierMasterPage.getTotalPages(),carrierMasterPage.getNumber());
    }

    @Override
    public Object deleteByCarrierId(Long carrierId) throws Exception {
        if (carrierMasterRepository.existsById(carrierId)){
            CarrierMaster carrierMaster = carrierMasterRepository.findById(carrierId).get();
            carrierMaster.setIsDeleted(true);
            carrierMasterRepository.save(carrierMaster);
            return "deleted";
        }else
        throw new Exception("id not found");
    }

    @Override
    public String carrierLogoImage(MultipartFile logo) throws Exception {
        if(logo!=null){
            String storagePath = "C:\\Users\\oms-desktop\\Pictures\\images";
            String originalFileName = logo.getOriginalFilename();
            Path path = Paths.get(storagePath,originalFileName);
            Files.write(path, logo.getBytes());
            return originalFileName;
        }else {
            throw new Exception("file not found");
        }
    }

    @Override
    public Object getAllStates(Pageable pageable) {
        Page<StateMaster>stateMasterPage = stateMasterRepository.getAllStateMaster(pageable);
        return new PageDto(stateMasterPage.getContent(),stateMasterPage.getTotalElements(),stateMasterPage.getTotalPages(),stateMasterPage.getNumber());
    }

    @Override
    public Object getByStateId(Long stateId) throws Exception {
        if (stateMasterRepository.existsById(stateId)){
            StateMaster stateMaster = stateMasterRepository.findById(stateId).get();
            return stateMaster;
        }else {
            throw new Exception("id not found");
        }
    }

    @Override
    public Object getAllCountries(Pageable pageable) {
        Page<CountryMaster>countryMasterPage = countryMasterRepository.getAllCountryMaster(pageable);
        return new PageDto(countryMasterPage.getContent(),countryMasterPage.getTotalElements(),countryMasterPage.getTotalPages(),countryMasterPage.getNumber());
    }

    @Override
    public Object getByCountryId(Long countryId) throws Exception {
        if (countryMasterRepository.existsById(countryId)) {
            CountryMaster countryMaster = countryMasterRepository.findById(countryId).get();
            return countryMaster;
        } else {
            throw new Exception("id not found");
        }
    }

    @Override
    public Object getAllCities(Pageable pageable) {
       // Page<CityMaster>cityMasterPage = cityMasterRepository.getAllCityMaster(pageable);
        Page<CityMaster> cityMasterPage = cityMasterRepository.getAllCityMaster(pageable);
        return new PageDto(cityMasterPage.getContent(),cityMasterPage.getTotalElements(),cityMasterPage.getTotalPages(),cityMasterPage.getNumber());
    }

    @Override
    public Object getByCityId(Long cityId) throws Exception {
        if (cityMasterRepository.existsById(cityId)){
            CityMaster cityMaster = cityMasterRepository.findById(cityId).get();
            return cityMaster;
        }else {
            throw new Exception("id not found");
        }
    }
}
