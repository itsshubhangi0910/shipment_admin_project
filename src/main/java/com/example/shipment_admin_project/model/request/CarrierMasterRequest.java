package com.example.shipment_admin_project.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
public class CarrierMasterRequest {
    private Long carrierId;
    private String name;
    private String description;
    private MultipartFile logo;
}
