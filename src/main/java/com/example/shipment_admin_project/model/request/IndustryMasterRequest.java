package com.example.shipment_admin_project.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class IndustryMasterRequest {
    private Long industryId;
    private String name;
    private String description;
}
