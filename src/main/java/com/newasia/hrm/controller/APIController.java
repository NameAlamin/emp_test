package com.newasia.hrm.controller;

import com.newasia.hrm.model.Address;
import com.newasia.hrm.service.service_interface.IAddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class APIController {

    private final IAddressService addressService;

    public APIController(IAddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/getCityList/{id}")
    private ResponseEntity<List<Address>> getCityList(@PathVariable("id") Long id) {
        System.out.println(id);
        List<Address> allAddressByParentId = addressService.findAllAddressByParentId(id);
        return new ResponseEntity<>(allAddressByParentId, HttpStatus.OK);
    }
}
