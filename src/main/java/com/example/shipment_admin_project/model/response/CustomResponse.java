package com.example.shipment_admin_project.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CustomResponse {
    private Object response;
    private Integer status;

}
