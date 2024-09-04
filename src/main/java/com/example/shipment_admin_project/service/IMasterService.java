package com.example.shipment_admin_project.service;

import com.example.shipment_admin_project.model.request.CarrierMasterRequest;
import com.example.shipment_admin_project.model.request.IndustryMasterRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface IMasterService {
    Object saveOrUpdateMaster(IndustryMasterRequest industryMasterRequest);

    Object getMasterById(Long industryId) throws Exception;

    Object getAllMaster(Pageable pageable);

    Object deleteByMasterId(Long industryId) throws Exception;

    Object saveOrUpdateCarrierMaster(CarrierMasterRequest carrierMasterRequest) throws Exception;

    Object getCarrierById(Long carrierId) throws Exception;

    Object getAllCarrierMaster(Pageable pageable);

    Object deleteByCarrierId(Long carrierId) throws Exception;

    String carrierLogoImage(MultipartFile logo) throws Exception;

    Object getAllStates(Pageable pageable);

    Object getByStateId(Long stateId) throws Exception;

    Object getAllCountries(Pageable pageable);

    Object getByCountryId(Long countryId) throws Exception;

    Object getAllCities(Pageable pageable);

    Object getByCityId(Long cityId) throws Exception;
}
